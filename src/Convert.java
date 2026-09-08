import java.util.Scanner;

public class Convert {

    static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Hi. This is a Conversion Calculator. You will get the choice to convert between two different units.");
        
        converter:
        while(true) {
            System.out.println("Here are the different convertible units based on category");
            System.out.println();
            System.out.println("Units measuring Distance:");
            System.out.println("kilometer (km)");
            System.out.println("meter (m)");
            System.out.println("centimeter (cm)");
            System.out.println();
            System.out.println("Units measuring Weight:");
            System.out.println();
            System.out.println("Units measuring Time:");
            System.out.println();
            
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

            // Loops until a valid input for Unit 2 is made.
            unit2_input:
            while(true) {
                String Unit2 = scanner.next();
                if(validDistanceUnit(Unit2)) {
                    break unit2_input;
                }
                System.out.println("Invalid input. Try Again.");
            }

            System.out.println("Now please enter it's value:");

            // Loops until Unit1 can be assigned a proper value;
            unit2_value_input:
            while(true) {
                String Unit2_Value = scanner.next();
                if(isNumeric(Unit2_Value)) {
                    Double Unit2_Numeric_Value = Double.parseDouble(Unit2_Value);
                    break unit2_value_input;
                }
                System.out.println("Invalid input. Try Again.");
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
