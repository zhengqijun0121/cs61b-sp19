/** Circular ArrayDeque */
public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty array deque. */
    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    /** Creates a deep copy of other. */
    @SuppressWarnings("unchecked")
    public ArrayDeque(ArrayDeque other) {
        size += other.size;
        for (int i = 0; i < other.size; i++) {
            addLast((T) other.get(i));
        }
    }

    /** Resizes in the deque */
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        int index = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            newItems[i] = items[index];
            index = plusOne(index);
        }

        items = newItems;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    /** Computed the index */
    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    /** Computed the index */
    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }

        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }

        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size() == 0;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque. */
    public void printDeque() {
        int i = plusOne(nextFirst);
        for (int j = 0; j < size; j++) {
            System.out.print(items[i] + " ");
            i = plusOne(i);
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque. */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T tmp = items[plusOne(nextFirst)];
        items[plusOne(nextFirst)] = null;
        nextFirst = plusOne(nextFirst);
        size -= 1;
        if (items.length > 16 && size < (items.length / 4)) {
            resize(items.length / 2);
        }

        return tmp;
    }

    /** Removes and returns the item at the back of the deque. */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T tmp = items[minusOne(nextLast)];
        items[minusOne(nextLast)] = null;
        nextLast = minusOne(nextLast);
        size -= 1;
        if (items.length > 16 && size < (items.length / 4)) {
            resize(items.length / 2);
        }

        return tmp;
    }

    /** Gets the item at the given index. */
    public T get(int index) {
        if (index >= size) {
            return null;
        }

        int start = plusOne(nextFirst);
        return items[(start + index) % items.length];
    }
}
