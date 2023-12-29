import java.util.ArrayList;
import java.util.List;

public class Friendship {
    private List<User> users;

    public Friendship(User user1, User user2) {
        this.users = new ArrayList<>();
        this.users.add(user1);
        this.users.add(user2);

    }

    // Methods for managing friendships
    public List<User> getFriends() {
        return new ArrayList<>(users);  // Return a copy to maintain encapsulation
    }

    public boolean areFriends(List<User> usersToCheck) {
        // Check for null and ensure the sets are equal
        return usersToCheck != null && new ArrayList<>(this.users).equals(new ArrayList<>(usersToCheck));
    }

    public void removeFriend(User friendToRemove) {
        if (users.contains(friendToRemove)) {
            users.remove(friendToRemove);
            System.out.println(friendToRemove.getName() + " has been removed from your friends.");
        } else {
            System.out.println(friendToRemove.getName() + " is not in your friends list.");
        }
    }
}
