package units;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

public abstract class DistanceUnit extends Unit{
    
    protected static final Set<String> units = new HashSet<>(
            Set.of(
                    "km", "kilometer", "Kilometer", 
                    "m", "meter", "Meter", 
                    "cm", "centimeter", "Centimeter",
                    "ft", "feet", "Feet",
                    "in", "inch", "Inch"
            )
    );
    
    protected DistanceUnit(String symbol, String value) {
        super(symbol, value);
    }
    
    @Override
    public boolean convertible(String s) {
        return units.contains(s);
    }
    
    @Override
    public BigDecimal convert(String s) {
        switch(super.SYMBOL + "-" + s) {
            // This section covers cases when converting from a kilometer
            case "km-m":
                return super.value.multiply(new BigDecimal("1000.0"));
            case "km-cm":
                return super.value.multiply(new BigDecimal("100000.0"));
            case "km-ft":
                return super.value.multiply(new BigDecimal("3280.84"));
            case "km-in":
                return super.value.multiply(new BigDecimal("39370.08"));
                
            //This section covers cases when converting from a meter
            case "m-km":
                return super.value.divide(new BigDecimal("1000.0"), 3, RoundingMode.HALF_UP);
            case "m-cm":
                return super.value.multiply(new BigDecimal("100.0"));
            case "m-ft":
                return super.value.multiply(new BigDecimal("3.28084"));
            case "m-in":
                return super.value.multiply(new BigDecimal("39.37008"));
                
            //This section covers cases when converting from a centimeter    
            case "cm-km":
                return super.value.divide(new BigDecimal("100000.0"), 3, RoundingMode.HALF_UP);
            case "cm-m":
                return super.value.divide(new BigDecimal("100.0"), 3, RoundingMode.HALF_UP);
            case "cm-ft":
                return super.value.multiply(new BigDecimal("0.0328084"));
            case "cm-in":
                return super.value.multiply(new BigDecimal("0.3937008"));

            //This section covers cases when converting from a foot    
            case "ft-km":
                return super.value.divide(new BigDecimal("3280.84"), 3, RoundingMode.HALF_UP);
            case "ft-m":
                return super.value.divide(new BigDecimal("3.28084"), 3, RoundingMode.HALF_UP);
            case "ft-cm":
                return super.value.multiply(new BigDecimal("30.48"));
            case "ft-in":
                return super.value.multiply(new BigDecimal("12.0"));

            //This section covers cases when converting from an Inch    
            case "in-km":
                return super.value.divide(new BigDecimal("39370.08"), 3, RoundingMode.HALF_UP);
            case "in-m":
                return super.value.divide(new BigDecimal("39.37008"), 3, RoundingMode.HALF_UP);
            case "in-cm":
                return super.value.multiply(new BigDecimal("2.54"));
            case "in-ft":
                return super.value.divide(new BigDecimal("12.0"), 3, RoundingMode.HALF_UP);
                
            //The default assumes the user attempts to convert a unit to itself.    
            default:
                return super.value;
        }
    }
}
