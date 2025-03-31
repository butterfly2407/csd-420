// Katie Hilliard, Module2 Assignment, 03/30/2025

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) {
        Random rand = new Random();
        String fileName = "Katie_datafile.dat";

        try (FileWriter writer = new FileWriter(fileName, true)) { // true = append mode
            writer.write("Integers: ");
            for (int i = 0; i < 5; i++) {
                int randomInt = rand.nextInt(100); // A random integer will be chosen between 0 and 99
                writer.write(randomInt + " ");
            }

            writer.write("\nDoubles: ");
            for (int i = 0; i < 5; i++) {
                double randomDouble = rand.nextDouble() * 100; // A random double integer will be chosen between 0 and 99
                writer.write(String.format("%.2f ", randomDouble));
            }

            writer.write("\n---\n");
            System.out.println("Data has been saved successfully! " + fileName);
        } catch (IOException e) {
            System.out.println("Sorry, an error occurred: " + e.getMessage());
        }
    }
}

