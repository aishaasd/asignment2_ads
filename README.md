# Custom Data Structures in Java
`Author: G by Grayson`

This project implements a set of custom generic data structures in Java without using the built-in `java.util.*` collections (except `Iterator`). It includes:

- `MyArrayList`
- `MyLinkedList` (Doubly Linked List)
- `MyStack`
- `MyQueue`
- `MyMinHeap`

Each class implements or utilizes the `MyList` interface where applicable. All structures are designed for learning purposes and mimic the behavior of standard Java data structures.

## Structure

- `MyList.java` — Generic interface defining core list operations.
- `MyArrayList.java` — Array-backed dynamic list implementation.
- `MyLinkedList.java` — Doubly linked list with support for adding/removing from both ends.
- `MyStack.java` — LIFO stack based on `MyArrayList`.
- `MyQueue.java` — FIFO queue based on `MyLinkedList`.
- `MyMinHeap.java` — Binary heap (min-oriented) using a generic array-based approach.
- `Main.java` — Test class to demonstrate the functionality of all the above.

## Features

### MyList Interface
Defines core operations for any list:
- `add`, `remove`, `get`, `set`, `clear`, `exists`, `toArray`, `indexOf`, `lastIndexOf`, etc.

### MyArrayList
- Resizable array structure
- Constant-time random access
- Doubles size when full

### MyLinkedList
- Doubly linked list
- Efficient add/remove from head or tail
- Custom node structure prevents cyclic loops

### MyStack
- Last-In-First-Out behavior
- Built on top of `MyArrayList`

### MyQueue
- First-In-First-Out behavior
- Built on top of `MyLinkedList`

### MyMinHeap
- Maintains smallest element at root
- Supports `add`, `peek`, `poll`, and heapify operations
- Generic implementation using comparisons

## How to Run

Compile and run `Main.java` to see test outputs:

```bash
javac *.java
java Main
