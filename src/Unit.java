abstract class Unit {
    
    private final String NAME;
    protected final String SYMBOL;
    protected double value;
    
    Unit(String name, String symbol, double value) {
        this.NAME = name;
        this.SYMBOL = symbol;
        this.value = value;
    }
    
    abstract boolean convertible(String s);
    
    abstract double convert(String s);
}
