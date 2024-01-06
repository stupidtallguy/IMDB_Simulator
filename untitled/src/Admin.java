public class Admin extends User{
    IMDbDatabase database;
    private final String AdminUsername = "admin";
    private final String AdminPassword = "admin";
    private final String AdminEmail = "Admin123@gmail.com";
    private final int AdminBirthYear = 2004 ;


    public Admin(String name, String email, String password, int BirthYear, Gender gender, UserRole role) {
        super(name, email, password, BirthYear, gender, role);
    }


    public void changePassword(String newPassword) {
        if (this.getName().equals("admin") && this.getPassword().equals("admin")) {
            // Only allow changing the password if the current credentials are 'admin'
            this.ResetPassword(newPassword);
        } else {
            System.out.println("Permission denied. Only admin can change the password.");
        }
    }
    public void addMovie(Movie movie) {
        database.addMovie(movie);
    }
    public void editMovie(Movie movie) {
        database.editMovie(movie);
    }

    public void deleteMovie(Movie movie) {
        database.deleteMovie(movie);
    }

    // Methods for managing people
    public void addPerson(Person person) {
        database.addPerson(person);
    }

    public void editPerson(Person person) {
        database.editPerson(person);
    }

    public void deletePerson(Person person) {
        database.deletePerson(person);
    }
    public void AddUser(String name, String email, String password, int BirthYear,Gender gender ,UserRole role){
        SetUser(name , email , password, BirthYear,gender,role);
    }
    // Methods for managing users
    public void banUser(User user) {
        database.banUser(user);
    }

    public void deleteUser(User user) {
        database.deleteUser(user);
    }

    // Methods for handling edit suggestions from editors
    public void reviewEditSuggestion(Editor editor, Movie movie, String editDetails) {
        database.reviewEditSuggestion(editor, movie, editDetails);
    }
}
