
import java.util.ArrayList;

class BookRunner {
    public static void main(String[] args) {
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        book.addReview(new Review(10, "Great read!", 5));
        book.addReview(new Review(11, "Enjoyed it", 4));
        
        System.out.println(book);
    }
}
class Book {
    private int id;
    private String name;
    private String author;
    private ArrayList<Review> reviews= new ArrayList<>();

    public Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
    public void addReview(Review review) {
        reviews.add(review);
    }
    public String toString() {
        return String.format("id-%d , name-%s , author-%s , reviews-%s", id, name, author, reviews);
    }
}
class Review {
    private int id;
    private String description;
    private int rating;

    public Review(int id, String description, int rating) {
        this.id = id;
        this.description = description;
        this.rating = rating;
    }
    public String toString() {
        return String.format("id-%d , description-%s , rating-%d", id, description, rating);
    }
}