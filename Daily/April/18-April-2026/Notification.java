class NotificationRunner {
    public static void main(String[] args) {

        Notification email = new EmailNotification("alam12@google.com");
        Notification sms = new SMSNotification("9876543210");
        Notification push = new PushNotification("UserDevice123");

        email.showRecipient();
        email.sendMessage("Welcome to mail services");
        System.out.println();

        sms.showRecipient();
        sms.sendMessage("Your validity has expired!");
        System.out.println();

        push.showRecipient();
        push.sendMessage("This is a test notification");
        System.out.println();
    }
}

abstract class Notification {
    protected String recipient;

    public Notification(String recipient) {
        this.recipient = recipient;
    }

    abstract void sendMessage(String message);

    public void showRecipient() {
        System.out.println("Recipient: " + recipient);
    }
}

class EmailNotification extends Notification {

    public EmailNotification(String recipient) {
        super(recipient);
    }

    void sendMessage(String message) {
        System.out.println("Sending Email to " + recipient + ": " + message);
    }
}

class SMSNotification extends Notification {

    public SMSNotification(String recipient) {
        super(recipient);
    }

    void sendMessage(String message) {
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }
}

class PushNotification extends Notification {

    public PushNotification(String recipient) {
        super(recipient);
    }

    void sendMessage(String message) {
        System.out.println("Sending Push Notification to " + recipient + ": " + message);
    }
}
