import javax.management.NotificationBroadcasterSupport;
import java.util.List;
import java.util.ArrayList;

public class User {
    String name;
    String email;
    String password;
    List<Notification>  notifications;
    List<Friendship> friendships;

    int age;
    Gender gender;


    public void SetUser(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
        this.notifications = new ArrayList<>();
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
}
