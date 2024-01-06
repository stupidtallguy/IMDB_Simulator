public class Notification {
    private String message;
    private boolean isRead;

    public Notification(String message) {
        this.message = message;
        this.isRead = false; // A new notification is initially unread
    }

    public String getMessage() {
        return message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "message='" + message + '\'' +
                ", isRead=" + isRead +
                '}';
    }
}
