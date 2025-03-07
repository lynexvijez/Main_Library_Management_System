import java.util.ArrayList;
import java.util.List; 

class Books {
    private static List<Book> bookList = new ArrayList<>(); 
    //i have created a list of book objects to store the books
    private static int nextId=1;
    static {
        // this is the content and i need to Initialize with some books
        //in this list we are creating an instant of the book class with different parameters
        bookList.add(new Book(String.valueOf(nextId++), "Java", "felo", "Computer Science"));
        bookList.add(new Book(String.valueOf(nextId++), "Python", "lynex", "Computer Science"));
        bookList.add(new Book(String.valueOf(nextId++), "C++", "vijez", "Computer Science"));
        bookList.add(new Book(String.valueOf(nextId++), "C#", "joshua", "Computer Science"));
        bookList.add(new Book(String.valueOf(nextId++), "Ruby", "momanyi", "Computer Science"));
    }

    static void viewBooks() {  //we are using static keyword so that we can call this method without creating an object of the class.it simply means that the method belongs to the class and not the object of the class
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
        } else {
            System.out.println("Book with ID " + id + " not found.");
        }
    }
}