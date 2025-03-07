
import java.util.*;

public class Main_Library_Management_System {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name;
        System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
        System.out.println("         Welcome to Lynex Library");
        System.out.println();
        System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
        System.out.println("Choose a number to your role");
        int role = 0;
        while (true) {  // we use this loop to make sure the user enters the correct value provided....
            System.out.println("1. Librarian");
            System.out.println("2. Student");
            System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
            try {  // to handle the exception when the user enters a mismatch input..we call it try...catch//remember throw
                role = scanner.nextInt();
                scanner.nextLine();  // always remember to add scanner.nextline() to Consume newline left-over by nextInt(),nextDouble(),nextFloat(),nextLong(),nextShort() or nextByte()
                if (role == 1 || role == 2) {
                    break;
                } else {
                    System.out.println("invalid role,please select a number");
                }
            } catch (InputMismatchException e) {
                System.out.println("invalid input,please enter a number!!");
                scanner.nextLine();
            }
            //  System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
        }
        System.out.println("do you have an account?  Choose a number to");
        int account = 0;
        while (true) {
            System.out.println("1. Log in");
            System.out.println("2. Sign up");
            System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
            try {
                account = scanner.nextInt();
                scanner.nextLine();
                if (account == 1 || account == 2) {
                    break;
                } else {
                    System.out.println("invalid option,please choose your number!!");
                }
            } catch (InputMismatchException e) {
                System.out.println("invalid input.please enter a number");
                scanner.nextLine();
            }
        }
        if (account == 2) {
            System.out.println("Enter your name");
            name = scanner.nextLine().toLowerCase();  //i want to convert all names in my code to lowercase
            System.out.println("Enter your password");
            String password = scanner.nextLine();
            System.out.println("sign up successful");
            System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
            System.out.println("Now log in to your account");
            System.out.println("Enter your name");
            String name2 = scanner.nextLine().toLowerCase();
            System.out.println("Enter your password");
            String password2 = scanner.nextLine();
            if (name.equals(name2) && password.equals(password2)) {   //in java we use the .equals() method to compare strings rather than the == operator
                System.out.println("  ");

            } else {
                System.out.print("Wrong details");
                // break;
                return;
            }
        } else {
            System.out.println(" Enter your name");
            name = scanner.nextLine().toLowerCase();
            System.out.println("No account with that name. Please sighn up");
            return;
            //    break;
        }

        if (role == 1) {
            System.out.println("Welcome to Lynex Library, Librarian " + name);
            while (true) {
                System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
                 //System.out.println(" ");
                //   System.out.println(" ");
                System.out.println("Choose a number to your action");
                System.out.println("1. View available books");
                System.out.println("2. Add book");
                System.out.println("3. Remove book");
                System.out.println("4. Issue book");
                System.out.println("5. Returned book");
                System.out.println("6. Black listed borrowers");
                System.out.println("7. Exit");
                System.out.println(" ");
                // System.out.println(" ");
                System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
                int action = 0;
                while (true) {
                    try {
                        action = scanner.nextInt();
                        scanner.nextLine();
                        if (action >= 1 && action <= 7) {
                            break;
                        } else {
                            System.out.println("invalid option,please choose a number");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("invalid input,please enter a number");
                        scanner.nextLine();
                    }
                }
                if (action == 1) {
                    Books.viewBooks();
                } else if (action == 2) {
                    System.out.println("Enter the name of the book to add");
                    String bookName = scanner.nextLine();
                    System.out.println("Enter the author of the book");
                    String author = scanner.nextLine();
                    System.out.println("Enter the department of the book");
                    String department = scanner.nextLine();
                    Books.addBook(bookName, author, department);
                } else if (action == 3) {
                    System.out.println("Enter the ID of the book to remove");
                    String id = scanner.nextLine();
                    Books.removeBook(id);
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
                    System.out.println("See you next time Librarian " + name);
                    break;
                }
            }
        } else {
            System.out.println("Welcome to Lynex Library, Student " + name);
            while (true) {
                System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
                //  System.out.println(" ");
                System.out.println(" ");
                System.out.println("Choose a number to your action");
                System.out.println("1. view available books");
                System.out.println("2. Borrow book");
                System.out.println("3. Confirm returned book");
                System.out.println("4. Visit e-books");
                System.out.println("5. Visit Lynex Library website");
                System.out.println("6. Rate our service");
                System.out.println("7. Report issues");
                System.out.println("8. Exit");
                System.out.println(" ");
                //  System.out.println(" ");
                System.out.println("***  ==  ***  ==  ***  ==  ***  ==  ***  ==  ***");
                int action = 0;
                while (true) {
                    try {
                        action = scanner.nextInt();
                        scanner.nextLine();
                        if (action >= 1 && action <= 8) {
                            break;
                        } else {
                            System.out.println("invalid option,please choose a number");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("invalid input,please enter a number");
                        scanner.nextLine();
                    }
                }
                if (action == 1) {
                    Books.viewBooks();
                } else if (action == 2) {
                    System.out.println("Enter the name of the book to borrow");
                    String book = scanner.nextLine().toLowerCase();
                    System.out.println(book + " has been borrowed successfully");
                    System.out.println("pick your book from the librarians counter");
                    System.out.println("return the book within 7 days");
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
                                System.out.println("invalid rate,please rate from 1 to 5");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("invalid input,please enter a number");
                            scanner.nextLine();
                        }
                    }
                    System.out.println("Thank you for rating our service " + rate);
                } else if (action == 7) {
                    System.out.println("Enter your issue");
                    String issue = scanner.nextLine().toLowerCase();
                    System.out.println("Thank you for reporting your issue");
                } else if (action == 8) {
                    System.out.println("See you next time Student " + name);
                    break;
                }
            }
        }
        scanner.close();
    }

}
/*   *plan*
-Welcome to lynex library,,,Enter your role...
-log in and sighn in
-enter name and password
-if sighn in ,welcome 'name' happy to see you / if loggin welcome back 'name'--happy to see you again!!

1.librarian
--view available books
--remove book
--add book
//--issue book--(then automatically)records(borrowed book vs borrower)
--black listed borrowers
--return date




2.student
--book to borrow book
--confirm returned book
--visit e-books
--visit lynex library website
--rate our service
--report issues


logic
subtruct/add book according to the action taken
book name,auther,availability,
user cannot borrow unavailable book
record borrowed book and borrower
black list borrowers
implement return time and date
penalties when deadline not met(how many days to not borrow books)
book quality before and after borrowing

please note on the deadline,,happy studying!!
please pick your book from the counter
thank you for your cooperation(after returning book)
 */

//the return statement is used to exit a method, and the break statement is used to exit a loop or switch statement.
//The return statement is used to end the execution of a method, and the break statement is used to end the execution of a loop or switch statement.
//in my case it terminates the main method
// after recieving the book from the librarian, the student should recieeve a message showing the deadline for returning the book
//the librarian should also recieve a message showing the deadline for the student to return the book












/*the program should add the book permanently
 user should never recieve unavailable books
 or librarian to issue unavailable books
 more ... password */