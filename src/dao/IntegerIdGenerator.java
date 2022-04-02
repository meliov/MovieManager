package dao;

public class IntegerIdGenerator implements IdGenerator<Integer> {
    private int lastId = 0;

    public IntegerIdGenerator() {
    }

    public IntegerIdGenerator(int initialValue) {
        this.lastId = initialValue;
    }

    @Override
    public Integer getNextId() {
        return ++ lastId;
    }

    @Override
    public Integer getCurrentId() {
        return lastId;
    }

    @Override
    public void reset(Integer newInitialValue) {
        lastId = newInitialValue;
    }


}
