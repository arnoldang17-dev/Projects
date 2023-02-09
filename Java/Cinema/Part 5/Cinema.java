import java.util.InputMismatchException;
import java.util.Scanner;

public class Cinema {
    private int rows;
    private int seats;
    private int frontRowPrice;
    private int backRowPrice;
    private int frontRow;
    private int backRow;
    private String[][] seatArrangement;
    private double percentage;
    private int currentIncome;
    final private int totalIncome;
    private int ticketsSold = 0;

    public Cinema(Scanner scan) {
        System.out.println("Enter the number of rows:");
        this.rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        this.seats = scan.nextInt();

        double subFrontRow = rows / 2; //4
        double subBackRow = (double)rows / 2; //4.5

        this.frontRow = (int)subFrontRow; //4
        this.backRow = (int)Math.round(subBackRow);//5
        
        this.frontRowPrice  = 10;
        this.backRowPrice  = (rows * seats < 60) ? 10 : 8;
        this.totalIncome = frontRow * seats * frontRowPrice + backRow  * seats * backRowPrice;
        this.seatArrangement =  new String[this.rows + 1][this.seats + 1];
        setRoom();
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

    private void setSeat(Scanner scan) {
        while (true) {
            
            try {
                System.out.println();
                System.out.println("Enter a row number:");
                int row = scan.nextInt();

                System.out.println("Enter a seat number in that row:");
                int seat = scan.nextInt();
                
                if (seatArrangement[row][seat] == "B") {
                    System.out.println("That ticket has already been purchased!");
                    continue;
                }
                
                if (row <= this.frontRow) {
                    System.out.println();
                    System.out.println("Ticket price: $" + frontRowPrice);
                    currentIncome += frontRowPrice;
                } else {
                    System.out.println();
                    System.out.println("Ticket price: $" + backRowPrice);
                    currentIncome += backRowPrice;
                }
                seatArrangement[row][seat] = "B";
                ticketsSold++;
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Wrong input!");
                continue;
                
            }

        } 
    }
    
    private int printMenu(Scanner scan) {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        try {
            int input = scan.nextInt();
            if(input < 0 || input > 3) throw new InputMismatchException();

            return input;

        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
            return printMenu(scan);
        }
    }

    private void printStatistics() {
        percentage = (double)ticketsSold / (rows * seats) * 100;
        System.out.println("Number of purchased tickets: " + ticketsSold);
        System.out.printf("Percentage: %.2f", percentage);
        System.out.println("%");
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Cinema manager = new Cinema(scan);
        
        while (true) {
        int input = manager.printMenu(scan);
        
            switch (input) {
                case 1: manager.printRoom();
                        System.out.println();
                        break;
                case 2: manager.setSeat(scan);
                        System.out.println();
                        break;
                case 3: manager.printStatistics();
                        System.out.println();
                        break;
                case 0: return;
            }
        if (input == 0) break;
        }

    }
 
}
