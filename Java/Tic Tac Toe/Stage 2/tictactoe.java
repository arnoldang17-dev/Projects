import java.util.Scanner;

public class tictactoe {
    public static void main(String[] args) {
        // write your code here
                Scanner scan = new Scanner(System.in);
        String input = scan.next();

        if (input.length() > 10) return;

        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = input.charAt(i * 3 + j) + "";

            }
        }
        
        //print board
        
        System.out.println("---------");
        System.out.println("| " + board[0][0] + " " + board[0][1] + " " + board[0][2] + " |");
        System.out.println("| " + board[1][0] + " " + board[1][1] + " " + board[1][2] + " |");
        System.out.println("| " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " |");
        System.out.println("---------");
    
        
        
    }
}
