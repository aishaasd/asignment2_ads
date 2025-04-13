class MyStack<T> {
    private MyArrayList<T> list;

    /**
     * Constructs an empty stack.
     */
    public MyStack() {
        list = new MyArrayList<>();
    }

    /**
     * Pushes an element onto the top of the stack.
     */
    public void push(T item) {
        list.addLast(item);
    }

    /**
     * Removes and returns the element at the top of the stack.
     */
    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        T item = list.getLast();
        list.removeLast();
        return item;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     */
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.getLast();
    }

    /**
     * Checks if the stack is empty.
     */
    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * Returns the number of elements in the stack.
     */
    public int size() {
        return list.size();
    }
}

