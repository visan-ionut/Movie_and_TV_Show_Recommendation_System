package fileio;

public class LogForCommand {
    private int id;
    private String message;

    public LogForCommand(final int id, final String message) {
        this.id = id;
        this.message = message;
    }

    public final int getId() {
        return id;
    }

    public final String getMessage() {
        return message;
    }
}
