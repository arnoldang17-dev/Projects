import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    final ArrayList<String> allProperties = new ArrayList<String>(Arrays.asList("BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "EVEN", "ODD", "SQUARE", "SUNNY"));

    private boolean isEvenOrOdd(long n) {
                if (n % 2 == 0) {
                    return true;
                    
                } else {
                    return false;
                } 
    }

    private boolean isBuzzNumber(long n) {
        String nVal = String.valueOf(n);
        long lastValueOfN = Integer.parseInt(nVal.substring(nVal.length() - 1));

        if (lastValueOfN == 7 && n % 7 != 0 || n % 7 == 0) {
            return true;

        } else {
            return false;

        }
    }

    private boolean isDuckNumber(long n) {
        String nVal = String.valueOf(n);
        
        if (nVal.charAt(0) == 0 && nVal.substring(1).contains("0") || nVal.substring(1).contains("0")) {
                    
            return true;
        } else {
            return false;
        }

    }

    private boolean isPalindrome(long n) {
        String number = String.valueOf(n);
        StringBuilder flippedNumber = new StringBuilder();
        for (int i =  number.length() - 1; i >= 0; i--) {
            flippedNumber.append(number.charAt(i));

        }

        if (flippedNumber.toString().equals(number)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isGapful(long n) {
        if (String.valueOf(n).length() <= 2) {
            return false;
        } else {
            String na = String.valueOf(n);
            String firstNum = String.valueOf(na.charAt(0));
            String secondNum = String.valueOf(na.charAt(String.valueOf(n).length() - 1));
            StringBuilder gap = new StringBuilder().append(firstNum + secondNum);

            if (n % Integer.parseInt(gap.toString()) == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean isSpy(long n) {
        
        ArrayList<String> numbers = new ArrayList<>(Arrays.asList(String.valueOf(n).split("")));
        if (numbers.size() == 1) {
            return true;
        } else {
            long firstNum = 0;
            long secondNum = 1;
            
            for (int i = 0; i < numbers.size(); i++) {
                firstNum += Long.parseLong(numbers.get(i));
                secondNum *= Long.parseLong(numbers.get(i));
            }

            if (firstNum == secondNum) {
                return true;
            } else {
                return false;
            }
        }
    }
    private boolean isSquare(Long firstNum) {
        
        return (Math.sqrt(firstNum) % 1 == 0); 
    }
        
    private boolean isSunny(Long firstNum) {
        
        return isSquare(firstNum + 1);
        
    }
    private void printMenu() {
        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println("Supported requests: ");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and a property to search for;");
        System.out.println("- two natural numbers and two properties to search for;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
        
    }

    private void printListProperties(long firstNum, long secondNum) {
        
        for (long i = firstNum; i <= secondNum; i++) {
            StringBuilder message = new StringBuilder();

            message.append(String.format("%,d", i) + " is ");
            
            if (isBuzzNumber(i)) {
                message.append("buzz, ");
            }
            
            if (isPalindrome(i)) {
                message.append("palindromic, ");
            }
            
            if (isGapful(i)) {
                message.append("gapful, ");
            }

            if (isDuckNumber(i)) {
                message.append("duck, ");
            }

            if (isSpy(i)) {
                message.append("spy, ");
            }

            if (isSquare(i)) {
                message.append("square, ");
            }

            if (isSunny(i)) {
                message.append("sunny, ");
            }
            
            if (isEvenOrOdd(i)) {
                message.append("even");
            } else {
                message.append("odd");
            }

            System.out.println(message.toString());
        }
    }

    private void printListProperties(long firstNum) {
        
        StringBuilder message = new StringBuilder();

            message.append(String.format("%,d", firstNum) + " is ");
            
            if (isBuzzNumber(firstNum)) {
                message.append("buzz, ");
            }
            
            if (isPalindrome(firstNum)) {
                message.append("palindromic, ");
            }
            
            if (isGapful(firstNum)) {
                message.append("gapful, ");
            }

            if (isDuckNumber(firstNum)) {
                message.append("duck, ");
            }

            if (isSpy(firstNum)) {
                message.append("spy, ");
            }

            if (isSquare(firstNum)) {
                message.append("square, ");
            }

            if (isSunny(firstNum)) {
                message.append("sunny, ");
            }
            
            if (isEvenOrOdd(firstNum)) {
                message.append("even");
            } else {
                message.append("odd");
            }

            System.out.println(message.toString());
    }

    private boolean checkProperty(String property, long firstNum) {
        
        return switch(property.toUpperCase()) {
                            
            case "BUZZ" -> isBuzzNumber(firstNum);
            case "DUCK" -> isDuckNumber(firstNum);
            case "PALINDROMIC" -> isPalindrome(firstNum);
            case "GAPFUL" -> isGapful(firstNum);
            case "SPY" -> isSpy(firstNum);
            case "EVEN" -> isEvenOrOdd(firstNum);
            case "ODD" -> !isEvenOrOdd(firstNum);
            case "SUNNY" -> isSunny(firstNum);
            case "SQUARE" -> isSquare(firstNum);
            default -> throw new IllegalArgumentException("Unexpected value: " + property.toUpperCase());

        };
    }
    private void checkFirstNumber() {
        
    }

    private void checkSecondNumber() {
        
    }

    private boolean checkProperty(String property) {
         
        return allProperties.contains(property);
    }
    private void checkInput(ArrayList<String> input) {

        if (Long.parseLong(input.get(0)) < 0) {
            System.out.println("The first parameter should be a natural number or zero.");

        } else if (Long.parseLong(input.get(1)) < 0) {
            System.out.println("sThe second parameter should be a natural number.");
            
        } else if (!allProperties.contains(input.get(2).toUpperCase())) {
            System.out.printf("The property [%s] is wrong.\n", input.get(2).toUpperCase());
            System.out.println("Available properties: " + allProperties);

        }

    }

    private void  showMessage(Scanner scan) {
        
        while (true) {

            try {
                System.out.println();
                System.out.println("Enter a request: ");
                String n = scan.nextLine();

                if (n.equals(" ")) {
                    printMenu();
                    continue;
                }
                ArrayList<String> input = new ArrayList<>(Arrays.asList(n.split(" ")));
                if (input.get(0).equals("0")){
                    System.out.println("Goodbye!");
                    break;

                }

                long firstNum = Long.parseLong(input.get(0));
                long secondNum = Long.parseLong(input.get(1));
                
                if (input.size() == 1) {

                    if (Long.parseLong(input.get(0)) < 0) {
                        System.out.println("The first parameter should be a natural number or zero.");
                        
                    } else {
                        long nVal = Long.parseLong(n);
                        System.out.println();
                        
                        System.out.println(String.format("Properties of %,d", nVal));
                        System.out.printf("\teven: %s\n", isEvenOrOdd(nVal));
                        System.out.printf("\t odd: %s\n", !isEvenOrOdd(nVal));
                        System.out.printf("\tbuzz: %s\n", isBuzzNumber(nVal));
                        System.out.printf("\tduck: %s\n", isDuckNumber(nVal));
                        System.out.printf(" palindromic: %s\n", isPalindrome(nVal));
                        System.out.printf("\tgapful: %s\n", isGapful(nVal));
                        System.out.printf("\tspy: %s\n", isSpy(nVal));
                        System.out.printf("\tsquare: %s\n", isSquare(nVal));
                        System.out.printf("\tsunny: %s\n", isSunny(nVal));
    
                    }

                   
                } else if (input.size() == 2) {
                    if (Long.parseLong(input.get(1)) < 0) {
                        System.out.println("sThe second parameter should be a natural number.");
                        
                    } else {
                        
                    if (firstNum > secondNum) {
                        secondNum += firstNum - 1;
                    }

                    System.out.println();
                    printListProperties(firstNum, secondNum);
                    }
                    
                        
                } else if (input.size() == 3) {
                    
                    System.out.println();
                    if (!allProperties.contains(input.get(2).toUpperCase())) {
                        System.out.printf("The property [%s] is wrong.\n", input.get(2).toUpperCase());
                        System.out.println("Available properties: " + allProperties);

                    } else {
                        
                        long count = 0;
                        
                        while (count < secondNum) {
                            if (checkProperty(input.get(2), firstNum)) {
                                printListProperties(firstNum);
                                count++;
                            }
                            firstNum++;
                        }
                      //System.out.println("nice");
                    }
                } else if(input.size() == 4) {
                    
                    System.out.println();

                    List<String> inputProperties = new ArrayList<>(Arrays.asList(input.get(2).toUpperCase(), input.get(3).toUpperCase()));

                    if (!allProperties.contains(input.get(2).toUpperCase()) ^ !allProperties.contains(input.get(3).toUpperCase())) {

                        String property = (!allProperties.contains(input.get(2).toUpperCase())) ? input.get(2) : input.get(3);
                        System.out.printf("The property [%s] is wrong.\n", property.toUpperCase());
                        System.out.println("Available properties: " + allProperties);

                    } else if (!allProperties.contains(input.get(2).toUpperCase()) && !allProperties.contains(input.get(3).toUpperCase())) {
                        
                        System.out.printf("The properties [%s, %s] are wrong.\n", input.get(2).toUpperCase(), input.get(3).toUpperCase());
                        System.out.println("Available properties: " + allProperties);

                    } else if (inputProperties.contains("EVEN") && inputProperties.contains("ODD")) {
                        System.out.println("The request contains mutually exclusive properties: [EVEN, ODD]");
                        System.out.println("There are no numbers with these properties.");

                    } else if (inputProperties.contains("DUCK") && inputProperties.contains("SPY")) {
                        System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]");
                        System.out.println("There are no numbers with these properties.");
                        
                    } else if (inputProperties.contains("SQUARE") && inputProperties.contains("SUNNY")) {
                        System.out.println("The request contains mutually exclusive properties: [SQUARE, SUNNY]");
                        System.out.println("There are no numbers with these properties.");
                        
                    } else {

                        
                            
                        long count = 0;
                        
                        while (count < secondNum) {
                            if (checkProperty(inputProperties.get(0), firstNum) && checkProperty(inputProperties.get(1), firstNum)) {
                                printListProperties(firstNum);
                                count++;
                            }
                            firstNum++;
                        }
                    }     
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("The first parameter should be a natural number or zero.");
                System.out.println(e.getMessage());
                continue;
                
            }
        }
    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Main number = new Main();
        
        number.printMenu();
        number.showMessage(scan);
        
    }
}

