import java.util.ArrayList;
import java.util.List;

public class Friendship {
    List<User> users;

    public Friendship(List<User> users) {
        this.users = users;
        // Additional logic for initializing friendship
    }

    // Methods for managing friendships
    public List<User> getFriends() {
        return users;
    }

    public boolean areFriends(List<User> usersToCheck) {
        return this.users.containsAll(usersToCheck) && usersToCheck.containsAll(this.users);
    }

    public void removeFriend(User friendToRemove) {
        users.remove(friendToRemove);
        // Additional logic for handling friend removal
    }

}
