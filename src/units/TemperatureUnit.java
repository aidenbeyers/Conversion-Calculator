package units;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

public abstract class TemperatureUnit extends Unit {

    protected static final Set<String> units = new HashSet<>(
            Set.of(
                    "F", "f", "Fahrenheit", "fahrenheit",
                    "C", "c", "Celsius", "celsius",
                    "K", "k", "kelvin", "Kelvin"
            )
    );

    protected TemperatureUnit(String symbol, String value) {
        super(symbol, value);
    }

    @Override
    public boolean convertible(String s) {
        return units.contains(s);
    }

    @Override
    public BigDecimal convert(String s) {
        switch(super.SYMBOL + "-" + s) {
            // This section covers cases when converting from Fahrenheit
            case "F-C":
                return super.value.subtract(new BigDecimal("32")).divide(new BigDecimal("1.8"), 2, RoundingMode.HALF_UP);
            case "F-K":
                return super.value.subtract(new BigDecimal("32")).divide(new BigDecimal("1.8"), 2, RoundingMode.HALF_UP).add(new BigDecimal("273.15"));

            //This section covers cases when converting from Celsius
            case "C-F":
                return super.value.multiply(new BigDecimal("1.8")).add(new BigDecimal("32"));
            case "C-K":
                return super.value.add(new BigDecimal("273.15"));

            //This section covers cases when converting from Kelvin    
            case "K-F":
                return super.value.subtract(new BigDecimal("273.15")).multiply(new BigDecimal("1.8")).add(new BigDecimal("32"));
            case "K-C":
                return super.value.subtract(new BigDecimal("273.15"));

            //The default assumes the user attempts to convert a unit to itself.    
            default:
                return super.value;
        }
    }
}
