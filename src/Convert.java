import temperature.Celsius;
import temperature.Fahrenheit;
import temperature.Kelvin;
import time.Hours;
import time.Minutes;
import time.Seconds;
import units.Unit;
import distance.Kilometer;
import distance.Meter;
import distance.Centimeter;
import weight.Gram;
import weight.Kilogram;
import weight.Milligram;

import java.math.BigDecimal;
import java.util.Scanner;

public class Convert {

    static void main() {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Hi. This is a Conversion Calculator. You will get the choice to convert between two different units.");

        System.out.println("Here are the different convertible units based on category");
        System.out.println();
        // Prints out the list of Units that measure distance
        System.out.println("Units measuring Distance:");
        System.out.println("kilometer (km)");
        System.out.println("meter (m)");
        System.out.println("centimeter (cm)");
        System.out.println();
        // Prints out the list of Units that measure Weight
        System.out.println("Units measuring Weight:");
        System.out.println("kilogram (kg)");
        System.out.println("gram (g)");
        System.out.println("milligram (mg)");
        System.out.println();
        // Prints out the list of Units that measure Time
        System.out.println("Units measuring Time:");
        System.out.println("seconds (s)");
        System.out.println("minutes (mins)");
        System.out.println("hours (hrs)");
        System.out.println();
        // Prints out the list of Units that measure Temperature
        System.out.println("Units measuring Temperature:");
        System.out.println("fahrenheit (F)");
        System.out.println("celsius (C)");
        System.out.println("kelvin (K)");
        System.out.println();

        System.out.println("Now you will enter what you would like converted:");
        
        converter:
        while(true) {
            System.out.println("Please enter the unit being converted:");

            // Loops until a valid input for Unit 1 is made.
            String Unit1_Symbol;
            while(true) {
                Unit1_Symbol = scanner.next();
                if(validUnit(Unit1_Symbol)) {
                    break;
                }
                System.out.println("Invalid input. Try Again.");
            }

            System.out.println("Now please enter it's value:");

            String Unit1_Value;
            // Loops until Unit1 can be assigned a proper value;
            while(true) {
                Unit1_Value = scanner.next();
                if(isNonNegativeNum(Unit1_Value)) {
                    break;
                }
                System.out.println("Invalid input. Try Again.");
            }
            
            Unit unit1 = createUnit(Unit1_Symbol, Unit1_Value);

            // Loops until a unit 2 that is convertible from unit 1 is created.
            String Unit2_Symbol;
            while(true) {
                System.out.println("Please enter the unit you want to convert to:");
                
                // Loops until a valid input for Unit 2 is made.
                while(true) {
                    Unit2_Symbol = scanner.next();
                    if(validUnit(Unit2_Symbol)) {
                        break;
                    }
                    System.out.println("Invalid input. Try Again.");
                }

                assert unit1 != null;
                if(unit1.convertible(Unit2_Symbol)) {
                    break;
                }
                System.out.println("Those units cannot be converted. Reenter your second unit.");
            }

            Unit unit2 = createUnit(Unit2_Symbol);
            System.out.println("Here is the computed value: " + unit1.convert(unit2.getSYMBOL()) + " " + unit2.getSYMBOL());
            
            repeat:
            while(true) {
                System.out.println("Would you like to make another conversion? (y/n)");
                
                String userInput = scanner.next();
                
                switch(userInput) {
                    case "Yes", "yes", "y", "Y":
                         break repeat;
                    case "No", "no", "n", "N":
                        break converter;
                    default:
                        System.out.println("Invalid Input.");
                }
            }
        }
        scanner.close();
    }
    
    private static boolean validUnit(String string) {
        boolean valid = true;
        switch(string) {
            case "kilometer", "Kilometer", "km", "meter", "Meter", "m", "centimeter", "Centimeter", "cm", 
                 "kilogram", "Kilogram", "kg", "gram", "Gram", "g", "milligram", "Milligram", "mg",
                 "seconds", "Seconds", "s", "minutes", "Minutes", "mins", "hours", "Hours", "hrs",
                 "fahrenheit", "Fahrenheit", "F", "f", "celsius", "Celsius", "C", "c",
                 "kelvin", "Kelvin", "K", "k":
                break;
            default:
                valid = false;
        }
        return valid;
    }

    private static boolean isNonNegativeNum(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            BigDecimal value = new BigDecimal(str);
            return value.compareTo(BigDecimal.ZERO) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private static Unit createUnit(String unitName, String value) {
        Unit u;
        switch(unitName) {
            case "kilometer", "Kilometer", "km":
                u = new Kilometer(value);
                return u;
            case "meter", "Meter", "m":
                u = new Meter(value);
                return u;
            case "centimeter", "Centimeter", "cm":
                u = new Centimeter(value);
                return u;
            case "kilogram", "Kilogram", "kg":
                u = new Kilogram(value);
                return u;
            case "gram", "Gram", "g":
                u = new Gram(value);
                return u;
            case "milligram", "Milligram", "mg":
                u = new Milligram(value);
                return u;
            case "seconds", "Seconds", "s":
                u = new Seconds(value);
                return u;
            case "minutes", "Minutes", "mins":
                u = new Minutes(value);
                return u;
            case "hours", "Hours", "hrs":
                u = new Hours(value);
                return u;
            case "fahrenheit", "Fahrenheit", "F", "f":
                u = new Fahrenheit(value);
                return u;
            case "celsius", "Celsius", "C", "c":
                u = new Celsius(value);
                return u;
            case "kelvin", "Kelvin", "K", "k":
                u = new Kelvin(value);
                return u;
            default:
                return null;
        }
    }
    /*
    This method overrides the createUnit method
    It is explicitly meant so that the given symbol for the unit you want to be converted
    to is transformed to a common symbol. That way no matter how you type the unit name,
    as long as it is defined as a valid input, the convert methods will still work.
     */
    private static Unit createUnit(String unitName) {
        return createUnit(unitName, "0");
    }
}
