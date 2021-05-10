public class LinkedListDeque<T> {
    private class StuffNode {
        public T item;
        public StuffNode prev;
        public StuffNode next;

        public StuffNode(T i, StuffNode p, StuffNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private StuffNode sentinel;  /* The first item (if it exists) is at sentinel.next. */
    private StuffNode recursion;
    private int size;

    /** Creates an empty linked list deque. */
    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        recursion = sentinel;
        size = 0;
    }

    /** Creates a deep copy of other.
     *  @source https://www.youtube.com/watch?v=JNroRiEG7U4 */
    @SuppressWarnings("unchecked")
    public LinkedListDeque(LinkedListDeque other) {
        this();
        size += other.size;
        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i));
        }
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        StuffNode tmp = new StuffNode(item, sentinel, sentinel.next);
        sentinel.next.prev = tmp;
        sentinel.next = tmp;
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        StuffNode tmp = new StuffNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = tmp;
        sentinel.prev = tmp;
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque. */
    public void printDeque() {
        StuffNode tmp = sentinel.next;
        while (tmp != sentinel) {
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque. */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;

        return item;
    }

    /** Removes and returns the item at the back of the deque. */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;

        return item;
    }

    /** Gets the item at the given index. */
    public T get(int index) {
        if (isEmpty()) {
            return null;
        }

        StuffNode tmp = sentinel.next;
        while (tmp != sentinel && index > 0) {
            tmp = tmp.next;
            index -= 1;
        }

        if (tmp == sentinel) {
            return null;
        } else {
            return tmp.item;
        }
    }

    /** Same as get, but uses recursion. */
    public T getRecursive(int index) {
        recursion = recursion.next;
        if (index == 0 && recursion != sentinel) {
            T result = recursion.item;
            recursion = sentinel;
            return result;
        } else if (index != 0 && recursion == sentinel) {
            return null;
        } else {
            return getRecursive(index - 1);
        }
    }
}
