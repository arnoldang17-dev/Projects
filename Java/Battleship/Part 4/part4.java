import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class part4 {
    private String[][] board;
    private String[][] boardMask;
    private boolean horizontal;
    private boolean vertical;

    public part4() {
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

    private void printBoard() {
        for (String[] strings : board) {
            for (String a : strings) {
                System.out.print(a  + " ");
            }
            System.out.println();
        }
    }

    private void printMask() {
        for (String[] strings : boardMask) {
            for (String a : strings) {
                System.out.print(a  + " ");
            }
            System.out.println();
        }
    }

    private void setPiece(int first, int second, int cFirst, int cSecond) {
        //                              2       2             6         2
        if (vertical) {
            int pair = first = second;

                for (int i = cFirst; i <= cSecond; i++) {
                    board[i][pair] = "O";

                }
            
            vertical = false;
            
        } else if (horizontal) {
            int pair = cFirst = cSecond;

                for (int i = first; i <= second; i++) {
                    board[pair][i] = "O";

                }
            horizontal = false;
        
        }
        
    }

    private void setPiece(int letter, int number) {
        
        if (board[letter][number].equals("O") || board[letter][number].equals("X")) {
            board[letter][number] = "X";
            boardMask[letter][number] = "X";
            
            printMask();
            System.out.println();
            System.out.println("You hit a ship! Try again:");
            System.out.println();


        } else {
            boardMask[letter][number] = "M";
            board[letter][number] = "M";

            printMask();
            System.out.println();
            System.out.println("You missed. Try again:");
            System.out.println();

        }
        
    } 
    
    private boolean checkCoordinates(int fNumber, int sNumber, int fLetter_num, int sLetter_num, int length, String piece) {
                                    // 9            8            2                 2
        boolean v = fNumber == sNumber; // false
        boolean vLength = sLetter_num + 1 - fLetter_num == length || fLetter_num + 1 - sLetter_num == length; // false
        boolean h = fLetter_num == sLetter_num; // true
        boolean hLength = sNumber + 1 - fNumber == length || fNumber + 1 - sNumber == length; //false
        
        if ((v && vLength) ^ (h && hLength)) {
            if (v) vertical = true;
            if (h) horizontal = true;
            

        } else if  (v && (vLength == false)|| h && (hLength == false)) {
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
                if (checkOccupancyVertical(i, pair)) {
                    System.out.println();
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    System.out.println();

                    return false;

                }
            }

        } else if (horizontal) {
            
            int pair = fLetter_num = sLetter_num;

            for (int i = fNumber; i <= sNumber; i++) {
                if (checkOccupancyHorizontal(pair, i)) {
                    System.out.println();
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    System.out.println();
                    
                    return false;

                }
            }    
        }
        return true;

    }

    private boolean checkCoordinates(char letter, int number) {
        if (number > 10 || number < 1 || letter > 'J' || letter < 'A') {
            return false;
        }
        return true;
    }
    
    private boolean checkOccupancyVertical(int i, int pair) {
        boolean a = i - 1 <= 0;
        boolean b = i + 1 < board.length;
        boolean c = pair - 1 <= 0;
        boolean d = pair + 1 < board.length;

        boolean up = false, down = false, left = false, right = false;
          
        if (a) {
            up = board[i - 1][pair] == "O";
            
        }
        if (b) { 
            down = board[i + 1][pair] == "O";   

        }
        if (c) {
            left = board[i][pair - 1] == "O";

        } 
        if (d) {
            right = board[i][pair + 1] == "O";

        }
        
        if (up || down || left || right) {
            return true;
            
        }
        return false;

    }

    private boolean checkOccupancyHorizontal(int pair, int i) {
        boolean a = i - 1 <= 0;
        boolean b = i + 1 < board.length;
        boolean c = pair - 1 <= 0;
        boolean d = pair + 1 < board.length;

        boolean up = false, down = false, left = false, right = false;
            
        if (a) {
            left = board[pair][i - 1] == "O";

        }
        if (b) { 
            right = board[pair][i + 1] == "O";

        }
        if (c) {
            up = board[pair - 1][i] == "O";

        } 
        if (d) {
            down = board[i][pair + 1] == "O";

        }
        
        if (up || down || left || right) {
            return true;
            
        }
        return false;

    } 
    
    private boolean checkAllZeros() {
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board.length; j++) {
                if (board[i][j] == "O") {
                    return true;
                }    
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        
        part4 battleShip = new part4();
        Scanner scan = new Scanner(System.in);
        
        final ArrayList<String> menuItems = new ArrayList<>(Arrays.asList("Aircraft Carrier", "Battleship ", "Submarine", "Cruiser", "Destroyer"));
        final ArrayList<Integer> menuCells = new ArrayList<>(Arrays.asList(5, 4, 3 ,3, 2));

        ArrayList<Integer> subNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        ArrayList<Character> subLetters = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'));
        battleShip.printBoard();

        boolean allSetPieces = true;

        for (int i = 0; i < 5; i++) {
   
            System.out.println();
            System.out.println("Enter the coordinates of the " + menuItems.get(i) + " (" + menuCells.get(i) + " cells):");
            System.out.println();
            boolean pass = false;
            
            while (!pass) {
                
                //System.out.print("> ");

                String[] aircraftCoordinates = scan.nextLine().toUpperCase().split(" ");
                System.out.println();

                int fNumber = Integer.parseInt(aircraftCoordinates[0].substring(1));   
                int sNumber = Integer.parseInt(aircraftCoordinates[1].substring(1)); 

                char fLetter = aircraftCoordinates[0].charAt(0);
                char sLetter = aircraftCoordinates[1].charAt(0);
                
                int fLetter_num = subNumbers.get(subLetters.indexOf(fLetter));
                int sLetter_num = subNumbers.get(subLetters.indexOf(sLetter));

                int sub_cFirst = (fLetter_num > sLetter_num) ? sLetter_num : fLetter_num;
                int sub_cSecond = (fLetter_num > sLetter_num) ? fLetter_num : sLetter_num;
                fLetter_num = sub_cFirst;
                sLetter_num = sub_cSecond;
                
                int sub_First = (fNumber > sNumber) ? sNumber : fNumber;
                int sub_Second = (fNumber > sNumber) ? fNumber : sNumber;
                fNumber = sub_First;
                sNumber = sub_Second;

                pass = battleShip.checkCoordinates(fNumber, sNumber, fLetter_num, sLetter_num, menuCells.get(i), menuItems.get(i));
                
                if (pass) {
                        battleShip.setPiece(fNumber, sNumber, fLetter_num, sLetter_num);
                        battleShip.printBoard();

                }
                
            }

            
        }
        System.out.println();
        System.out.println("The game starts!");
        System.out.println();

        battleShip.printMask();
        System.out.println();
        System.out.println("Take a shot!");
        System.out.println();

        while (allSetPieces) {
            String aircraftCoordinates = scan.nextLine().toUpperCase();
            
            int number = Integer.parseInt(aircraftCoordinates.substring(1));
            System.out.println();

            char letter = aircraftCoordinates.charAt(0);
            boolean check = battleShip.checkCoordinates(letter, number);
            int Letter_num = subNumbers.get(subLetters.indexOf(letter));

            if (!check) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                System.out.println();
                continue;

            } else {

                battleShip.setPiece(Letter_num, number);
                allSetPieces = battleShip.checkAllZeros();
                
            }
        }
        battleShip.printBoard();
        System.out.println();
        System.out.println("You sank the last ship. You won. Congratulations!");
        

    }

    
}
