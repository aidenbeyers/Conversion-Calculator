package units;

public abstract class Unit {
    
    protected final String SYMBOL;
    protected double value;
    
    protected Unit(String symbol, double value) {
        this.SYMBOL = symbol;
        this.value = value;
    }
    
    public abstract boolean convertible(String s);
    
    public abstract double convert(String s);
}
