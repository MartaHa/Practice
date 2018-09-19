package comparable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Book implements Comparable<Book> {

    private String title;
    private String author;
    private int yearOfPublication;


    @Override
    public int compareTo(Book book) {
        return this.yearOfPublication - book.yearOfPublication;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public Book(String title, String author, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                '}';
    }
}

class Main {

    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("One", "Kowalski", 1999));
        books.add(new Book("Two", "Kowalski", 2001));
        books.add(new Book("Three", "Mickiewicz", 1945));
        books.add(new Book("Four", "Smith", 1912));
        books.add(new Book("Five", "Asnyk", 1911));


        Collections.sort(books);

        for (Book b : books) {
            System.out.println(b);

        }
    }
}

