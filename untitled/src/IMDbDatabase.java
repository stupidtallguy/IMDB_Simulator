import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

class IMDbDatabase {
    private List<Member> Members;
    private HashMap<String,Editor> Editors;
    private Admin admin;
    private List<Movie> movies;
    private List<Person> people;


    public IMDbDatabase() {
        this.Members = new ArrayList<>();
        this.Editors = new HashMap<>();
        this.movies = new ArrayList<>();
        this.people = new ArrayList<>();
    }
    public void addMember(Member member){
        Members.add(member);
    }
    public void addUser(User newUser){
        if(newUser.role == UserRole.MEMBER ){
            addMember((Member)(newUser));
        }
        if(newUser.role == UserRole.EDITOR){
            Editors.put(newUser.getName(),(Editor)newUser);
        }
    }
    public Member memberSignIn(String name, String password) {
        for (Member member : Members) {
            if (member.getName().equals(name) && member.getPassword().equals(password)) {
                return member; // Return the matched member
            }
        }
        return null; // Return null if no matching member is found
    }
    public Editor editorSignIn(String name, String password) {
        Editor editor = Editors.get(name);

        if (editor != null && editor.getPassword().equals(password)) {
            return editor; // Return the matched editor
        }
        return null; // Return null if no matching editor or incorrect password is found
    }

    public Admin getAdmin() {
        return admin;
    }

    // Methods for managing movies
    public void addMovie(Movie movie) {
        movies.add(movie);
    }
    public List<Movie> getMovies(){
        return movies;
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
                user.setBanned(user);  // Set the user's banned status to true
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
    public Person getPersonByName(String Name){
        for(Person Person : people){
            if(Person.name.equalsIgnoreCase(Name)){
                return Person;
            }
        }
        return null;
    }
    public void deleteUser(User user) {
        Members.remove(user);
    }

    // Methods for handling edit suggestions from editors
    public void reviewEditSuggestion(Editor editor, Movie movie, String editDetails) {
        // Implement logic to review and approve/reject edit suggestions
    }

    public Movie getMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie; // Return the matched movie
            }
        }
        return null; // Return null if no matching movie is found
    }

    public User getUserByName(String userToBan) {
        for(Member member: Members){
            if(member.getName().equals(userToBan)){
                return member;
            }
        }
        return null;
    }
}
