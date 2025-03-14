import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Books {
    private static List<Book> bookList = new ArrayList<>();
    private static final String FILE_PATH = "books.txt";
    private static int nextId = 1;

    static {
        // Initialize with some books
        bookList.add(new Book(String.valueOf(nextId++), "Java", "felo", "Computer Science"));
        bookList.add(new Book(String.valueOf(nextId++), "Python", "lynex", "Computer Science"));
        bookList.add(new Book(String.valueOf(nextId++), "C++", "vijez", "Computer Science"));
        bookList.add(new Book(String.valueOf(nextId++), "C#", "joshua", "Computer Science"));
        bookList.add(new Book(String.valueOf(nextId++), "Ruby", "momanyi", "Computer Science"));
        writeBooksToFile();
    }

    static void viewBooks() {
        System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
        System.out.println("Available books are:");
        for (Book book : bookList) {
            System.out.println(book);
        }
        System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
    }

    static void addBook(String name, String author, String department) {
        String id = String.valueOf(nextId++);
        bookList.add(new Book(id, name, author, department));
        System.out.println(name + " has been added with ID: " + id);
        writeBooksToFile();
    }

    static void removeBook(String id) {
        Book bookToRemove = null;
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            bookList.remove(bookToRemove);
            System.out.println(bookToRemove.getName() + " has been removed.");
            writeBooksToFile();
        } else {
            System.out.println("Book with ID " + id + " not found.");
        }
    }

    private static void writeBooksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Book book : bookList) {
                writer.write(book.getId() + "," + book.getName() + "," + book.getAuthor() + "," + book.getDepartment());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing books to file: " + e.getMessage());
        }
    }

    static void readBooksFromFile() {
        bookList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    bookList.add(new Book(parts[0], parts[1], parts[2], parts[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading books from file: " + e.getMessage());
        }
    }
}