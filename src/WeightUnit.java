abstract class WeightUnit extends Unit {

    WeightUnit(String name, String symbol, double value) {
        super(name, symbol, value);
    }

    @Override
    boolean convertable(Object unit1, Object unit2) {
        return unit1 instanceof WeightUnit && unit2 instanceof WeightUnit;
    }
}
