package User;

import Account.Accounts;
import Book.Books;
import LibraryManagementSystem.UserData;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private static ArrayList<UserData> userSubArrayList;
    private String name;

    public User(ArrayList<UserData> usersUsernamePwdArrayList, String name) {
        userSubArrayList = usersUsernamePwdArrayList;
        this.name = name;
        System.out.println("YOU ARE IN USER CLASS !!\n");
                for (UserData val : userSubArrayList){
            System.out.println(val.getPassword() + " " + val.getUsername() + " " + val.getID());
        }
        verifyUser();
    }

    public User(ArrayList<UserData> book_accountSubArrayList) {
        userSubArrayList = book_accountSubArrayList;
    }

    private void verifyUser() {
        int index = indexFinder(name);
        boolean valid = false;
        while (!valid) {
            Scanner scn = new Scanner(System.in);
            System.out.println("ENTER YOUR ID");
            String id = scn.nextLine();
            if (userSubArrayList.get(index).getID().equals(id)){
                System.out.println("Verified\n");
                valid = true;
            }
        }
        if (valid == true){
            userAccess(index);
        }
    }
//-------------------------------------------MAIN USER CLASS---------------------------------------------------

    private void userAccess(int index){
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        while (!valid){
            System.out.println("ENTER '1' TO CHECK ACCOUNT, '2' TO GET BOOK INFORMATION | '3' TO EXIT");
            int input = scanner.nextInt();

            if (input == 1){
                // TODO add check-account
                new Accounts(userSubArrayList, index);
            }else if (input == 2){
                // TODO add get book info
                new Books(userSubArrayList, index);
//                printData();
            }else if (input == 3){
                System.out.println("EXITING");
                valid = true;
            }

        }

    }









//-------------------------------------------- BACKGROUND -----------------------------------------------------
    private int indexFinder(String name) {
         for (int i = 0; i < userSubArrayList.size(); i++) {
             UserData val = userSubArrayList.get(i);
                  if (val.getUsername().equalsIgnoreCase(name)) {
                      return i; // Return the index when the username matches
                  }
         }
         return -1; // Return -1 if the element is not found
    }

    private void printData(){
        for (UserData values :userSubArrayList) {
//            System.out.println(bookSubArrayList.get(index).getPassword() + " " + bookSubArrayList.get(index).getUsername()
//                    + " " + bookSubArrayList.get(index).getID() + " " + bookSubArrayList.get(index).getBookName());

        System.out.println(values.getBookName() + " " + values.getID() + " " + values.getUsername() + " " + values.getPassword());
        }
    }
}