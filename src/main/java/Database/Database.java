package Database;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Database {
    private static ArrayList<DATABASE_FIELDS> databaseFieldsArrayList = new ArrayList<>();
    public boolean BookPresentOrNot;

    public Database() {
        // TODO For Librarian Access
        librarianAccess();
    }

//    public Database(String Name, String Author) {
//
//    }
//
//    public Database(String Name, String Author) {
//
//    }

//--------------------------Main Librarian Access-------------------------------

    private void librarianAccess() {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
            System.out.println("ENTER '1' TO ADD BOOK, '2' TO DELETE BOOK, '3' TO UPDATE BOOK" +
                    ", '4' DISPLAY, '5' SEARCH | '6' TO EXIT");
            int input = scanner.nextInt();
            if (input == 1) {
                // TODO add book
                FuncAssigner(1);
            } else if (input == 2) {
                // TODO delete book
                FuncAssigner(2);
            } else if (input == 3) {
                // TODO update book
                FuncAssigner(3);
            } else if (input == 4) {
                // TODO display
                FuncAssigner(4);
            } else if (input == 5) {
                // TODO search
                FuncAssigner(5);
            } else if (input == 6) {
                valid = true;
                break;
            }
        }
    }

    private void FuncAssigner(int i) {


        if (i == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("ENTER TITLE");
            String title = scanner.nextLine();
            System.out.println("ENTER AUTHOR");
            String author = scanner.nextLine();
            System.out.println("ENTER ISBN");
            String isbn = scanner.nextLine();
            System.out.println("ENTER PUBLICATION");
            String publication = scanner.nextLine();
            // Add book

            if (search(title, author, isbn, publication)) {
                System.out.println("\nADDING BOOK");
                increaseNumberOfBooks(title, author);
            } else if (!search(title, author, isbn, publication)) {
                System.out.println("\nADDING BOOK");
                add(title, author, isbn, publication);
            }

        } else if (i == 2) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("ENTER TITLE");
            String title = scanner.nextLine();
            System.out.println("ENTER AUTHOR");
            String author = scanner.nextLine();
            System.out.println("ENTER ISBN");
            String isbn = scanner.nextLine();
            System.out.println("ENTER PUBLICATION");
            String publication = scanner.nextLine();
            // Delete book
            if (search(title, author, isbn, publication)) {
                delete(title, author, isbn, publication);
            } else {
                System.out.println("NO BOOK DELETED\n");
            }
        } else if (i == 3) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("ENTER TITLE");
            String title = scanner.nextLine();
            System.out.println("ENTER AUTHOR");
            String author = scanner.nextLine();
            System.out.println("ENTER ISBN");
            String isbn = scanner.nextLine();
            System.out.println("ENTER PUBLICATION");
            String publication = scanner.nextLine();
            // TODO update book


            if (search(title, author, isbn, publication)) {
                System.out.println("\nNOW ENTER CHANGES TO BE MADE :");
                System.out.println("UPDATING BOOK\n");
                System.out.println("ENTER TITLE");
                String NewTitle = scanner.nextLine();
                System.out.println("ENTER AUTHOR");
                String NewAuthor = scanner.nextLine();
                System.out.println("ENTER ISBN");
                String ISBN = scanner.nextLine();
                System.out.println("ENTER PUBLICATION");
                String NewPublication = scanner.nextLine();
                update(NewTitle, NewAuthor, ISBN, NewPublication, title);
            } else if (!search(title, author, isbn, publication)) {
                System.out.println("NO SUCH BOOK FOUND");
                System.out.println();
            }
        } else if (i == 4) {
            // TODO display
            display();
        } else if (i == 5) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("ENTER TITLE");
            String title = scanner.nextLine();
            System.out.println("ENTER AUTHOR");
            String author = scanner.nextLine();
            // TODO search

            search(title, author, 1);
        }
    }

//-----------------------------Book Access---------------------------------------

    public Database(String title, String book, int val) {
        if (val == 1) {
            BookPresentOrNot = search(title, book, 2);
        } else if (val == 2) {
            delete(title, book, null, null);
        }
    }

