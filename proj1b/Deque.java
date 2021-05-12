public interface Deque<Item> {
    /** Adds an item of type Item to the front of the deque. */
    void addFirst(Item item);

    /** Adds an item of type Item to the back of the deque. */
    void addLast(Item item);

    /** Returns true if deque is empty, false otherwise. */
    default boolean isEmpty() {
        return size() == 0;
    }

    /** Returns the number of items in the deque. */
    int size();

    /** Prints the items in the deque. */
    void printDeque();

    /** Removes and returns the item at the front of the deque. */
    Item removeFirst();

    /** Removes and returns the item at the back of the deque. */
    Item removeLast();

    /** Gets the item at the given index. */
    Item get(int index);
}
