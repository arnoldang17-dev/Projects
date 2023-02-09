import java.util.Scanner;
public class Cinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scan.nextInt();

        double subFrontRow = rows / 2;
        double subBackRow = (double)rows / 2;

        int frontRow = (int)subFrontRow * seats;
        int backRow = (int)Math.round(subBackRow) * seats;
        
        int a = (rows * seats < 60) ? 10 : 8;
        int sum = frontRow * 10 + backRow  * a;

        System.out.println("Total income:");
        System.out.println("$" + sum);
    }
}
