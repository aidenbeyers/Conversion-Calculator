package units;

import java.util.HashSet;
import java.util.Set;

public abstract class TimeUnit extends Unit{

    private static final Set<String> units = new HashSet<>(
            Set.of(
                    "seconds", "Seconds", "s", 
                    "minutes", "Minutes", "mins", 
                    "hours", "Hours", "hrs"
            )
    );
    
    protected TimeUnit(String symbol, double value) {
        super(symbol, value);
    }

    @Override
    public boolean convertible(String s) {
        return units.contains(s);
    }

    @Override
    public double convert(String s) {
        switch(super.SYMBOL + "-" + s) {
            // This section covers cases when converting from a kilogram
            case "s-mins":
                return super.value / 60.0;
            case "s-hrs":
                return super.value / 3600.0;

            //This section covers cases when converting from a gram
            case "mins-s":
                return super.value * 60.0;
            case "mins-hrs":
                return super.value / 60.0;

            //This section covers cases when converting from a milligram    
            case "hrs-s":
                return super.value * 3600.0;
            case "hrs-mins":
                return super.value / 60.0;

            //The default assumes the user attempts to convert a unit to itself.    
            default:
                return super.value;
        }
    }
}
