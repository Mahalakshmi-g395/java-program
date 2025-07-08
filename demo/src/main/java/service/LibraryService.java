package service;

import model.Book;
import model.Member;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private List<Book> books;
    private List<Member> members;

    public LibraryService() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        seedData();
    }

    private void seedData() {
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee"));
    }

    public void addMember(String name) {
        members.add(new Member(name));
        System.out.println("Member " + name + " added.");
    }

    public void listBooks() {
        for (int i = 0; i < books.size(); i++) {
            System.out.println(i + ". " + books.get(i));
        }
    }

    public void borrowBook(int index) {
        if (index < 0 || index >= books.size()) {
            System.out.println("Invalid book index.");
            return;
        }

        Book book = books.get(index);
        if (book.isAvailable()) {
            book.borrowBook();
            System.out.println("You borrowed: " + book.getTitle());
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    public void returnBook(int index) {
        if (index < 0 || index >= books.size()) {
            System.out.println("Invalid book index.");
            return;
        }

        Book book = books.get(index);
        if (!book.isAvailable()) {
            book.returnBook();
            System.out.println("You returned: " + book.getTitle());
        } else {
            System.out.println("Book is already available.");
        }
    }
}


