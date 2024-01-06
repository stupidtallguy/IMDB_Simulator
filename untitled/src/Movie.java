import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class   Movie {
    private String title;
    private String plotSummary;
    private String posterUrl;
    List<Review> reviews;
    List<Genre> genres;
    List<Person> fullcast;
    List<Person> directors;
    List<Person> writers;
    List<Person> Actors;
    LocalDate releaseDate;
    List<String> Trivia;
    boolean InappropriateContent = false;
    private List<EditSuggestionEntry> editSuggestions;

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
        this.editSuggestions = new ArrayList<>();

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
    }

    // Methods for managing genres
    public List<Genre> getGenres() {
        return genres;
    }

    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    // Methods for managing cast and crew
    public List<Person> getCast() {
        return Actors;
    }

    public void addActor(Person actor) {
        Actors.add(actor);
    }

    public List<Person> getDirectors() {
        return directors;
    }

    public void addDirector(Person director) {
        directors.add(director);
    }

    public List<Person> getWriters() {
        return writers;
    }

    public List<EditSuggestionEntry> getEditSuggestions() {
        return editSuggestions;
    }
    public void addWriter(Person writer) {
        writers.add(writer);
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setPlotSummary(String PlotSummery){
        this.plotSummary = plotSummary;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setTrivia(String newTrivia) {
        this.Trivia.add(newTrivia);
    }

    public void setFullCast(List<Person> fullCast) {
        this.fullcast = fullCast;
    }
    public void applyEdits(List<EditSuggestionEntry> approvedSuggestions) {
        for (EditSuggestionEntry suggestion : approvedSuggestions) {
            Editor editor = suggestion.getEditor();
            String editDetails = suggestion.getSuggestionDetails();

            if (containsNewPlotSummary(editDetails)) {
                updatePlotSummary(editDetails);
            }

            if (containsTrivia(editDetails)) {
                addTrivia(editDetails);
            }



            if (containsReleaseDate(editDetails)) {
                updateReleaseDate(editDetails);
            }


        }

        // Clear the edit suggestions after applying edits
        clearEditSuggestions();
    }

    private void addTrivia(String editDetails) {
        this.Trivia.add(editDetails);
    }


    private boolean containsTrivia(String editDetails) {
        return this.Trivia.contains(editDetails);
    }


    private void updatePlotSummary(String editDetails) {
        this.plotSummary = editDetails;
    }


    private boolean containsNewPlotSummary(String editDetails) {
        return this.plotSummary.equals(editDetails);
    }


    private boolean containsReleaseDate(String editDetails) {
        return editDetails.contains("Release Date:");
    }

    private void updateReleaseDate(String editDetails) {

        String releaseDateMarker = "Release Date:";
        int markerIndex = editDetails.indexOf(releaseDateMarker);
        if (markerIndex != -1) {

            String newReleaseDate = editDetails.substring(markerIndex + releaseDateMarker.length()).trim();
            this.releaseDate = LocalDate.parse(newReleaseDate);
        }
    }

    public void clearEditSuggestions() {
        editSuggestions.clear();
    }

    public void suggestEdit(Editor editor, String editDetails) {
        EditSuggestionEntry editSuggestion = new EditSuggestionEntry(editor, editDetails);
        this.editSuggestions.add(editSuggestion);
    }

    public void flagInappropriateContent(Editor editor) {
        this.InappropriateContent = true;
    }
}