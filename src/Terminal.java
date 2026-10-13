import java.util.Scanner;

public class Terminal {
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
        System.out.println("feet (ft)");
        System.out.println("inch (in)");
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
                if(Convert.validUnit(Unit1_Symbol)) {
                    break;
                }
                System.out.println("Invalid input. Try Again.");
            }

            System.out.println("Now please enter it's value:");

            String Unit1_Value;
            // Loops until Unit1 can be assigned a proper value;
            while(true) {
                Unit1_Value = scanner.next();
                if(Convert.isNonNegativeNum(Unit1_Value)) {
                    break;
                }
                System.out.println("Invalid input. Try Again.");
            }
            

            // Loops until a unit 2 that is convertible from unit 1 is created.
            String Unit2_Symbol;
            while(true) {
                System.out.println("Please enter the unit you want to convert to:");

                // Loops until a valid input for Unit 2 is made.
                while(true) {
                    Unit2_Symbol = scanner.next();
                    if(Convert.validUnit(Unit2_Symbol)) {
                        break;
                    }
                    System.out.println("Invalid input. Try Again.");
                }
                
                if(Convert.convertable(Unit1_Symbol, Unit2_Symbol)) {
                    break;
                }
                System.out.println("Those units cannot be converted. Reenter your second unit.");
            }
            
            System.out.println("Here is the computed value: " + Convert.convert(Unit1_Symbol, Unit1_Value, Unit2_Symbol) + " " + Unit2_Symbol);

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
}
