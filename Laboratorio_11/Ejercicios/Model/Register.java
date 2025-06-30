package Model;

public class Register {
    private int key;
    private String name;
    private boolean deleted;

    public Register(int key, String name) {
        this.key = key;
        this.name = name;
        this.deleted = false;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return deleted ? "[deleted]" : key + ": " + name;
    }
}
