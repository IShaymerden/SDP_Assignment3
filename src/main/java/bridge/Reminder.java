package bridge;

public class Reminder extends Notification {

    public Reminder(String id, String message, Channel channel) {
        super(id, message, channel);
    }

    @Override
    public String execute() {
        return channel.send(message);
    }
}
