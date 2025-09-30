import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MovieTheatre {

    public static void main(String[] args) {

        System.out.println("--- Movie Genres (Set) ---");
        Set<String> genres = new HashSet<>();
        genres.add("Action");
        genres.add("Comedy");
        genres.add("Drama");
        genres.add("Comedy"); 

        for (String genre : genres) {
            System.out.println("Genre: " + genre);
        }

        System.out.println("\n--- Movie Catalog (Map) ---");
        Map<Integer, Movie> movieCatalog = new HashMap<>();
        movieCatalog.put(01, new Movie("Kill", "Action", 148));
        movieCatalog.put(02, new Movie("De Dana Dan", "Comedy", 100));
        movieCatalog.put(03, new Movie("Saiyaara", "Drama", 117));

        for (Map.Entry<Integer, Movie> entry : movieCatalog.entrySet()) {
            System.out.println("Movie ID: " + entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\n--- Ticket Bookings (List) ---");
        List<Ticket> bookings = new ArrayList<>();
        bookings.add(new Ticket("Alice", movieCatalog.get(01), "2025-10-01 18:00"));
        bookings.add(new Ticket("Bob", movieCatalog.get(02), "2025-10-01 20:00"));
        bookings.add(new Ticket("John", movieCatalog.get(03), "2025-10-02 14:00")); 

        for (Ticket ticket : bookings) {
            System.out.println(ticket);
        }

        System.out.println("\nDetails of Movie ID 503:");
        System.out.println(movieCatalog.get(03));
    }
}
class Movie {
    String title;
    String genre;
    int duration; 

    public Movie(String title, String genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return title + "\" (" + genre + ", " + duration + " min)";
    }
}

class Ticket {
    String customerName;
    Movie movie;
    String showTime;

    public Ticket(String customerName, Movie movie, String showTime) {
        this.customerName = customerName;
        this.movie = movie;
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return customerName + " booked \"" + movie.title + "\" for " + showTime;
    }
}
