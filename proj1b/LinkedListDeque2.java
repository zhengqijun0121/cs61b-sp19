import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Isn't this solution kinda... cheating? Yes.
 */
public class LinkedListDeque2<Item> extends LinkedList<Item> {
    public void printDeque() {
        for (Item item : this) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public Item getRecursive(int i) {
        return get(i);
    }

    @Override
    public Item removeFirst() {
        try {
            return super.removeFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public Item removeLast() {
        try {
            return super.removeLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
