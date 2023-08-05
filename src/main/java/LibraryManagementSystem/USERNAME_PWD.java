package LibraryManagementSystem;

public class USERNAME_PWD {
    private String username;
    private String password;
    private String bookName;
    private String ID;

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



    public USERNAME_PWD(String username, String password, String id){
        this.username = username;
        this.password = password;
        this.ID = id;
    }

    public USERNAME_PWD(String bookName){
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