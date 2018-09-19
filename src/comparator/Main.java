package comparator;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList <Book> books = new ArrayList<>();

        books.add(new Book("One", "Kowalski", 1999,8));
        books.add(new Book("Two", "Kowalski", 2001,5));
        books.add(new Book("Three", "Mickiewicz", 1945,2));
        books.add(new Book("Four", "Smith", 1912,1));
        books.add(new Book("Five", "Asnyk", 1911,200));

        // sort by rating

        RatingCompare compare =new RatingCompare();
        Collections.sort(books, compare);

        System.out.println("Books sorted by rating:");
        for (Book b: books){
            System.out.println(b);
        }

        // sort by title

        TitleCompare compareTitle =new TitleCompare();
        Collections.sort(books, compareTitle);

        System.out.println("Books sorted by title:");
        for (Book b: books){
            System.out.println(b);
        }



    }
}
