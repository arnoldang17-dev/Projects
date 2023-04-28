public class note {
    
    private void checkInput(ArrayList<String> input) {
        
        if (input.size() == 1) {
            if (Long.parseLong(input.get(0)) < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
                
            }
        } else if (input.size() == 2) {
            if (Long.parseLong(input.get(0)) < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
                
            } else if (Long.parseLong(input.get(1)) < 0) {
                System.out.println("second parameter should be a natural number");
                
            }
        } else if (input.size() == 3) {
            if (Long.parseLong(input.get(0)) < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
                
            } else if (Long.parseLong(input.get(1)) < 0) {
                System.out.println("second parameter should be a natural number");
                
            } else if (Long.parseLong(input.get(1)) < 0) {
                System.out.println("second parameter should be a natural number");
            }
        } else if (input.size() == 4) {
            if (Long.parseLong(input.get(0)) < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
                
            }
        }
    }
}
