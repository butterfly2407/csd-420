// Katie Hilliard, M4 Assignment, 04/06/2025

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {
        System.out.println("Test with 50,000 integers:");
        testTraversalTimes(50000);

        System.out.println("\nTest with 500,000 integers:");
        testTraversalTimes(500000);
    }

    private static void testTraversalTimes(int size) {
        LinkedList<Integer> list = new LinkedList<>();

        // Generate the list
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        // Traverse the list using Iterator
        long startIterator = System.nanoTime();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endIterator = System.nanoTime();
        long iteratorTime = endIterator - startIterator;
        System.out.println("Iterator traversal time: " + iteratorTime / 1_000_000 + " ms");

        // Traverse the list using get(index)
        long startGet = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long endGet = System.nanoTime();
        long getTime = endGet - startGet;
        System.out.println("get(index) traversal time: " + getTime / 1_000_000 + " ms");

        // Test code for validation
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != i) {
                System.out.println("Error at index " + i);
                return;
            }
        }
        System.out.println("Test complete, all values correct.");
    }
}
