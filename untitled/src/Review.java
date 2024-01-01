import java.util.Date;
public class Review {
    private Member reviewer;
    private Movie movie;
    private int rating; // Rating out of 10 or 5
    private String text; // Review text
    private Date timestamp;

    public Review(Member reviewer, Movie movie, int rating, String text) {
        this.reviewer = reviewer;
        this.movie = movie;
        this.rating = rating;
        this.text = text;
    }

    // Methods for managing reviews
    public Member getViewer() {
        return reviewer;
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
