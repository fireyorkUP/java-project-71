package hexlet.code;

public class Differences {
    private final Object oldValue;
    private final Object newValue;

    private final String correct;

    public Differences(Object oldValue, Object newValue, String correct) {
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.correct = correct;
    }

    public Object getOldValue() {
        return oldValue;
    }
    public Object getNewValue() {
        return newValue;
    }

    public String tapDifferences() {
        return correct;
    }
}
