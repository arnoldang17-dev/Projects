
public class Cinema {
    
    String[][] seatArrangement = new String[8][9];

    public Cinema() {
        for (int i = 0; i < seatArrangement.length; i++) {
            for (int j = 0; j < seatArrangement[i].length; j++) {

                if (i == 0) {
                    if (j == 0) {
                        seatArrangement[i][j] = " ";
                        continue;
                    }
                    seatArrangement[i][j] = String.valueOf(j);
                } else {
                    seatArrangement[i][j] = "S";

                }
                if (i > 0) seatArrangement[i][0] = String.valueOf(i);
            }
        }
    }
    public static void main(String[] args) {
        
        Cinema a = new Cinema();

        for (String[] strings : a.seatArrangement) {
            for (String strings2 : strings) {
                System.out.print(strings2 + " ");
            }
            System.out.println();
        }
    }
 
}
