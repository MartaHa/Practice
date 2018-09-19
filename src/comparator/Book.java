package comparator;

public class Book {

    private String title;
    private String author;
    private int yearOfPublication;
    private int rating;


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public int getRating() {
        return rating;
    }

    public Book(String title, String author, int yearOfPublication, int rating) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", rating=" + rating +
                '}';
    }
}
