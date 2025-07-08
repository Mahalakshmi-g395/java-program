package app;

import service.LibraryService;
import util.InputUtil;

public class LibraryApp {
    public static void main(String[] args) {
        LibraryService library = new LibraryService();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. View Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Add Member");
            System.out.println("5. Exit");

            int choice = InputUtil.readInt("Enter choice: ");

            switch (choice) {
                case 1 -> library.listBooks();
                case 2 -> {
                    library.listBooks();
                    int bookIndex = InputUtil.readInt("Enter book index to borrow: ");
                    library.borrowBook(bookIndex);
                }
                case 3 -> {
                    library.listBooks();
                    int bookIndex = InputUtil.readInt("Enter book index to return: ");
                    library.returnBook(bookIndex);
                }
                case 4 -> {
                    String name = InputUtil.readString("Enter member name: ");
                    library.addMember(name);
                }
                case 5 -> exit = true;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }

        System.out.println("Exiting Library System. Goodbye!");
    }
}

