import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    GeoLoc Location;
    String bio;
    List<Role> roles;

    public Person(String name, String bio) {
        this.name = name;
        this.bio = bio;
        this.roles = new ArrayList<>();
    }

    // Methods for managing roles
    public List<Role> getRoles() {
        return roles;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public void removeRole(Role role) {
        roles.remove(role);
    }

    // Methods for managing biography
    public String getBio() {
        return bio;
    }

    public void updateBio(String newBio) {
        this.bio = newBio;

    }
}
