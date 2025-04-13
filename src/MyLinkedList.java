import java.util.Iterator;


public class MyLinkedList<T> implements MyList<T> {
    // Pointer to the first node in the list
    private MyNode<T> head;

    // Pointer to the last node in the list
    private MyNode<T> tail;

    // Tracks the number of elements in the list
    private int size;

    /**
     * Default constructor initializes an empty list
     */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds an item to the end of the list
     */
    @Override
    public void add(T item) {
        addLast(item);
    }

    // Validates index for access operations
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }


    /**
     * Sets an item at the specified index
     */
    @Override
    public void set(int index, T item) {
        checkIndex(index);
        MyNode<T> current = getNode(index);
        current.data = item;
    }

    /**
     * Adds an item at a specific index in the list
     */
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            MyNode<T> current = getNode(index);
            MyNode<T> newNode = new MyNode<>(item);
            MyNode<T> prev = current.prev;
            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = current;
            current.prev = newNode;
            size++;
        }
    }

    /**
     * Adds an item to the beginning of the list
     */
    @Override
    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * Adds an item to the end of the list
     */
    @Override
    public void addLast(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Returns the number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes the element at the specified index
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        MyNode<T> toRemove = getNode(index);
        removeNode(toRemove);
    }

    /**
     * Removes the first element in the list
     */
    @Override
    public void removeFirst() {
        if (head == null) return;
        removeNode(head);
    }

    /**
     * Removes the last element in the list
     */
    @Override
    public void removeLast() {
        if (tail == null) return;
        removeNode(tail);
    }

    /**
     * Returns the index of the first occurrence of the specified object
     */
    @Override
    public int indexOf(Object object) {
        MyNode<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(object)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified object
     */
    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.data.equals(object)) return index;
            current = current.prev;
            index--;
        }
        return -1;
    }

    /**
     * Checks if the list contains the specified object
     */
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    /**
     * Converts the list to an array
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode<T> current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    /**
     * Clears all elements from the list
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Gets the element at a specific index
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    /**
     * Returns the first element in the list
     */
    @Override
    public T getFirst() {
        return (head != null) ? head.data : null;
    }

    /**
     * Returns the last element in the list
     */
    @Override
    public T getLast() {
        return (tail != null) ? tail.data : null;
    }

    /**
     * Returns an iterator over the elements in this list
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    /**
     * Sort method placeholder (not implemented)
     */
    @Override
    public void sort() {
        // Sorting logic can be implemented here
    }

    // Returns node at specific index
    private MyNode<T> getNode(int index) {
        MyNode<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    // Removes a node safely and prevents loops
    private void removeNode(MyNode<T> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }

        size--;
    }

    /**
     * Inner class representing a node in a doubly linked list
     */
    private static class MyNode<T> {
        T data;
        MyNode<T> next;
        MyNode<T> prev;

        public MyNode(T data) {
            this.data = data;
        }
    }
}



