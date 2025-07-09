package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumberFileProcessor{
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Dell\\java-program\\demo\\src\\main\\resources\\Num.txt"; // Change this to your actual file path if needed
        double sum = 0;
        int count = 0;

        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.isEmpty()) {
                    continue; // Skip empty lines
                }

                try {
                    double number = Double.parseDouble(line);
                    sum += number;
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format, skipping line: " + line);
                }
            }

            if (count == 0) {
                System.out.println("No valid numbers found in the file.");
            } else {
                double average = sum / count;
                System.out.println("Sum = " + sum);
                System.out.println("Average = " + average);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found -> " + fileName);
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
