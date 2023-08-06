package Book;

import Database.Database;
import LibraryManagementSystem.UserData;
import User.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Books {
    private static ArrayList<UserData> bookSubArrayList;

    public Books(ArrayList<UserData> userSubArrayList, int index) {
        bookSubArrayList = userSubArrayList;

//        if (index == 0) {
//            bookSubArrayList.get(index).setBookName("Harry Potter");
//            System.out.println("MADE CHANGES");
//        }
//
//        for (USERNAME_PWD values :bookSubArrayList) {
////            System.out.println(bookSubArrayList.get(index).getPassword() + " " + bookSubArrayList.get(index).getUsername()
////                    + " " + bookSubArrayList.get(index).getID() + " " + bookSubArrayList.get(index).getBookName());
//
//            System.out.println(values.getBookName() + " " + values.getID() + " " + values.getUsername() + " " + values.getPassword());
//        }
        BooksAccess(index);

        new User(bookSubArrayList);
    }

//-----------------------------------------------------Main Book Access-----------------------------------------------------
        private void BooksAccess(int index) {
            Scanner scanner = new Scanner(System.in);
            boolean valid = false;

            while (!valid){
                System.out.println("ENTER '1' TO REQUEST BOOK, '2' TO SHOW_DUE-DATE, '3' TO RENEW BOOK | '4' TO EXIT");
                int input = scanner.nextInt();

                if (input == 1){
                    // TODO
                    if (validNumOfRequest(index)) {
                        CheckBook(index);
                    }else {
                        System.out.println("YOU CANNOT MAKE MORE THAN ONE REQUEST !!! \n");
                    }
                }else if (input == 2){
                    // TODO
                    show_dueDate(index);
                }else if (input == 3){
                    // TODO
                    renew_book(index);
                }else if (input == 4){
                    valid = true;
                }
            }

        }

//-----------------------------------------------------Main Book Classes-----------------------------------------------------


    private void CheckBook(int index) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;


        while (!valid){
            boolean nameFound = false;
            System.out.println("ENTER TITLE");
            String title = scanner.nextLine();
            System.out.println("ENTER AUTHOR");
            String author = scanner.nextLine();
            Database obj = new Database(title, author, 1);
            if (obj.BookPresentOrNot){
                boolean requestNum = false;

                while (!requestNum){
                System.out.println("BOOK HAS BEEN FOUND. SHOULD WE REQUEST IT FOR YOU!! \n" +
                                    " '1' FOR YES | '2' FOR NO");
                int input = scanner.nextInt();
                     if (input == 1) {
                         requestBook(title, author, index);
                         valid = true;
                         nameFound = true;
                         requestNum = true;
                    } else if (input == 2) {
                         valid = true;
                         nameFound = true;
                         requestNum = true;
                     }else {
                         System.out.println("WRONG INPUT\n");
                     }
                }
            }
            if (!nameFound){
                BookNotFound(index);
                System.out.println("OUT OF CHECK BOOK");
                valid = true;
            }
        }
    }

    private void requestBook(String title, String author, int index) {
        new Database(title, author, 2);
        System.out.println("BOOK HAS BEEN REQUESTED !! \n");

        // Setting numOfBooks to 1 for own reference
        bookSubArrayList.get(index).setNumOfBooks(1);

        // Increasing borrowed books
        int borrowedBooks = bookSubArrayList.get(index).getBorrowedBooks();
        bookSubArrayList.get(index).setBorrowedBooks(borrowedBooks+1);

        // Setting title
        bookSubArrayList.get(index).setBookName(title);

        // Setting author
        bookSubArrayList.get(index).setAuthorName(author);

        // adding due date
        LocalDate currentDate = LocalDate.now();
        bookSubArrayList.get(index).setBookDate(currentDate.plusDays(7));
    }

    private void show_dueDate(int index) {
        if (bookSubArrayList.get(index).getNumOfBooks() > 0) {
            System.out.println(bookSubArrayList.get(index).getBookDate());
            System.out.println();
        }else if (bookSubArrayList.get(index).getNumOfBooks() == 0){
            System.out.println("YOU HAVE NO BOOKS ASSIGNED !\n");
        }
    }

    private void renew_book(int index) {
        LocalDate currentDate = LocalDate.now();

        if (bookSubArrayList.get(index).getNumOfBooks() > 0) {

            if (currentDate.equals(bookSubArrayList.get(index).getBookDate())) {
                System.out.println("RENEWING BOOK");
                LocalDate DueBookDate = bookSubArrayList.get(index).getBookDate();
                bookSubArrayList.get(index).setBookDate(DueBookDate.plusDays(7));
            }
            else if (!currentDate.equals(bookSubArrayList.get(index).getBookDate())) {
                System.out.println("BOOK CAN ONLY BE RENEWED ON: " + bookSubArrayList.get(index).getBookDate() + "\n");
            }
        }
        else if (bookSubArrayList.get(index).getNumOfBooks() == 0){
            System.out.println("YOU HAVE NO BOOKS ASSIGNED !\n");
        }
    }



//-----------------------------------------------------BACKGROUND-----------------------------------------------------

    private void BookNotFound(int index){
        Scanner scn = new Scanner(System.in);
        boolean valid = false;

        while (!valid) {

            System.out.println("ENTER '1' TO RE-ENTER THE DETAILS | '2' TO EXIT");
            int input = scn.nextInt();
            if (input == 1) {
                CheckBook(index);
                valid = true;
            } else if (input == 2) {
                valid = true;
            } else{
                System.out.println("WRONG INPUT!!!\n");
            }
        }
    }

    private boolean validNumOfRequest(int index){
        return bookSubArrayList.get(index).getNumOfBooks() == 0;
    }
}