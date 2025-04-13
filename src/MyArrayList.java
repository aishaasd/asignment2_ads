import java.util.Iterator;


public class MyArrayList<T> implements MyList<T> {
    // Array to store the list elements
    private Object[] data;

    // Current number of elements in the list
    private int size;

    // Default initial capacity
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Constructs an empty list with default initial capacity
     */
    public MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Adds an item to the end of the list
     */
    @Override
    public void add(T item) {
        ensureCapacity();
        data[size++] = item;
    }

    /**
     * Adds an item at the specified index in the list
     */
    @Override
    public void add(int index, T item) {
        checkPositionIndex(index);
        ensureCapacity();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = item;
        size++;
    }

    /**
     * Sets the element at the specified index
     */
    @Override
    public void set(int index, T item) {
        checkElementIndex(index);
        data[index] = item;
    }

    /**
     * Returns the number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Gets the element at the specified index
     */
    @Override
    public T get(int index) {
        checkElementIndex(index);
        return (T) data[index];
    }

    /**
     * Adds an item to the beginning of the list
     */
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    /**
     * Adds an item to the end of the list
     */
    @Override
    public void addLast(T item) {
        add(item);
    }

    /**
     * Removes the element at the specified index
     */
    @Override
    public void remove(int index) {
        checkElementIndex(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(data, index + 1, data, index, numMoved);
        }
        data[--size] = null;
    }

    /**
     * Removes the first element in the list
     */
    @Override
    public void removeFirst() {
        if (size > 0) remove(0);
    }

    /**
     * Removes the last element in the list
     */
    @Override
    public void removeLast() {
        if (size > 0) remove(size - 1);
    }

    /**
     * Checks if the list contains the specified object
     */
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    /**
     * Returns the index of the first occurrence of the specified object
     */
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(object)) return i;
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified object
     */
    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(object)) return i;
        }
        return -1;
    }

    /**
     * Converts the list to an array
     */
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

    /**
     * Clears all elements from the list
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    /**
     * Returns the first element in the list
     */
    @Override
    public T getFirst() {
        return size > 0 ? get(0) : null;
    }

    /**
     * Returns the last element in the list
     */
    @Override
    public T getLast() {
        return size > 0 ? get(size - 1) : null;
    }

    /**
     * Returns an iterator over the elements in this list
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }
            @Override
            public T next() {
                return (T) data[index++];
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

    // Ensures there is enough capacity in the array; if not, increases it
    private void ensureCapacity() {
        if (size == data.length) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    // Validates index for getting or setting elements
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // Validates index for adding elements
    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}