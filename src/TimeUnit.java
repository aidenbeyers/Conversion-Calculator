abstract class TimeUnit extends Unit{

    TimeUnit(String name, String symbol, double value) {
        super(name, symbol, value);
    }

    @Override
    boolean convertable(Object unit1, Object unit2) {
        return unit1 instanceof TimeUnit && unit2 instanceof TimeUnit;
    }
}
