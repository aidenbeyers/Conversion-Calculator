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
                System.out.println("Here are your different units:");
                System.out.println("kilometer (km)");
                System.out.println("meter (m)");
                System.out.println("centimeter (cm)");

                System.out.println("Now you will enter what you would like converted:");
                System.out.println("Please enter the unit being converted:");
                
                // Loops until a valid input for Unit 1 is made.
                unit1_input:
                while(true) {
                    String Unit1 = scanner.next();
                    if(validDistanceUnit(Unit1)) {
                        break unit1_input;
                    }
                    System.out.println("Invalid input. Try Again.");
                }

                System.out.println("Now please enter it's value:");
                
                // Loops until Unit1 can be assigned a proper value;
                unit1_value_input:
                while(true) {
                    String Unit1_Value = scanner.next();
                    if(isNumeric(Unit1_Value)) {
                        Double Unit1_Numeric_Value = Double.parseDouble(Unit1_Value);
                        break unit1_value_input;
                    }
                    System.out.println("Invalid input. Try Again.");
                }
                
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
    
    private static boolean validDistanceUnit(String string) {
        boolean valid = true;
        switch(string) {
            case "kilometer", "Kilometer", "km", "meter", "Meter", "m", "centimeter", "Centimeter", "cm":
                break;
            default:
                valid = false;
        }
        return valid;
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true; // Catches formats like "123", "-45.67", or "3.14"
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
