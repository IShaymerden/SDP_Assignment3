package bridge;

public class SmsChannel implements Channel {

    @Override
    public String send(String message) {
        return "SMS: " + message;
    }
}
