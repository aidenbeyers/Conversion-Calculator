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
            String Unit1;
            unit1_input:
            while(true) {
                Unit1 = scanner.next();
                if(validDistanceUnit(Unit1)) {
                    break unit1_input;
                }
                System.out.println("Invalid input. Try Again.");
            }

            System.out.println("Now please enter it's value:");

            String Unit1_Value;
            double Unit1_Numeric_Value;
            // Loops until Unit1 can be assigned a proper value;
            unit1_value_input:
            while(true) {
                Unit1_Value = scanner.next();
                if(isNumeric(Unit1_Value)) {
                    Unit1_Numeric_Value = Double.parseDouble(Unit1_Value);
                    break unit1_value_input;
                }
                System.out.println("Invalid input. Try Again.");
            }
            
            Unit unit1 = createUnit(Unit1, Unit1_Numeric_Value);

            // Loops until a unit 2 that is convertible from unit 1 is created.
            Unit unit2;
            convertable:
            while(true) {
                System.out.println("Please enter the unit you want to convert to:");
                
                // Loops until a valid input for Unit 2 is made.
                String Unit2;
                unit2_input:
                while(true) {
                    Unit2 = scanner.next();
                    if(validDistanceUnit(Unit2)) {
                        break unit2_input;
                    }
                    System.out.println("Invalid input. Try Again.");
                }

                assert unit1 != null;
                if(unit1.convertable(Unit2)) {
                    break convertable;
                }
                System.out.println("Those units cannot be converted. Reenter your second unit.");
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
    
    private static Unit createUnit(String unit, Double value) {
        Unit u;
        switch(unit) {
            case "kilometer", "Kilometer", "km":
                u = new Kilometer(value);
                return u;
            case "meter", "Meter", "m":
                u = new Meter(value);
                return u;
            case "centimeter", "Centimeter", "cm":
                u = new Centimeter(value);
                return u;
            default:
                return null;
        }
    }
}
