abstract class Unit {
    
    private final String NAME;
    private final String SYMBOL;
    private double value;
    
    Unit(String name, String symbol, double value) {
        this.NAME = name;
        this.SYMBOL = symbol;
        this.value = value;
    }
    
    abstract boolean convertable(Unit unit1, Unit unit2);
}
