abstract class Unit {
    
    protected final String SYMBOL;
    protected double value;
    
    Unit(String symbol, double value) {
        this.SYMBOL = symbol;
        this.value = value;
    }
    
    abstract boolean convertible(String s);
    
    abstract double convert(String s);
}
