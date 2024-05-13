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

    public Object getOldValue() {
        return oldValue;
    }
    public Object getNewValue() {
        return newValue;
    }

    public String getState() {
        return state;
    }
}
