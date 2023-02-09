import java.util.InputMismatchException;
import java.util.Scanner;
// Date: 2023-01-18

public class tictactoe {

    String[][] board;

    public tictactoe() {
        board = new String[3][3];
    }
    private void printBoard() {
        System.out.println("---------");
        System.out.println("| " + board[0][0] + " " + board[0][1] + " " + board[0][2] + " |");
        System.out.println("| " + board[1][0] + " " + board[1][1] + " " + board[1][2] + " |");
        System.out.println("| " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " |");
        System.out.println("---------");
    }

    private void setBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] =  "_";

            }
        }
    }

    private boolean checkBoard() {
        int countO = 0;
        int countX = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[i][j].equals("X")) {
                    countX++;
                } else if (board[i][j].equals("O")) {
                    countO++;
                }
            }
        }
        int allCount = countO + countX;
        if ( allCount == 9 && (checkBoardO() == false && checkBoardX() == false)) {
            System.out.println("Draw");
            return true; 
            
        } else {
            if (checkBoardO() == true && checkBoardX() == true) {
                System.out.println("Impossible");
                return true;
            } else if (checkBoardO() == true) {
                System.out.println("O wins");
                return true;

            } else if (checkBoardX() == true) {
                System.out.println("X wins");
                return true;
            }
        }
        return false;
    }

    private Boolean checkBoardX() {
        boolean X = false;
        // checking downward and sideward
        for (int i = 0; i < 3; i++) {
            int vertical = 0;
            int horizontal = 0;

            for (int j = 0; j < 3; j++) {
                //vertical          
                if (board[j][i].equals("X")) {
                    vertical++;
                }
                //horizontal
                if (board[i][j].equals("X")) {
                    horizontal++;
                }
                if (vertical == 3 ^ horizontal == 3) {
                    X = true;
                    break;
                }
            }
            if (X) break;
        }
        int diagonal = 0;

        // diagonal
        for (int k = 0; k < 3; k++) {    
            if (board[k][2 - k].equals("X")) {
                diagonal++;
            }  
        }

        if (diagonal == 3) {
            X = true;
        } else {
            diagonal = 0;
        }

        for (int k = 0; k < 3; k++) {    
            
            if (diagonal == 3) {
                X = true;
                break;
            } else if (board[k][k].equals("X")) {
                diagonal++;
            }

        }

        return X;
    }

    private Boolean checkBoardO() {
        boolean O = false;
        // checking downward and sideward
        for (int i = 0; i < 3; i++) {
            int vertical = 0;
            int horizontal = 0;

            for (int j = 0; j < 3; j++) {
                //vertical          
                if (board[j][i].equals("O")) {
                    vertical++;
                }
                //horizontal
                if (board[i][j].equals("O")) {
                    horizontal++;
                }
                if (vertical == 3 ^ horizontal == 3) {
                    O = true;
                    break;
                }
                
            }
            if (O) break;
        }

        int diagonal = 0;

        // diagonal
        for (int k = 0; k < 3; k++) {    
            if (board[k][2 - k].equals("O")) {
                diagonal++;
            }       
        }

        if (diagonal == 3) {
            O = true;
        } else {
            diagonal = 0;
        }

        for (int k = 0; k < 3; k++) {    
            
            if (diagonal == 3) {
                O = true;
                break;
            } else if (board[k][k].equals("O")) {
                diagonal++;
            }

        }

        return O;
    }
    
    private void setPiece(Scanner scan, String piece) {
        while (true) {
            try {
                int x = scan.nextInt();
                int y = scan.nextInt();
                if (x > 3 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                } else if (board[x - 1][y - 1].equals("X") || board[x - 1][y - 1].equals("O")) {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                } else {
                    board[x - 1][y - 1] = piece;
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                scan.nextLine();
                continue;
                
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        tictactoe game = new tictactoe();
        game.setBoard();
        game.printBoard();

        String player1 = "X";
        String player2 = "O";
        int count = 0;
        
        while (count <= 9) {
            String piece = (count % 2 == 0) ? player1 : player2;
            game.setPiece(scan, piece);
            game.printBoard();
            count++;
            if (count > 3) {
                if (game.checkBoard()) {
                    break;
                }
            }
        }
    }
    
}
