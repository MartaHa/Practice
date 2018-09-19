package comparator;

import java.util.Comparator;

public class RatingCompare implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        if (o1.getRating() < o2.getRating() ){
            return -1;
        }else if (o1.getRating() > o2.getRating()){
            return 1;
        }
        return 0;
    }
}
