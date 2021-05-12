public class LinkedListDeque<Item> implements Deque<Item> {
    private class StuffNode {
        public Item item;
        public StuffNode prev;
        public StuffNode next;

        public StuffNode(Item i, StuffNode p, StuffNode n) {
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
            addLast((Item) other.get(i));
        }
    }

    /** Adds an item of type Item to the front of the deque. */
    @Override
    public void addFirst(Item item) {
        StuffNode tmp = new StuffNode(item, sentinel, sentinel.next);
        sentinel.next.prev = tmp;
        sentinel.next = tmp;
        size += 1;
    }

    /** Adds an item of type Item to the back of the deque. */
    @Override
    public void addLast(Item item) {
        StuffNode tmp = new StuffNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = tmp;
        sentinel.prev = tmp;
        size += 1;
    }

    /** Returns the number of items in the deque. */
    @Override
    public int size() {
        return size;
    }

    /** Prints the items in the deque. */
    @Override
    public void printDeque() {
        StuffNode tmp = sentinel.next;
        while (tmp != sentinel) {
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque. */
    @Override
    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Item item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;

        return item;
    }

    /** Removes and returns the item at the back of the deque. */
    @Override
    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }

        Item item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;

        return item;
    }

    /** Gets the item at the given index. */
    @Override
    public Item get(int index) {
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
    public Item getRecursive(int index) {
        recursion = recursion.next;
        if (index == 0 && recursion != sentinel) {
            Item result = recursion.item;
            recursion = sentinel;
            return result;
        } else if (index != 0 && recursion == sentinel) {
            return null;
        } else {
            return getRecursive(index - 1);
        }
    }
}
