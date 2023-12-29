import javax.management.NotificationBroadcasterSupport;
import java.util.List;
import java.util.ArrayList;

public class User {
    private String name;
    private String email;
    private String password;
    UserRole role;
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
    public String getName(){
        return this.name;
    }
    public String getPassword(){
        return this.password;
    }
    public void setRole(UserRole role) {
        this.role = role;
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
    public void addFriend(User friend) {
        Friendship newFriendship = new Friendship(this, friend);
        friendships.add(newFriendship);
    }

}
