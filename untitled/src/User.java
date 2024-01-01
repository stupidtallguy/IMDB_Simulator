import javax.management.NotificationBroadcasterSupport;
import java.util.List;
import java.util.ArrayList;

public class User {
    private String name;
    private String email;
    private String password;
    private boolean isBanned;
    UserRole role;
    List<Notification>  notifications;
    private List<Friendship> friendships;

    int birthYear;
    Gender gender;


    public void SetUser(String name, String email, String password ,int BirthYear, UserRole role){
        this.name = name;
        this.birthYear = BirthYear;
        this.email = email;
        this.password = password;
        this.notifications = new ArrayList<>();
        this.friendships = new ArrayList<>();
        setRole(role);
    }
    public void UpdateProfile(String NewName, String NewPassword, String NewEmail, int NewBirthYear){
        this.name = NewName;
        this.birthYear = NewBirthYear;
        this.password = NewPassword;
        this.email = NewEmail;
    }
    public String getName(){
        return this.name;
    }
    public String getPassword(){

        return this.password;
    }
    private void setRole(UserRole role) {
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

    public void setBanned(boolean banned) {
        this.isBanned = banned;
    }

    // Getter method for the banned status
    public boolean isBanned() {
        return isBanned;
    }
    public void Banned(){
        if(isBanned){
            
        }
    }
}