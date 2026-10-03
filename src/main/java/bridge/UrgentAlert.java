package bridge;

public class UrgentAlert extends Notification {

    public UrgentAlert(String id, String message, Channel channel) {
        super(id, message, channel);
    }

    @Override
    public String execute() {
        return channel.send("URGENT: " + message);
    }
}