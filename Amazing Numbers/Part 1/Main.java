import java.util.Scanner;

public class Main {

    private static void  printMessage(Scanner scan) {
        while (true) {
            try {
                System.out.println("Enter a natural number: ");
                int n = scan.nextInt();

                if (n <= 0) throw new Exception();

                String nVal = String.valueOf(n);
                int lastValueOfN = Integer.parseInt(nVal.substring(nVal.length() - 1));
                
                if (n % 2 == 0) {
                    System.out.println("This number is Even.");

                } else {
                    System.out.println("This number is Odd.");

                }

                if (n % 7 != 0 && lastValueOfN == 7 ||  n % 7 == 0) {
                        System.out.println("It is a Buzz number.");
                        System.out.println("Explanation:");
                        
                } else {
                    System.out.println("It is not a Buzz number.");
                    System.out.println("Explanation:");
                }
                
                if (n % 7 == 0 && lastValueOfN != 7) {
                    System.out.printf("%d is divisible by 7.", n);
 
                } else if (n % 7 == 0 && lastValueOfN == 7) {
                    System.out.printf("%d is divisible by 7 and ends with 7.", n);

                } else if (n % 2 == 0) {
                    System.out.printf("%d is divisible by 2 and is neither divisible by 7 nor does it end with 7.", n);
                    
                } else {
                    System.out.printf("%d is neither divisible by 7 nor does it end with 7.", n);

                }
                
                break;
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("This number is not natural!");
                break;
            }
        }
    }
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        
        Main.printMessage(scan);
        
    }
}

