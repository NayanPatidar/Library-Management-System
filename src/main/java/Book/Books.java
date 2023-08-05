package Book;

import Account.Accounts;
import LibraryManagementSystem.USERNAME_PWD;
import User.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Books {
    private static ArrayList<USERNAME_PWD> bookSubArrayList;

    public Books(ArrayList<USERNAME_PWD> userSubArrayList, int index) {
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
//                    requestBook();
                }else if (input == 2){
                    // TODO
//                    show_due-date();
                }else if (input == 3){
                    // TODO
//                    renew_book();
                }else if (input == 4){
                    valid = true;
                }
            }

        }

}