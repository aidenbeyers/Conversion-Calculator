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
    boolean convertable(String s) {
        return units.contains(s);
    }
}
