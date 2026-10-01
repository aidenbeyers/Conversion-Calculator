package units;

import java.math.BigDecimal;

public abstract class Unit {
    
    protected final String SYMBOL;
    protected BigDecimal value;
    
    protected Unit(String symbol, String value) {
        this.SYMBOL = symbol;
        this.value = new BigDecimal(value);
    }
    
    public abstract boolean convertible(String s);
    
    public abstract BigDecimal convert(String s);
}
