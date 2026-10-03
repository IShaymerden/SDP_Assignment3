package bridge;

public class EmailChannel implements Channel {

    @Override
    public String send(String message) {
        return "EMAIL envelope: " + message;
    }
}
