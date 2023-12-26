public class Review {
    User user;
    Movie movie;
    int rating;
    String text;

    public Review(User user, Movie movie, int rating, String text) {
        this.user = user;
        this.movie = movie;
        this.rating = rating;
        this.text = text;
        // Additional logic for initializing a review
    }

    // Methods for managing reviews
    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getRating() {
        return rating;
    }

    public String getText() {
        return text;
    }
}
