import javax.management.NotificationBroadcasterSupport;
import java.util.List;
import java.util.ArrayList;

public class User {
    private String name;
    private String email;
    private String password;
    List<Notification>  notifications;
    private List<Friendship> friendships;

    int age;
    Gender gender;


    public void SetUser(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
        this.notifications = new ArrayList<>();
        this.friendships = new ArrayList<>();
    }
    public void UpdateProfile(String NewName, String NewPassword, String NewEmail){
        this.name = NewName;
        this.password = NewPassword;
        this.email = NewEmail;
    }
    public void ResetPassword(String NewPassword){
        this.password = NewPassword;
    }
    public void SendNotification(Notification notification){
        notifications.add(notification);
    }
    public List<Notification> getNotifications(){
        return notifications;
    }
    public void AddFriend(User friend){
        List<User> friendsList = new ArrayList<>();
        friendsList.add(this);      // Adding the current user
        friendsList.add(friend);    // Adding the friend

        Friendship newFriendship = new Friendship(friendsList);
        friendships.add(newFriendship);
    }
}
