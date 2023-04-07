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
                
                boolean even, odd, buzz, duck;
                if (n % 2 == 0) {
                    even = true;
                    odd = false;
                    
                } else {
                    even = false;
                    odd = true;
                } 
                
                if (lastValueOfN == 7 && n % 7 != 0 || n % 7 == 0) {
                    buzz = true;
 
                } else {
                    buzz = false;

                }

                if (nVal.charAt(0) == 0 && nVal.substring(1).contains("0")) {
                    
                    duck = true;
                } else {
                    duck = false;
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

