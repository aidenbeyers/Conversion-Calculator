import java.util.HashSet;
import java.util.Set;

abstract class WeightUnit extends Unit {

    private static final Set<String> units = new HashSet<>(
            Set.of()
    );
    
    WeightUnit(String name, String symbol, double value) {
        super(symbol, value);
    }

    @Override
    boolean convertible(String s) {
        return units.contains(s);
    }
}
