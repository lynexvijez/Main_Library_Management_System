import java.util.*;

public class Main_Library_Management_System {

    private static String name;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
        System.out.println("         Welcome to Lynex Library");
        System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");

        Books.readBooksFromFile(); // Read books from file at the start

        int role = 0;
        while (true) {
            System.out.println("Choose a number to your role");
            System.out.println("1. Librarian");
            System.out.println("2. Student");
            System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
            try {
                role = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
                if (role == 1 || role == 2) {
                    break;
                } else {
                    System.out.println("Invalid role, please select a number");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number!!");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        System.out.println("Do you have an account? Choose a number to");
        int account = 0;
        while (true) {
            System.out.println("1. Log in");
            System.out.println("2. Sign up");
            System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
            try {
                account = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
                if (account == 1 || account == 2) {
                    break;
                } else {
                    System.out.println("Invalid option, please choose your number!!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        if (account == 2) {
            System.out.println("Enter your name");
            name = scanner.nextLine().toLowerCase(); // Convert input to lowercase
            System.out.println("Enter your password");
            String password = scanner.nextLine();
            UserDataManager.writeUserData(name, password);
            System.out.println("Sign up successful");
            System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
            System.out.println("Now log in to your account");
        }

        System.out.println("Enter your name");
        String name2 = scanner.nextLine().toLowerCase();
        System.out.println("Enter your password");
        String password2 = scanner.nextLine();
        Map<String, String> userData = UserDataManager.readUserData();
        if (userData.containsKey(name2) && userData.get(name2).equals(password2)) {
            System.out.println("Welcome to your account " + name2 + ", nice to see you!!");
        } else {
            System.out.print("Wrong details");
            scanner.close();
            return;
        }

        if (role == 1) {
            System.out.println("Welcome to Lynex Library, Librarian " + name2);
            while (true) {
                System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
                System.out.println("Choose a number to your action");
                System.out.println("1. View available books");
                System.out.println("2. Remove book");
                System.out.println("3. Add book");
                System.out.println("4. Issue book");
                System.out.println("5. Return book");
                System.out.println("6. Black listed borrowers");
                System.out.println("7. Exit");
                System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
                int action = 0;
                while (true) {
                    try {
                        action = scanner.nextInt();
                        scanner.nextLine();
                        if (action >= 1 && action <= 7) {
                            break;
                        } else {
                            System.out.println("Invalid option, please choose a number");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input, please enter a number");
                        scanner.nextLine();
                    }
                }
                if (action == 1) {
                    Books.viewBooks();
                } else if (action == 2) {
                    System.out.println("Enter the ID of the book to remove");
                    String id = scanner.nextLine();
                    Books.removeBook(id);
                } else if (action == 3) {
                    System.out.println("Enter the name of the book to add");
                    String bookName = scanner.nextLine();
                    System.out.println("Enter the author of the book");
                    String author = scanner.nextLine();
                    System.out.println("Enter the department of the book");
                    String department = scanner.nextLine();
                    Books.addBook(bookName, author, department);
                } else if (action == 4) {
                    System.out.println("Enter the name of the book to issue");
                    String book = scanner.nextLine().toLowerCase();
                    System.out.println("Enter the name of the borrower");
                    String borrower = scanner.nextLine().toLowerCase();
                    System.out.println(book + " has been issued to " + borrower);
                } else if (action == 5) {
                    System.out.println("Enter the name of the book to return");
                    String book = scanner.nextLine().toLowerCase();
                    System.out.println("Enter the name of the borrower");
                    String borrower = scanner.nextLine().toLowerCase();
                    System.out.println(book + " has been returned by " + borrower);
                } else if (action == 6) {
                    System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
                    System.out.println("Black listed borrowers are:");
                    System.out.println("1. JP");
                    System.out.println("2. Mule");
                    System.out.println("3. Joy");
                    System.out.println("4. Jane");
                    System.out.println("5. Paul");
                    System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
                } else if (action == 7) {
                    System.out.println("See you next time Librarian " + name2);
                    break;
                }
            }
        } else {
            System.out.println("Welcome to Lynex Library, Student " + name2);
            while (true) {
                System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
                System.out.println("Choose a number to your action");
                System.out.println("1. View available books");
                System.out.println("2. Borrow book");
                System.out.println("3. Confirm returned book");
                System.out.println("4. Visit e-books");
                System.out.println("5. Visit Lynex Library website");
                System.out.println("6. Rate our service");
                System.out.println("7. Report issues");
                System.out.println("8. Exit");
                System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
                int action = 0;
                while (true) {
                    try {
                        action = scanner.nextInt();
                        scanner.nextLine();
                        if (action >= 1 && action <= 8) {
                            break;
                        } else {
                            System.out.println("Invalid option, please choose a number");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input, please enter a number");
                        scanner.nextLine();
                    }
                }
                if (action == 1) {
                    Books.viewBooks();
                } else if (action == 2) {
                    System.out.println("Enter the name of the book to borrow");
                    String book = scanner.nextLine().toLowerCase();
                    System.out.println(book + " has been borrowed successfully");
                    System.out.println("Pick your book from the librarian's counter");
                    System.out.println("Return the book within 7 days");
                } else if (action == 3) {
                    System.out.println("Enter the name of the book to return");
                    String book = scanner.nextLine().toLowerCase();
                    System.out.println(book + " has been returned successfully");
                    System.out.println("Thank you for returning the book");
                } else if (action == 4) {
                    System.out.println("Visit e-books at www.lynexlibrary.com");
                } else if (action == 5) {
                    System.out.println("Visit Lynex Library website at www.lynexlibrary.com");
                } else if (action == 6) {
                    System.out.println("Rate our service from 1 to 5");
                    int rate = 0;
                    while (true) {
                        try {
                            rate = scanner.nextInt();
                            scanner.nextLine();
                            if (rate >= 1 && rate <= 5) {
                                break;
                            } else {
                                System.out.println("Invalid rate, please rate from 1 to 5");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input, please enter a number");
                            scanner.nextLine();
                        }
                    }
                    System.out.println("Thank you for rating our service " + rate);
                } else if (action == 7) {
                    System.out.println("Enter your issue");
                    String issue = scanner.nextLine().toLowerCase();
                    System.out.println("Thank you for reporting your issue");
                } else if (action == 8) {
                    System.out.println("See you next time Student " + name2);
                    break;
                }
            }
        }
        scanner.close();
    }
}