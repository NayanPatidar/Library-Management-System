package LibraryManagementSystem;

import Librarian.Librarian;
import User.User;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagement {
    // ASKING USERTYPE

    // LOGIN OR REGISTER (LOGIN AND REGISTER FOR USER BUT LOGIN ONLY FOR LIBRARIAN)

    // ASKING USERNAME AND PASSWORD

//--------------------------------------------------------------------------------------
    private static final ArrayList<UserData> Users_username_pwdArrayList = new ArrayList<>();
    private static final ArrayList<UserData> Librarian_username_pwdArrayList = new ArrayList<>();

    private LibraryManagement(){
//        Users_username_pwdArrayList.add( new USERNAME_PWD("Nayan", "NOM", "Nayan@NOM"));
        Librarian_username_pwdArrayList.add(new UserData("Raj", "Kumar", "Raj@Kumar"));
//        for (USERNAME_PWD val : username_pwdArrayList){
//            System.out.println(val.getPassword() + " " + val.getUsername());
//        }
        userType();
    }

// ---------------------------------------------STARTING---------------------------------------------------
    public void userType() {
        // TODO add starting line
        Scanner scn = new Scanner(System.in);
        boolean Valid = false;
        while (!Valid){
        System.out.println("ENTER '1' IF YOU ARE USER AND '2' IF YOU ARE LIBRARIAN | '3' TO BREAK ");
        int input = scn.nextInt();

        if (input == 1){
            UserLoginOrRegister();

        } else if (input ==2) {
            login(2);
        }else if(input==3){
            Valid = true;
            break;
        }else {
            System.out.println("WRONG INPUT\n");
        }
        }
        scn.close();
    }

    private void UserLoginOrRegister() {
        Scanner scn = new Scanner(System.in);
        System.out.println("ENTER '1' IF YOU WANT TO LOGIN AND '2' IF YOU NEW USER");
        int input = scn.nextInt();
        if (input == 1){
            login(1);
        }
        else if(input == 2){
            registration();
        }

    }

    private void registration() {
        System.out.println("YOU ARE REGISTERING...");
        Scanner scn = new Scanner(System.in);
        System.out.println("ENTER YOUR NAME");
        String name = scn.nextLine();
        System.out.println("ENTER YOUR PASSWORD");
        String pwd = scn.nextLine();
        System.out.println("YOUR ID IS name@id");
        String id = name+"@"+pwd;

        if (search(name, pwd) == false) {
            Users_username_pwdArrayList.add(new UserData(name, pwd, id, 0));
            System.out.println("YOUR NAME IS " + name + " AND YOUR PASSWORD IS " + pwd);
            login(1);
            // TODO Call user
        }else if (search(name,pwd) == true){
            System.out.println("ALREADY PRESENT !!");
            System.out.println("MOVING YOU TO LOGIN PAGE...");
            login(1);
        }
    }


    private void login(int i) {
        Scanner scn = new Scanner(System.in);

        // 1 FOR LOGGING IN USER
        if (i == 1){
            boolean valid = false;
            boolean found = false;
                while (!valid){
                     System.out.println("ENTER YOUR NAME");
                     String name = scn.nextLine();
                     System.out.println("ENTER YOUR PASSWORD");
                     String pwd = scn.nextLine();

                  for (UserData values : Users_username_pwdArrayList){
                    if (values.getUsername().equalsIgnoreCase(name) && values.getPassword().equalsIgnoreCase(pwd)){
                         System.out.println("\nWELCOME");
                         System.out.println(i);
                         // TODO CALL User;
                         new User(Users_username_pwdArrayList, name);
                         valid = true;
                         found = true;
                         System.out.println("OUT OF LOGIN");

                    }
                  }
                    if (!found){
                        System.out.println("USER NOT FOUND\n");
                        userNotFound();
                        System.out.println("OUT OF USER NOT FOUND");
                        valid = true;
                    }
//                    break;
                }
//      2 FOR LOGGING IN LIBRARIAN
        }else if (i == 2) {
            boolean valid = false;
            boolean found = false;
            while (!valid){
                System.out.println("ENTER YOUR NAME");
                String name = scn.nextLine();
                System.out.println("ENTER YOUR PASSWORD");
                String pwd = scn.nextLine();

                for (UserData values : Librarian_username_pwdArrayList){
                    if (values.getUsername().equalsIgnoreCase(name) && values.getPassword().equalsIgnoreCase(pwd)){
                        System.out.println("WELCOME");
                        System.out.println(i);
                        new Librarian(Librarian_username_pwdArrayList, name);
                        valid = true;
                        found = true;
                        break;
                    }
                }
                if (!found){
                    System.out.println("LIBRARIAN NOT FOUND");

                }
            }
        }
    }
    public static void main(String[] args) {
        LibraryManagement obj = new LibraryManagement();
    }

//---------------------------------------------BACKGROUND METHODS----------------------------------------------------------------

    private boolean search(String name, String pwd) {
        for (UserData val : Users_username_pwdArrayList){
            if (val.getUsername().equalsIgnoreCase(name) && val.getPassword().equalsIgnoreCase(pwd)){
                return true;
            }
        }
        return false;
    }

    private void userNotFound(){
        Scanner scn = new Scanner(System.in);
        boolean valid = false;
        System.out.println("ENTER '1' TO RE-ENTER THE DETAILS | '2' TO ENTER MAIN PAGE| '3' TO EXIT");
        int input = scn.nextInt();

        while (!valid) {
            if (input == 2) {
                UserLoginOrRegister();
                valid = true;
            } else if (input == 3) {
                valid = true;
            } else if (input == 1) {
                login(1);
                valid = true;
            } else{
                System.out.println("WRONG INPUT!!!\n");
            }
        }
    }
}