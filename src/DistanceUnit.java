import java.util.HashSet;
import java.util.Set;

abstract class DistanceUnit extends Unit{
    
    private static final Set<String> units = new HashSet<>(
            Set.of(
                    "km", "kilometer", "Kilometer", 
                    "m", "meter", "Meter", 
                    "cm", "centimeter", "Centimeter"
            )
    );
    
    DistanceUnit(String name, String symbol, double value) {
        super(name, symbol, value);
    }
    
    @Override
    boolean convertible(String s) {
        return units.contains(s);
    }
    
    @Override
    double convert(String s) {
        switch(super.SYMBOL + "-" + s) {
            // This section covers cases when converting from a kilometer
            case "km-m":
                return super.value * 1000.0;
            case "km-cm":
                return super.value * 100000.0;
                
            //This section covers cases when converting from a meter
            case "m-km":
                return super.value / 1000.0;
            case "m-cm":
                return super.value * 100.0;
                
            //This section covers cases when converting from a centimeter    
            case "cm-km":
                return super.value / 100000.0;
            case "cm-m":
                return super.value / 100.0;
                
            //The default assumes the user attempts to convert a unit to itself.    
            default:
                return super.value;
        }
    }
}
