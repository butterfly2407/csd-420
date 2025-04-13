// Katie Hilliard, M5 Assignment, 04/13/2025

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SortUniqueWords {

    public static void main(String[] args) {
        List<String> words = readWordsFromFile("collection_of_words.txt");

        if (words.isEmpty()) {
            System.out.println("No words found in file.");
            return;
        }

        // Use TreeSet to remove duplicate words
        Set<String> uniqueWords = new TreeSet<>(words);

        // Non-duplicate words in ascending order
        System.out.println("Non-duplicate words in ascending order:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }

        // Non-duplicate in descending order
        System.out.println("\nNon-duplicate words in descending order:");
        List<String> descendingList = new ArrayList<>(uniqueWords);
        Collections.reverse(descendingList);
        for (String word : descendingList) {
            System.out.println(word);
        }
    }

    public static List<String> readWordsFromFile(String filename) {
        List<String> wordList = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    wordList.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }

        return wordList;
    }
}

