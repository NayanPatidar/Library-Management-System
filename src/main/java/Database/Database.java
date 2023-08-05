package Database;

import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    private static ArrayList<DATABASE_FIELDS> databaseFieldsArrayList;

    public Database() {
        // TODO For Librarian Access
    }

//    public Database(String Name, String Author) {
//
//    }
//
//    public Database(String Name, String Author) {
//
//    }

//--------------------------Main Librarian Access-------------------------------

    private void librarianAccess(){
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        while (!valid){
            System.out.println("ENTER '1' TO ADD BOOK, '2' TO DELETE BOOK, '3' TO UPDATE BOOK" +
                    ", '4' DISPLAY, '5' SEARCH | '6' TO EXIT");
            int input = scanner.nextInt();
            if (input == 1){
                // TODO add book
                FuncAssigner(1);
            } else if (input == 2) {
                // TODO delete book
            } else if (input == 3) {
                // TODO update book
            } else if (input == 4) {
                // TODO display
            } else if (input == 5){
                // TODO search
            } else if (input == 6) {
                valid = true;
                break;
            }
        }
    }

    private void FuncAssigner(int i) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER TITLE");
        String title = scanner.nextLine();
        System.out.println("ENTER AUTHOR");
        String author = scanner.nextLine();
        System.out.println("ENTER ISBN");
        String isbn = scanner.nextLine();
        System.out.println("ENTER PUBLICATION");
        String publication = scanner.nextLine();

        if (i == 1){
            // TODO add book
            search(title, author, isbn, publication);
            add(title, author, isbn, publication);
        } else if (i == 2) {
            // TODO delete book
            delete(title, author, isbn, publication);
        } else if (i == 3) {
            // TODO update book
            search(title, author, isbn, publication);
            update(title, author, isbn, publication);
        } else if (i == 4) {
            // TODO display
            display();
        } else if (i == 5){
            // TODO search
            search(title, author);
        }
    }


//-----------------------------Book Access---------------------------------------

//-----------------------------Account Access------------------------------------

//-----------------------------Database Access-----------------------------------
    private void add(String title, String author, String isbn, String publication) {
        // TODO add method
    }

    private void delete(String title, String author, String isbn, String publication) {
        // TODO add delete method
    }

    private void update(String title, String author, String isbn, String publication) {
        // TODO add update method
    }

    private void display() {
        // TODO add display method
    }

    private boolean search(String title, String author) {
        // TODO add search method
        for (DATABASE_FIELDS values : databaseFieldsArrayList){
            if (values.getTitle().equalsIgnoreCase(title) && values.getAuthor().equalsIgnoreCase(author)){
                System.out.println("YAY!! BOOK FOUND");
                return true;
            }
        }
        return false;
    }

    private boolean search(String title, String author, String isbn, String publication) {
        // TODO add search method
        for (DATABASE_FIELDS values : databaseFieldsArrayList){
            if (values.getTitle().equalsIgnoreCase(title) && values.getAuthor().equalsIgnoreCase(author) &&
                values.getISBN().equalsIgnoreCase(isbn) && values.getPublication().equalsIgnoreCase(publication)){
                System.out.println("YAY!! BOOK FOUND");
                return true;
            }
        }
        return false;
    }
}


//--------------------------------BACKGROUND-------------------------------------
