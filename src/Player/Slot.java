package Player;

public class Slot<T> {
    private T item;

    public Slot(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "item=" + item
                ;
    }
}

