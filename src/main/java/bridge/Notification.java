package bridge;

public abstract class Notification {

    private final String id;
    protected final String message;
    protected Channel channel;

    public Notification(String id, String message, Channel channel) {
        this.id = id;
        this.message = message;
        this.channel = channel;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setImplementation(Channel channel) {
        this.channel = channel;
    }

    public abstract String execute();
}