abstract class DistanceUnit extends Unit{
    
    DistanceUnit(String name, String symbol, double value) {
        super(name, symbol, value);
    }
    
    @Override
    boolean convertable(Object unit1, Object unit2) {
        return unit1 instanceof DistanceUnit && unit2 instanceof DistanceUnit;
    }
}
