package LibraryManagementSystem;

import java.time.LocalDate;

public class UserData {
    private String username;
    private String password;
    private String bookName;
    private String ID;
    private int numOfBooks;
    private LocalDate BookDate;

    public LocalDate getBookDate() {
        return BookDate;
    }

    public void setBookDate(LocalDate bookDate) {
        BookDate = bookDate;
    }

    public UserData(String username, String password, String id) {
        this.username = username;
        this.password = password;
        this.ID = id;
    }

    public int getNumOfBooks() {
        return numOfBooks;
    }

    public void setNumOfBooks(int numOfBooks) {
        this.numOfBooks = numOfBooks;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }



    public UserData(String username, String password, String id, int numOfBooks){
        this.username = username;
        this.password = password;
        this.ID = id;
        this.numOfBooks = numOfBooks;
    }

    public UserData(String bookName){
        this.bookName = bookName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
}