import java.util.HashSet;
import java.util.Set;

abstract class TimeUnit extends Unit{

    private static final Set<String> units = new HashSet<>(
            Set.of()
    );
    
    TimeUnit(String name, String symbol, double value) {
        super(name, symbol, value);
    }

    @Override
    boolean convertable(String s) {
        return units.contains(s);
    }
}
