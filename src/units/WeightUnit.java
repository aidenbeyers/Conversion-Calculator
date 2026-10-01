package units;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

public abstract class WeightUnit extends Unit {

    private static final Set<String> units = new HashSet<>(
            Set.of(
                    "kilogram", "Kilogram", "kg", 
                    "gram", "Gram", "g", 
                    "milligram", "Milligram", "mg"
            )
    );
    
    protected WeightUnit(String symbol, String value) {
        super(symbol, value);
    }

    @Override
    public boolean convertible(String s) {
        return units.contains(s);
    }

    @Override
    public BigDecimal convert(String s) {
        switch(super.SYMBOL + "-" + s) {
            // This section covers cases when converting from a kilogram
            case "kg-g":
                return super.value.multiply(new BigDecimal("1000.0"));
            case "kg-mg":
                return super.value.multiply(new BigDecimal("100000.0"));

            //This section covers cases when converting from a gram
            case "g-kg":
                return super.value.divide(new BigDecimal("1000.0"), 3, RoundingMode.HALF_UP);
            case "g-mg":
                return super.value.multiply(new BigDecimal("100.0"));

            //This section covers cases when converting from a milligram    
            case "mg-kg":
                return super.value.divide(new BigDecimal("100000.0"), 3, RoundingMode.HALF_UP);
            case "mg-g":
                return super.value.divide(new BigDecimal("100.0"), 3, RoundingMode.HALF_UP);

            //The default assumes the user attempts to convert a unit to itself.    
            default:
                return super.value;
        }
    }
}
