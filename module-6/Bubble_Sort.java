// Katie Hilliard, M6 Assignment, 04/20/2025

import java.util.Comparator;

public class Bubble_Sort {

    // Sort using Comparable interface
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        E temp;
        for (int i = 0; i < list.length - 1; ++i) {
            for (int j = 0; j < list.length - 1; ++j) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    System.out.println("Elements switched using Comparable");
                }
            }
            printArray(list);
        }
    }

    // Sort using Comparator interface
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        E temp;
        for (int i = 0; i < list.length - 1; ++i) {
            for (int j = 0; j < list.length - 1; ++j) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    System.out.println("Elements switched using Comparator");
                }
            }
            printArray(list);
        }
    }

    // Print array
    public static <E> void printArray(E[] arrayParam) {
        System.out.print("\nArray = { ");
        for (E e : arrayParam) {
            System.out.print("[" + e + "] ");
        }
        System.out.println("}\n");
    }

    // Test methods
    public static void main(String[] args) {
        // Testing Comparable method
        Integer[] intValues = {24, 7, 19, 11, 30, 5, 27, 12};
        System.out.println("Before sorting (Comparable):");
        printArray(intValues);
        bubbleSort(intValues);
        System.out.println("After sorting (Comparable):");
        printArray(intValues);

        // Testing Comparator method
        String[] nameList = {"Katie", "Jalen", "Myles", "Naomi"};
        System.out.println("Before sorting (Comparator):");
        printArray(nameList);
        bubbleSort(nameList, (a, b) -> a.compareTo(b));
        System.out.println("After sorting (Comparator):");
        printArray(nameList);
    }
}
