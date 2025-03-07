
class Book {

    private String id;
    private String name;
    private String author;
    private String department;  //i have decleare the attributes(variables) of the book class(private) so that they can't be accessed directly from outside the class

    public Book(String id, String name, String author, String department) {
        this.id = id;      /*i have created a constructor to initialize the attributes of the book class. this.id refers to the id attribute of the book class and id refers to the id parameter of the constructor*/
        this.name = name;
        this.author = author;
        this.department = department;
    }
    //i have created the getter methods to access the attributes of the private attributes of the book class

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDepartment() {
        return department;
    }
    //the @Override annotation is used to inform the compiler that the element is meant to override an element declared in a superclass
    //this method is used to return the string representation of the object
    //it is recommended to override the toString() method in the class

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Author: " + author + ", Department: " + department;
    }
}
