package Account;


import LibraryManagementSystem.UserData;

import java.util.ArrayList;
import java.util.Scanner;

public class Accounts {
    private int index;
    private static ArrayList<UserData> accountArrayList;

    public Accounts(ArrayList<UserData> userSubArrayList, int index) {
        accountArrayList = userSubArrayList;
        this.index = index;
    }

//----------------------------------------MAIN ACCOUNT---------------------------------

    public void mainAccount(){
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        while (!valid){
            System.out.println("NO. OF BORROWED BOOKS:");
            System.out.println("NO. OF RESERVED BOOKS:");
            System.out.println("NO. OF RETURNED BOOKS:");
            System.out.println("NO. OF LOST BOOKS:");
            System.out.println("FINE AMOUNT:");
            valid = true;
        }
    }
}