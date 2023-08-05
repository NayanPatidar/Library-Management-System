package Database;

public class DATABASE_FIELDS {
    private String title;
    private String author;
    private String ISBN;
    private String Publication;
    private int numOfBooks;



    public int getNumOfBooks() {
        return numOfBooks;
    }

    public void setNumOfBooks(int numOfBooks) {
        this.numOfBooks = numOfBooks;
    }

    public String getPublication() {
        return Publication;
    }

    public void setPublication(String publication) {
        Publication = publication;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}