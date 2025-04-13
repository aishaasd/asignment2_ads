public class Main {
    public static void main(String[] args) {
        testMyArrayList();
        testMyLinkedList();
    }

    public static void testMyArrayList() {
        System.out.println("Testing MyArrayList...");
        MyArrayList<String> list = new MyArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("After adding A, B, C: " + java.util.Arrays.toString(list.toArray()));

        list.add(1, "X");
        System.out.println("After inserting X at index 1: " + java.util.Arrays.toString(list.toArray()));

        list.set(0, "Z");
        System.out.println("After setting index 0 to Z: " + java.util.Arrays.toString(list.toArray()));

        list.remove(2);
        System.out.println("After removing index 2: " + java.util.Arrays.toString(list.toArray()));

        System.out.println("Element at index 1: " + list.get(1));
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());

        System.out.println("Index of 'Z': " + list.indexOf("Z"));
        System.out.println("Last index of 'X': " + list.lastIndexOf("X"));
        System.out.println("Exists 'B': " + list.exists("B"));

        list.clear();
        System.out.println("After clear(): " + java.util.Arrays.toString(list.toArray()));
    }

    public static void testMyLinkedList() {
        System.out.println("\nTesting MyLinkedList...");
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("After adding A, B, C: " + java.util.Arrays.toString(list.toArray()));

        list.add(1, "X");
        System.out.println("After inserting X at index 1: " + java.util.Arrays.toString(list.toArray()));

        list.set(0, "Z");
        System.out.println("After setting index 0 to Z: " + java.util.Arrays.toString(list.toArray()));

        list.remove(2);
        System.out.println("After removing index 2: " + java.util.Arrays.toString(list.toArray()));

        System.out.println("Element at index 1: " + list.get(1));
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());

        System.out.println("Index of 'Z': " + list.indexOf("Z"));
        System.out.println("Last index of 'X': " + list.lastIndexOf("X"));
        System.out.println("Exists 'B': " + list.exists("B"));

        list.clear();
        System.out.println("After clear(): " + java.util.Arrays.toString(list.toArray()));
    }
}
