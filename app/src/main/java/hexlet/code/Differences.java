package hexlet.code;

public class Differences {
    private final Object oldValue;
    private final Object newValue;
    private final String state;

    public Differences(Object oldValue, Object newValue, String state) {
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.state = state;
    }

    public final Object getOldValue() {
        return oldValue;
    }
    public final Object getNewValue() {
        return newValue;
    }

    public final String getState() {
        return state;
    }
}
