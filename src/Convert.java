import distance.*;
import temperature.Celsius;
import temperature.Fahrenheit;
import temperature.Kelvin;
import time.Hours;
import time.Minutes;
import time.Seconds;
import units.Unit;
import weight.Gram;
import weight.Kilogram;
import weight.Milligram;

import java.math.BigDecimal;
import java.util.Scanner;

public class Convert {
    
    public static BigDecimal convert(String unit1_symbol, String unit1_value, String unit2_symbol) {
        
        Unit unit1 = createUnit(unit1_symbol, unit1_value);
        Unit unit2 = createUnit(unit2_symbol);
        
        return unit1.convert(unit2.getSYMBOL());
    }
    
    public static boolean convertable(String unit1_symbol, String unit2_symbol) {
        Unit unit1 = createUnit(unit1_symbol);
        Unit unit2 = createUnit(unit2_symbol);
        return unit1.convertible(unit2.getSYMBOL());
    }
    
    public static boolean validUnit(String string) {
        boolean valid = true;
        switch(string) {
            case "kilometer", "Kilometer", "km", "meter", "Meter", "m", "centimeter", "Centimeter", "cm", 
                 "kilogram", "Kilogram", "kg", "gram", "Gram", "g", "milligram", "Milligram", "mg",
                 "seconds", "Seconds", "s", "minutes", "Minutes", "mins", "hours", "Hours", "hrs",
                 "fahrenheit", "Fahrenheit", "F", "f", "celsius", "Celsius", "C", "c",
                 "kelvin", "Kelvin", "K", "k", "feet", "Feet", "ft", "in", "inch", "Inch", "yd", "yard", "Yard":
                break;
            default:
                valid = false;
        }
        return valid;
    }

    public static boolean isNonNegativeNum(String str) {
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
            case "yard", "Yard", "yd":
                u = new Yard(value);
                return u;
            case "foot", "Foot", "ft":
                u = new Feet(value);
                return u;
            case "inch", "Inch", "in":
                u = new Inch(value);
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
