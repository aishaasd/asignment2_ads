class MyMinHeap<T extends Comparable<T>> {
    private Object[] heap;
    private int size;

    /**
     * Constructs an empty min-heap with initial capacity.
     */
    public MyMinHeap() {
        heap = new Object[10];
        size = 0;
    }

    /**
     * Adds a new element to the heap.
     */
    public void add(T value) {
        ensureCapacity();
        heap[size] = value;
        siftUp(size);
        size++;
    }

    /**
     * Removes and returns the minimum element from the heap.
     */
    public T removeMin() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        T min = (T) heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return min;
    }

    /**
     * Returns the minimum element without removing it.
     */
    public T peek() {
        if (size == 0) throw new IllegalStateException("Heap is empty");
        return (T) heap[0];
    }

    /**
     * Returns the number of elements in the heap.
     */
    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size >= heap.length) {
            Object[] newHeap = new Object[heap.length * 2];
            System.arraycopy(heap, 0, newHeap, 0, heap.length);
            heap = newHeap;
        }
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (((T) heap[index]).compareTo((T) heap[parent]) >= 0) break;
            swap(index, parent);
            index = parent;
        }
    }

    private void siftDown(int index) {
        while (index * 2 + 1 < size) {
            int child = index * 2 + 1;
            if (child + 1 < size && ((T) heap[child + 1]).compareTo((T) heap[child]) < 0) {
                child++;
            }
            if (((T) heap[index]).compareTo((T) heap[child]) <= 0) break;
            swap(index, child);
            index = child;
        }
    }

    private void swap(int i, int j) {
        Object temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}