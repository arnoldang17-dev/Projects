import java.util.Arrays;
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

    private void setBoard(String input) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = input.charAt(i * 3 + j) + "";

            }
        }
    }

    private void checkBoard() {
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
        if (checkBoardO() == false && checkBoardX() == false) {
            if (allCount == 9) {
                System.out.println("Draw");
            } else if (allCount < 7  && (countO - countX < 2 && countO - countX > -2)) {
                System.out.println("Game not finished");
            } else {
                System.out.println("Impossible");
            }
        } else {
            if (checkBoardO() == true && checkBoardX() == true) {
                System.out.println("Impossible");
            } else if (checkBoardO() == true) {
                System.out.println("O wins");
            } else if (checkBoardX() == true) {
                System.out.println("X wins");
            }
        }     
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
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String input = scan.next();

        //if (input.length() > 10) return;
        tictactoe game = new tictactoe();
        game.setBoard(input);
        game.printBoard();
        game.checkBoard();
        
    }
}
