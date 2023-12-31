import java.util.ArrayList;
import java.util.List;

class IMDbDatabase {
    private List<User> users;
    private List<Movie> movies;
    private List<Person> people;


    public IMDbDatabase() {
        this.users = new ArrayList<>();
        this.movies = new ArrayList<>();
        this.people = new ArrayList<>();
    }

    // Methods for managing movies
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void editMovie(Movie movie) {
        // Implement logic to edit an existing movie
    }

    public void deleteMovie(Movie movie) {
        movies.remove(movie);
    }

    // Methods for managing people
    public void addPerson(Person person) {
        people.add(person);
    }

    public void editPerson(Person person) {
        // Implement logic to edit an existing person
    }

    public void deletePerson(Person person) {
        people.remove(person);
    }

    // Methods for managing users
    public void banUser(User user) {
        if (user != null) {
            // Check if the user is not already banned
            if (!user.isBanned()) {
                // Perform actions to ban the user
                user.setBanned(true);  // Set the user's banned status to true
                // Optionally, additional actions like revoking privileges, logging the ban, etc.
                System.out.println(user.getName() + " has been banned.");
            } else {
                // User is already banned
                System.out.println(user.getName() + " is already banned.");
            }
        } else {
            // Invalid user provided
            System.out.println("Invalid user.");
        }
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    // Methods for handling edit suggestions from editors
    public void reviewEditSuggestion(Editor editor, Movie movie, String editDetails) {
        // Implement logic to review and approve/reject edit suggestions
    }
}
