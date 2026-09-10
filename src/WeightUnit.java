import java.util.HashSet;
import java.util.Set;

abstract class WeightUnit extends Unit {

    private static final Set<String> units = new HashSet<>(
            Set.of(
                    "kilogram", "Kilogram", "kg", 
                    "gram", "Gram", "g", 
                    "milligram", "Milligram", "mg"
            )
    );
    
    WeightUnit(String symbol, double value) {
        super(symbol, value);
    }

    @Override
    boolean convertible(String s) {
        return units.contains(s);
    }

    @Override
    double convert(String s) {
        switch(super.SYMBOL + "-" + s) {
            // This section covers cases when converting from a kilogram
            case "kg-g":
                return super.value * 1000.0;
            case "kg-mg":
                return super.value * 100000.0;

            //This section covers cases when converting from a gram
            case "g-kg":
                return super.value / 1000.0;
            case "g-mg":
                return super.value * 100.0;

            //This section covers cases when converting from a milligram    
            case "mg-kg":
                return super.value / 100000.0;
            case "mg-g":
                return super.value / 100.0;

            //The default assumes the user attempts to convert a unit to itself.    
            default:
                return super.value;
        }
    }
}
