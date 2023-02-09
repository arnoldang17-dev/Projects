
public abstract class Map {
    
    private String[][] board;
    private String[][] boardMask;
    private boolean horizontal;
    private boolean vertical;

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
}
