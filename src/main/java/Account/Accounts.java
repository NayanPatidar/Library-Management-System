package Account;


import LibraryManagementSystem.USERNAME_PWD;

import java.lang.foreign.VaList;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Accounts {
    private int index;
    private static ArrayList<USERNAME_PWD> accountArrayList;

    public Accounts(ArrayList<USERNAME_PWD> userSubArrayList, int index) {
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