package Account;

import Database.Database;
import LibraryManagementSystem.UserData;
import User.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Accounts {
    private static ArrayList<UserData> accountArrayList;

    public Accounts(ArrayList<UserData> userSubArrayList, int index) {
        accountArrayList = userSubArrayList;

        mainAccount(index);

        new User(accountArrayList);
    }

//----------------------------------------MAIN ACCOUNT---------------------------------

    public void mainAccount(int index){
        boolean valid = false;
        while (!valid){
            System.out.println("NO. OF BORROWED BOOKS:" + accountArrayList.get(index).getBorrowedBooks());
            System.out.println("NO. OF RESERVED BOOKS:" + accountArrayList.get(index).getReservedBooks());
            System.out.println("NO. OF RETURNED BOOKS:" + accountArrayList.get(index).getReturnedBooks());
            System.out.println("NO. OF LOST BOOKS:" + accountArrayList.get(index).getLostBooks());
            if (accountArrayList.get(index).getFineAmount() > 0){
                System.out.println("FINE AMOUNT:" + accountArrayList.get(index).getFineAmount());
            }
            System.out.println();
            valid = true;

            if (accountArrayList.get(index).getNumOfBooks() > 0) {
                bookActions(index);
            }
        }
    }

    private void bookActions(int index) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;

        while (!valid){
        System.out.println("ENTER '1' TO RETURN A BOOK | '2' IF YOU LOST A BOOK | '3' TO EXIT");
        int input = scanner.nextInt();

            if (input == 1) {
                bookReturn(index);
                valid = true;
            } else if (input == 2) {
                if (accountArrayList.get(index).getNumOfBooks() > 0)  {
                    lostBook(index);
                    valid = true;
                }else {
                    System.out.println("NO HAVE NO BOOK !!");
                }
            } else if (input == 3) {
                valid = true;
            }
        }
    }

    private void bookReturn(int index) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;

        while (!valid) {
            System.out.println("ENTER TITLE:");
            String title = scanner.nextLine();
            System.out.println("ENTER AUTHOR:");
            String author = scanner.nextLine();

            if (accountArrayList.get(index).getBookName().equalsIgnoreCase(title) && accountArrayList.get(index).getAuthorName().equalsIgnoreCase(author)) {
                Database objOne = new Database(title, author, "1", 1);

                if (objOne.BookPresentOrNot) {
                    Database objTwo = new Database(title, author, "2", 2);

                    setFineAndBook(index);

                    valid = true;

                }
            }

        }
    }

    private void lostBook(int index) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;

        while (!valid){
            System.out.println("TO CONFIRM IF YOU LOST: " + accountArrayList.get(index).getBookName().toUpperCase(Locale.ROOT)
             + "  ENTER '1' | TO EXIT '2' ");
            int input = scanner.nextInt();

            if (input == 1){
                int lostBooks = accountArrayList.get(index).getLostBooks();
                accountArrayList.get(index).setLostBooks(lostBooks + 1);

                long fineAmount = accountArrayList.get(index).getFineAmount();
                accountArrayList.get(index).setFineAmount(750 + fineAmount);

                accountArrayList.get(index).setNumOfBooks(0);

                valid = true;
            } else if (input == 2) {
                valid = true;
            } else {
                System.out.println("WRONG INPUT \n");
            }
        }
    }

    private void setFineAndBook(int index) {
        LocalDate dateToday = LocalDate.now();
        LocalDate dueDate = accountArrayList.get(index).getBookDate();

        if (dateToday.isAfter(dueDate)){
            long difference = ChronoUnit.DAYS.between(dateToday, accountArrayList.get(index).getBookDate());

            long fineAmount = accountArrayList.get(index).getFineAmount();
            accountArrayList.get(index).setFineAmount(fineAmount + (difference*5));

            System.out.println("FINE AMOUNT FOR EXTRA DAYS: " + difference*5);
        }

        int returnedBooks = accountArrayList.get(index).getReturnedBooks();
        accountArrayList.get(index).setReturnedBooks(returnedBooks + 1);

        accountArrayList.get(index).setNumOfBooks(0);
    }
}