//-----------------------------Account Access------------------------------------

    public Database(String title, String book, String val, int loopEntry) {
        if (loopEntry == 1) {
            if (search(title, book, 3)) {
                System.out.println("RETURNING BOOK");
                BookPresentOrNot = true;
            }
        }
        if (loopEntry == 2) {
            if (Objects.equals(val, "2")) {
                increaseNumberOfBooks(title, book);
                System.out.println("BOOK RETURNED !!");
            }
        }
    }

    //-----------------------------Database Access-----------------------------------
    private void add(String title, String author, String isbn, String publication) {
        // TODO add method
        databaseFieldsArrayList.add(new DATABASE_FIELDS(title, author, isbn, publication, 1));
        System.out.println("ADDED\n");
    }

    private void increaseNumberOfBooks(String title, String author) {
        boolean added = false;
        for (DATABASE_FIELDS values : databaseFieldsArrayList) {
            if (values.getTitle().equalsIgnoreCase(title) && values.getAuthor().equalsIgnoreCase(author)) {
                int num = values.getNumOfBooks();
                values.setNumOfBooks(num + 1);
                System.out.println("ADDED\n");
                added = true;
            }
        }
        if (added == false){
            System.out.println("BOOK NOT FOUND");
        }
    }

    private void delete(String title, String author, String isbn, String publication) {
        boolean valid = false;
        // TODO add delete method
        for (DATABASE_FIELDS element : databaseFieldsArrayList) {
            System.out.println(element.getTitle() + " " + element.getAuthor() + " " + element.getNumOfBooks());
            if (element.getTitle().equalsIgnoreCase(title) && element.getAuthor().equalsIgnoreCase(author) &&
                    element.getISBN().equalsIgnoreCase(isbn) && element.getPublication().equalsIgnoreCase(publication) &&
                    (element.getNumOfBooks() > 0)) {
                System.out.println("DELETING BOOK\n");
                int num = element.getNumOfBooks();
                element.setNumOfBooks(num - 1);
                valid = true;
                break;

            } else if (element.getTitle().equalsIgnoreCase(title) && element.getAuthor().equalsIgnoreCase(author) && (element.getNumOfBooks() > 0)) {
                System.out.println("DELETING BOOK\n");
                int num = element.getNumOfBooks();
                element.setNumOfBooks(num - 1);
                valid = true;
                break;

            } else if (element.getTitle().equalsIgnoreCase(title) && element.getAuthor().equalsIgnoreCase(author) &&
                    element.getISBN().equalsIgnoreCase(isbn) && element.getPublication().equalsIgnoreCase(publication) &&
                    (element.getNumOfBooks() == 0)) {
                System.out.println("CANNOT DELETE BOOK !!!\n");
                valid = true;
                break;
            }
        }
        if (!valid){
            System.out.println("BOOK NOT FOUND TO BE DELETED !!");
        }
    }

    private void update(String title, String author, String isbn, String publication, String oldTitle) {
        // TODO add update method
        for (DATABASE_FIELDS values : databaseFieldsArrayList) {
            if (values.getTitle().equalsIgnoreCase(oldTitle)) {
                values.setTitle(title);
                values.setAuthor(author);
                values.setISBN(isbn);
                values.setPublication(publication);
            }
        }
    }

    private void display() {
        // TODO add display method

        if (databaseFieldsArrayList.isEmpty()) {
            System.out.println("NOTHING TO DISPLAY\n");
        }
        for (DATABASE_FIELDS values : databaseFieldsArrayList) {
            System.out.println("\nDISPLAYING BOOK");
            System.out.println(values.getTitle() + " " + values.getAuthor() + " " + values.getISBN()
                    + " " + values.getPublication() + " " + values.getNumOfBooks());
            System.out.println();
        }
    }

    private boolean search(String title, String author, int val) {
        if (val == 1) {
            for (DATABASE_FIELDS values : databaseFieldsArrayList) {
                if (values.getTitle().equalsIgnoreCase(title) && values.getAuthor().equalsIgnoreCase(author)) {
                    System.out.println("YAY!! BOOK RECORD FOUND\n");
                    if (values.getNumOfBooks() == 0) {
                        System.out.println("NO BOOKS LEFT\n");
                    }
                    return false;
                }
            }
        } else if (val == 2) {
            // TODO add search method
            System.out.println("SEARCHING BOOK");
            for (DATABASE_FIELDS values : databaseFieldsArrayList) {
                if (values.getTitle().equalsIgnoreCase(title) && values.getAuthor().equalsIgnoreCase(author) && (values.getNumOfBooks() > 0)) {
                    System.out.println("YAY!! BOOK FOUND\n");
                    return true;
                }
            }
        } else if (val == 3){
            System.out.println("SEARCHING BOOK");
            for (DATABASE_FIELDS values : databaseFieldsArrayList) {
                if (values.getTitle().equalsIgnoreCase(title) && values.getAuthor().equalsIgnoreCase(author)) {
                    System.out.println("YAY!! BOOK FOUND\n");
                    return true;
                }
            }
        }
        System.out.println("NO BOOK FOUND\n");
        return false;
    }

    private boolean search(String title, String author, String isbn, String publication) {
        // TODO add search method
        for (DATABASE_FIELDS values : databaseFieldsArrayList) {
            if (values.getTitle().equalsIgnoreCase(title) && values.getAuthor().equalsIgnoreCase(author) &&
                    values.getISBN().equalsIgnoreCase(isbn) && values.getPublication().equalsIgnoreCase(publication)) {
//                System.out.println("YAY!! BOOK FOUND");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Database obj = new Database();
    }


//--------------------------------BACKGROUND-------------------------------------
    public Database(String addingBooks){
        databaseFieldsArrayList.add(new DATABASE_FIELDS("Harry Potter", "JKR", "1", "1", 1));
        databaseFieldsArrayList.add(new DATABASE_FIELDS("RDPD", "Robert", "2", "2", 2));
        databaseFieldsArrayList.add(new DATABASE_FIELDS("Atomic Habits", "James Clear", "3", "3", 3));
        databaseFieldsArrayList.add(new DATABASE_FIELDS("Percy Jackson", "RR", "4", "4", 4));

    }

}