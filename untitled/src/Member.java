import java.util.ArrayList;
import java.util.List;

class Member extends User {
    List<Movie> watchlist;
    List<Movie> favorites;
    List<Movie> classicsToSee;

    public Member(String name, String email, String password , int BirthYear, UserRole role) {
        SetUser(name, email, password ,birthYear,UserRole.MEMBER );
        this.watchlist = new ArrayList<>();
        this.favorites = new ArrayList<>();
        this.classicsToSee = new ArrayList<>();
        // Additional initialization for Member
    }

    public void rateMovie(Movie movie, int rating) {
        Review review = new Review(this, movie, rating, "");
        movie.reviews.add(review);
        // Additional logic for rating a movie
    }

    public void addToList(List<Movie> list, Movie movie) {
        list.add(movie);
        // Additional logic for adding a movie to a list
    }

    public void addToWatchlist(Movie movie) {
        addToList(watchlist, movie);
    }

    public void addToFavorites(Movie movie) {
        addToList(favorites, movie);
    }

    public void addToClassicsToSee(Movie movie) {
        addToList(classicsToSee, movie);
    }

    public List<Movie> getWatchlist() {
        return watchlist;
    }

    public List<Movie> getFavorites() {
        return favorites;
    }

    public List<Movie> getClassicsToSee() {
        return classicsToSee;
    }

    public void submitReview(Movie movie, int rating, String text) {
        Review review = new Review(this, movie, rating, text);
        movie.reviews.add(review);
        // Additional logic for submitting a review
    }

    // Additional methods for interacting with movies
}
