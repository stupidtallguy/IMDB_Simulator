import javax.management.NotificationBroadcasterSupport;
import java.util.List;
import java.util.ArrayList;

public class User {
    private String name;
    private String email;
    private String password;
    private boolean isBanned = false;
    UserRole role;
    List<Notification>  notifications;
    private List<Friendship> friendships;

    int birthYear;
    Gender gender;

    public User(String name, String email, String password ,int BirthYear,Gender gender, UserRole role){
        this.name = name;
        this.birthYear = BirthYear;
        this.email = email;
        this.password = password;
        this.notifications = new ArrayList<>();
        this.friendships = new ArrayList<>();
        setRole(role);
        setGender(gender);
    }
    public void SetUser(String name, String email, String password ,int BirthYear,Gender gender, UserRole role){
        this.name = name;
        this.birthYear = BirthYear;
        this.email = email;
        this.password = password;
        this.notifications = new ArrayList<>();
        this.friendships = new ArrayList<>();
        setRole(role);
        setGender(gender);
    }
    public void UpdateProfile(String NewName, String NewEmail, int NewBirthYear){
        this.name = NewName;
        this.birthYear = NewBirthYear;
        this.email = NewEmail;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String Email){
        this.email = Email;
    }
    public void setBirthYear(int Year){
        this.birthYear = Year;
    }
    public void setPassword(String Pass){
        this.password = Pass;
    }
    public String getPassword(){

        return this.password;
    }
    private void setRole(UserRole role) {
        this.role = role;
    }
    private void setGender(Gender gender) {this.gender = gender;}
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

    public void setBanned(User user) {
        this.isBanned = true;
    }

    // Getter method for the banned status
    public boolean isBanned() {
        return isBanned;
    }

}