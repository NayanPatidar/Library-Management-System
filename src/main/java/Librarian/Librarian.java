package Librarian;

import Database.Database;
import LibraryManagementSystem.UserData;

import java.util.ArrayList;
import java.util.Scanner;

public class Librarian {
    private static ArrayList<UserData> librarianArrayList;

    public Librarian(ArrayList<UserData> Librarian_username_pwdArrayList, String name){
        librarianArrayList = Librarian_username_pwdArrayList;
        verification(name);
    }

    private void verification(String name){
        int index = indexFinder(name);
        boolean valid = false;
        while (!valid) {
            Scanner scn = new Scanner(System.in);
            System.out.println("ENTER YOUR ID");
            String id = scn.nextLine();
            if (librarianArrayList.get(index).getID().equals(id)){
                System.out.println("Verified\n");
                valid = true;
            }
        }
        if (valid == true){
            librarianAccess();
        }
    }

//------------------------------------Main Librarian Class---------------------------------

    private void librarianAccess() {
        new Database();
    }


//------------------------------------ BACKGROUND ---------------------------------
private int indexFinder(String name) {
    for (int i = 0; i < librarianArrayList.size(); i++) {
        UserData val = librarianArrayList.get(i);
        if (val.getUsername().equalsIgnoreCase(name)) {
            return i; // Return the index when the username matches
        }
    }
    return -1; // Return -1 if the element is not found
}

    private void printData(){
        for (UserData values :librarianArrayList) {
//            System.out.println(bookSubArrayList.get(index).getPassword() + " " + bookSubArrayList.get(index).getUsername()
//                    + " " + bookSubArrayList.get(index).getID() + " " + bookSubArrayList.get(index).getBookName());

            System.out.println(values.getBookName() + " " + values.getID() + " " + values.getUsername() + " " + values.getPassword());
        }
    }
}
