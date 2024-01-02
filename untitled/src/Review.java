import java.util.Date;
public class Review {
    private Member reviewer;
    private Movie movie;
    private int rating; // Rating out of 10 or 5
    private String text; // Review text
    private boolean spoiler; // Indicates if the review contains spoilers
    private int helpfulVotes; // Number of helpful votes
    private int notHelpfulVotes; // Number of not helpful votes
    private Date timestamp;

    public Review(Member reviewer, Movie movie, int rating, String text, boolean spoiler) {
        this.reviewer = reviewer;
        this.movie = movie;
        this.rating = rating;
        this.text = text;
        this.spoiler = spoiler;
        this.helpfulVotes = 0;
        this.notHelpfulVotes = 0;
        this.timestamp = new Date(); // Set the current date and time
    }
    // Getter methods

    public Member getReviewer() {
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

    public boolean hasSpoiler() {
        return spoiler;
    }

    public int getHelpfulVotes() {
        return helpfulVotes;
    }

    public int getNotHelpfulVotes() {
        return notHelpfulVotes;
    }

    public Date getTimestamp() {
        return timestamp;
    }
    // Methods for user interactions

    public void markAsSpoiler() {
        spoiler = true;
    }

    public void markReviewAsHelpful() {
        helpfulVotes++;
    }

    public void markReviewAsNotHelpful() {
        notHelpfulVotes++;
    }
}
