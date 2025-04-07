// Katie Hilliard, Module3 Assignment, 04/05/2025

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;

public class NewArrayList {

    public static void main(String[] args) {
        int[] randomNumbers = new int[50];
        Random rand = new Random();

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = rand.nextInt(20) + 1;
        }

        // Copy the array to an ArrayList
        ArrayList<Integer> originalList = new ArrayList<>();
        for (int num : randomNumbers) {
            originalList.add(num);
        }

        // Show the original list
        System.out.println("Original ArrayList (with duplicates):");
        System.out.println(originalList);

        ArrayList<Integer> noDuplicates = removeDuplicates(originalList);

        System.out.println("\nArrayList after removing duplicates:");
        System.out.println(noDuplicates);
    }

    // Generic method used to remove duplicates
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }
}
