import java.util.ArrayList;
import java.util.List;

public class EditSuggestion {
    private List<EditSuggestionEntry> suggestions;

    public EditSuggestion() {
        this.suggestions = new ArrayList<>();
    }

    public void addEditSuggestion(EditSuggestionEntry suggestion) {
        suggestions.add(suggestion);
    }

    public List<EditSuggestionEntry> getEditSuggestions() {
        return suggestions;
    }

}