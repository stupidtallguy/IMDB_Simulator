import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Editor extends User {
    private List<Movie> suggestedEdits;

    public Editor(String name, String email, String password ,int BirthYear, Gender gender) {
        super(name, email, password,BirthYear, gender, UserRole.EDITOR);
        this.suggestedEdits = new ArrayList<>();
    }

    // Method for suggesting edits to movie details
    public void suggestEdit(Movie movie, String editDetails) {
        if (movie != null && editDetails != null && !editDetails.isEmpty()) {
            // Validate the editDetails, perform necessary checks, and then apply the suggestion
            applyEdit(movie, editDetails);
            System.out.println("Edit suggestion for " + movie.getTitle() + " added successfully.");
        } else {
            System.out.println("Invalid suggestion. Movie or edit details are null or empty.");
        }
    }
    private void applyEdit(Movie movie, String editDetails) {
        // Apply the edit details to the movie (e.g., update the database)
        // This is where you would perform the actual modification to the movie data
        System.out.println("Applying edit details: " + editDetails + " to movie " + movie.getTitle());
    }

    // Method for flagging inappropriate content for admin review
    public void flagInappropriateContent(Movie movie) {
        if (movie != null) {
            // Logic for flagging inappropriate content
            System.out.println("Content in " + movie.getTitle() + " flagged for review.");
        } else {
            System.out.println("Invalid request. Movie is null.");
        }
    }

    // Method for viewing suggested edits (can be used by Admin for approval)
    public List<Movie> viewSuggestedEdits() {
        return suggestedEdits;
    }

    // Method for editing trivia for a movie
    public void editTrivia(Movie movie, String newTrivia) {
        if (movie != null && newTrivia != null && !newTrivia.isEmpty()) {
            // Logic for editing trivia
            movie.setTrivia(newTrivia);
            System.out.println("Trivia for " + movie.getTitle() + " updated successfully.");
        } else {
            System.out.println("Invalid edit. Movie or trivia is null or empty.");
        }
    }

    // Method for adding missing data like release dates
    public void addMissingData(Movie movie, LocalDate releaseDate, List<Person> fullCast) {
        if (movie != null && releaseDate != null && fullCast != null && !fullCast.isEmpty()) {
            // Logic for adding missing data
            movie.setReleaseDate(releaseDate);
            movie.setFullCast(fullCast);
            System.out.println("Missing data for " + movie.getTitle() + " added successfully.");
        } else {
            System.out.println("Invalid data. Movie, release date, or full cast is null or empty.");
        }
    }
}
