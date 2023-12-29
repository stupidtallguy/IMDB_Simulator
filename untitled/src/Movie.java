import java.util.ArrayList;
import java.util.List;

class Movie {
    String title;
    String plotSummary;
    String posterUrl;
    List<Review> reviews;
    List<Genre> genres;
    List<Person> cast;
    List<Person> directors;
    List<Person> writers;

    public Movie(String title, String plotSummary, String posterUrl) {
        this.title = title;
        this.plotSummary = plotSummary;
        this.posterUrl = posterUrl;
        this.reviews = new ArrayList<>();
        this.genres = new ArrayList<>();
        this.cast = new ArrayList<>();
        this.directors = new ArrayList<>();
        this.writers = new ArrayList<>();
        // Initialize other attributes and lists if needed
    }

    // Methods for managing reviews
    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        reviews.add(review);
        // Additional logic for handling reviews
    }

    // Methods for managing genres
    public List<Genre> getGenres() {
        return genres;
    }

    public void addGenre(Genre genre) {
        genres.add(genre);
        // Additional logic for handling genres
    }

    // Methods for managing cast and crew
    public List<Person> getCast() {
        return cast;
    }

    public void addActor(Person actor) {
        cast.add(actor);
        // Additional logic for handling actors
    }

    public List<Person> getDirectors() {
        return directors;
    }

    public void addDirector(Person director) {
        directors.add(director);
        // Additional logic for handling directors
    }

    public List<Person> getWriters() {
        return writers;
    }

    public void addWriter(Person writer) {
        writers.add(writer);
        // Additional logic for handling writers
    }

    // Additional methods for interacting with movies
}