import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public abstract class Map {
    
    protected String[][] board;
    protected String[][] boardMask;
    private boolean horizontal;
    private boolean vertical;

    final static ArrayList<String> menuItems = new ArrayList<>(Arrays.asList("Aircraft Carrier", "Battleship ", "Submarine", "Cruiser", "Destroyer"));
    final static ArrayList<Integer> menuCells = new ArrayList<>(Arrays.asList(5, 4, 3 ,3, 2));
    final static ArrayList<Integer> subNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    final static ArrayList<Character> subLetters = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'));
    final static ArrayList<Integer[]> shipCoordinates = new ArrayList<>(); 

    public Map() {
        board = new String[11][11];
        boardMask = new String[11][11];

        for (int i = 0; i < board.length; i++) {
            if (i == 0) {
                board[0][i] = String.valueOf(" ");
                continue;
            }
            board[0][i] = String.valueOf(i);

        }
        char letters = 'A';
        for (int i = 1; i < board.length; i++) {
            
            board[i][0] = String.valueOf(letters++);
        }
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board.length; j++) {
                board[i][j] = "~";
                
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                boardMask[i][j] = board[i][j];
                
            }
        }
    }
    
    protected void printBoard() {
        for (String[] strings : board) {
            for (String a : strings) {
                System.out.print(a  + " ");
            }
            System.out.println();
        }
    }

    protected void printMask() {
        for (String[] strings : boardMask) {
            for (String a : strings) {
                System.out.print(a  + " ");
            }
            System.out.println();
        }
    }

    protected void setPiece(int first, int second, int cFirst, int cSecond) {
        //                              2       2             6         2
        if (vertical) {
            int pair = first = second;
            shipCoordinates.add(new Integer[] {first, cFirst, cSecond, 0});

                for (int i = cFirst; i <= cSecond; i++) {
                    board[i][pair] = "O";
                    
                }     
            vertical = false;
            
        } else if (horizontal) {
            int pair = cFirst = cSecond;
            shipCoordinates.add(new Integer[] {cFirst, first, second, 1});

                for (int i = first; i <= second; i++) {
                    board[pair][i] = "O";

                }
            horizontal = false;
        
        }
        
    }

    protected void setShot(int letter, int number) {
        
        if (board[letter][number].equals("O")) {
            board[letter][number] = "X";
            boardMask[letter][number] = "X";
            
            System.out.println();
            System.out.println("You hit a ship!");
    
        } else {
            board[letter][number] = "M";
            boardMask[letter][number] = "M";

            System.out.println();
            System.out.println("You missed.");

        }
        
    }

    protected static void printBattlefield(boolean player1Turn, boolean player2Turn, Battleship player1, Battleship player2) {
        if (player1Turn) {
            player2.printMask();
            printLine();
            player1.printBoard();
            System.out.println();
            System.out.println("Player 1, it's your turn:");
            System.out.println();

        } else if (player2Turn) {
            player1.printMask();
            printLine();
            player2.printBoard();
            System.out.println();
            System.out.println("Player 2, it's your turn:");
            System.out.println();

        }
    }
    
    protected boolean checkCoordinates(int fNumber, int sNumber, int fLetter_num, int sLetter_num, int length, String piece, Battleship player) {
                                    //     4           6         4             4          
        boolean v = fNumber == sNumber; // false
        boolean vLength = sLetter_num + 1 - fLetter_num == length || sLetter_num - (fLetter_num - 1) == length; // false
        boolean h = fLetter_num == sLetter_num; // true
        boolean hLength = sNumber + 1 - fNumber == length || sNumber - (fNumber - 1) == length; // true
        
        if ((v && vLength) ^ (h && hLength)) {
            if (v) vertical = true;
            if (h) horizontal = true;
            

        } else if  (v && !vLength || h && !hLength) {
            System.out.println("Error! Wrong length of the "+ piece +"! Try again:");
            System.out.println();
            return false;

        } else {
            System.out.println("Error! Wrong ship location! Try again:");
            System.out.println();
            return false;
        }

        if (vertical) {
            
            int pair = fNumber = sNumber;

            for (int i = fLetter_num; i <= sLetter_num; i++) {
                if (checkOccupancyVertical(i, pair, player)) {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    System.out.println();

                    return false;

                }
            }

        } else if (horizontal) {
            
            int pair = fLetter_num = sLetter_num;

            for (int i = fNumber; i <= sNumber; i++) {
                if (checkOccupancyHorizontal(pair, i, player)) {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    System.out.println();
                    
                    return false;

                }
            }    
        }
        return true;

    }

    protected static boolean checkShotCoordinates(char letter, int number) {
        return (number < 10 || number > 1) || (letter < 'J' || letter > 'A');
    }
    
    protected boolean checkOccupancyVertical(int i, int pair, Battleship player) {
        boolean a = i - 1 >= 0;
        boolean b = i + 1 < player.board.length;
        boolean c = pair - 1 >= 0;
        boolean d = pair + 1 < player.board.length;

        boolean up = false, down = false, left = false, right = false;
          
        if (a) {
            up = player.board[i - 1][pair] == "O";
            
        }
        if (b) { 
            down = player.board[i + 1][pair] == "O";   

        }
        if (c) {
            left = player.board[i][pair - 1] == "O";

        } 
        if (d) {
            right = player.board[i][pair + 1] == "O";

        }
        
        return up || down || left || right;

    }

    protected boolean checkOccupancyHorizontal(int pair, int i, Battleship player) {
        boolean a = i - 1 >= 0;
        boolean b = i + 1 < player.board.length;
        boolean c = pair - 1 >= 0;
        boolean d = pair + 1 < player.board.length;

        boolean up = false, down = false, left = false, right = false;
            
        if (a) {
            left = player.board[pair][i - 1] == "O";

        }
        if (b) { 
            right = player.board[pair][i + 1] == "O";

        }
        if (c) {
            up = player.board[pair - 1][i] == "O";

        } 
        if (d) {
            down = player.board[pair + 1][i] == "O";

        }
        
        return up || down || left || right;

    } 
    
    protected boolean checkAllZeros(Battleship player) {
        for (int i = 1; i < player.board.length; i++) {
            for (int j = 1; j < player.board.length; j++) {
                if (board[i][j] == "O") {
                    return true;
                }    
            }
        }
        return false;
    }
    
    protected static void printPass(Scanner scan) {
        System.out.println("Press Enter and pass the move to another player");
        scan.nextLine();
    }
    
    protected static void printLine() {
        System.out.println("---------------------");
    }

    protected void checkBattleshipStatus(ArrayList<Integer[]> coordinates, Battleship player) {
        for (int i = 0; i < coordinates.size(); i++) {
            
            if (coordinates.get(i)[3] == 0) {
                int count = 0;

                for (int j = coordinates.get(i)[1]; j < coordinates.get(i)[2]; j++) {
                    if (player.board[j][coordinates.get(i)[0]] == "X") {
                        count++;

                    }
                    if (count == coordinates.get(i)[2] - coordinates.get(i)[1]) {
                        System.out.println("You sank a ship!");
                        coordinates.set(i, new Integer[] {0, 0, 0, 2});

                    }
                }
            }
            
            if (coordinates.get(i)[3] == 1) {
                int count = 0;

                for (int j = coordinates.get(i)[1]; j < coordinates.get(i)[2]; j++) {
                    if (player.board[coordinates.get(i)[0]][j] == "X") {
                        count++;

                    }
                    if (count == coordinates.get(i)[2] - coordinates.get(i)[1]) {
                        System.out.println("You sank a ship!");
                        coordinates.set(i, new Integer[] {0, 0, 0, 2});

                    }
                }
            } 
        }
    }
}
