import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class   Movie {
    String title;
    String plotSummary;
    String posterUrl;
    List<Review> reviews;
    List<Genre> genres;
    List<Person> fullcast;
    List<Person> directors;
    List<Person> writers;
    List<Person> Actors;
    LocalDate releaseDate;
    String Trivia;

    public Movie(String title, String plotSummary, String posterUrl) {
        this.title = title;
        this.plotSummary = plotSummary;
        this.posterUrl = posterUrl;
        this.reviews = new ArrayList<>();
        this.genres = new ArrayList<>();
        this.fullcast = new ArrayList<>();
        this.directors = new ArrayList<>();
        this.writers = new ArrayList<>();
        this.Actors = new ArrayList<>();
        // Initialize other attributes and lists if needed
    }

    // Methods for managing reviews
    public List<Review> getReviews() {
        return reviews;
    }
    public String getTitle(){
        return this.title;
    }
    public void SetTitle(String title){
        this.title = title;
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
        return Actors;
    }

    public void addActor(Person actor) {
        Actors.add(actor);
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

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setTrivia(String newTrivia) {
        this.Trivia = newTrivia;
    }

    public void setFullCast(List<Person> fullCast) {
        this.fullcast = fullCast;
    }

    // Additional methods for interacting with movies
}