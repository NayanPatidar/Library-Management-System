package Book;

import LibraryManagementSystem.USERNAME_PWD;
import User.User;

import java.util.ArrayList;

public class Books {
    private static ArrayList<USERNAME_PWD> bookSubArrayList;

    public Books(ArrayList<USERNAME_PWD> userSubArrayList, int index) {
        bookSubArrayList = userSubArrayList;

        if (index == 0) {
            bookSubArrayList.get(index).setBookName("Harry Potter");
            System.out.println("MADE CHANGES");
        }

            System.out.println(bookSubArrayList.get(index).getPassword() + " " + bookSubArrayList.get(index).getUsername()
                    + " " + bookSubArrayList.get(index).getID() + " " + bookSubArrayList.get(index).getBookName());

        new User(bookSubArrayList);
    }


}