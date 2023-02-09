import java.util.Scanner;
public class Cinema {
    int rows;
    int seats;
    int frontRowPrice;
    int backRowPrice;
    int frontRow;
    int backRow;
    String[][] seatArrangement;

    
    public Cinema(Scanner scan) {
        System.out.println("Enter the number of rows:");
        this.rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        this.seats = scan.nextInt();

        double subFrontRow = this.rows / 2;
        double subBackRow = (double)this.rows / 2;

        this.frontRow = (int)subFrontRow;
        this.backRow = (int)Math.round(subBackRow);
        
        this.frontRowPrice  = 10;
        this.backRowPrice  = (this.rows * this.seats < 60) ? 10 : 8;

        this.seatArrangement =  new String[this.rows + 1][this.seats + 1];
    }
    
    private void setRoom() {
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

    private void printRoom() {
        System.out.println("Cinema:");
        for (String[] strings : seatArrangement) {
            for (String strings2 : strings) {
                System.out.print(strings2 + " ");
            }
            System.out.println();
        }
    }

    private void setSeat(int row, int seat) {
        // if (seatArrangement[row][seat] == "B") {
        //     System.out.println("That ticket has already been purchased!");
        //     return;
        // } else {

            if (row <= this.frontRow) {
                System.out.println();
                System.out.println("Ticket price: $" + frontRowPrice);
                System.out.println();

            } else {
                System.out.println();
                System.out.println("Ticket price: $" + backRowPrice);
                System.out.println();

            }
        
        seatArrangement[row][seat] = "B";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Cinema manager = new Cinema(scan);
        manager.setRoom();
        manager.printRoom();
        
        System.out.println();
        System.out.println("Enter a row number:");
        int row = scan.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = scan.nextInt();

        manager.setSeat(row, seat);

        manager.printRoom();

    }
 
}
