package LibraryManagementSystem;

import java.time.LocalDate;

public class UserData {
    private String username;
    private String password;
    private String bookName;
    private String ID;
    private int numOfBooks;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    private LocalDate BookDate;
    private int borrowedBooks;
    private int reservedBooks;
    private String authorName;

    public long getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(long fineAmount) {
        this.fineAmount = fineAmount;
    }

    public int getLostBooks() {
        return lostBooks;
    }

    public void setLostBooks(int lostBooks) {
        this.lostBooks = lostBooks;
    }

    public int getReturnedBooks() {
        return returnedBooks;
    }

    public void setReturnedBooks(int returnedBooks) {
        this.returnedBooks = returnedBooks;
    }

    public int getReservedBooks() {
        return reservedBooks;
    }

    public void setReservedBooks(int reservedBooks) {
        this.reservedBooks = reservedBooks;
    }

    public int getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(int borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    private int returnedBooks;
    private int lostBooks;
    private long fineAmount;

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