import java.util.Scanner;

public class Convert {

    static void main(String[] args) {

        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Hi. This is a Conversion Calculator. What kind of units would you like to convert?");
        
        converter:
        while(repeat) {
            System.out.println("Please type one of these three options:");
            System.out.println("distance");
            System.out.println("weight");
            System.out.println("time");
            
            String input = scanner.next();
            
            // If distance is selected, the different distance options will be made available.
            if(input.equals("distance")) {
                
            } else if(input.equals("weight")) {
                
            } else if (input.equals("time")) {
                
            } else {
                while(true) {
                    System.out.println("Invalid input. Try again? (y/n)");
                    input = scanner.next();
                    if(input.equals("yes") || input.equals("y") || input.equals("Yes") || input.equals("Y")) {
                        break;
                    } else if (input.equals("no") || input.equals("n") || input.equals("No") || input.equals("N")) {
                        break converter;
                    }
                }
            }
        }
    }
}
