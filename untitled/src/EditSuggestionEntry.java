public class EditSuggestionEntry {
    private Editor editor;
    private String suggestionDetails;

    public EditSuggestionEntry(Editor editor, String suggestionDetails) {
        this.editor = editor;
        this.suggestionDetails = suggestionDetails;
    }

    public Editor getEditor() {
        return editor;
    }

    public String getSuggestionDetails() {
        return suggestionDetails;
    }
}
