package fileio;

import java.util.ArrayList;
import java.util.List;

import static common.Constants.FAVORITE;
import static common.Constants.VIEW;
import static common.Constants.RATING;
import static common.Constants.ERROR_FAVORITE_NOTSEEN;
import static common.Constants.ERROR_FAVORITE_ALREADY;
import static common.Constants.ERROR_RATING_NOTSEEN;


public class ResultOutput {
    private int id;
    private List<LogForCommand> logs;

    public ResultOutput() {
        this.id = 0;
        this.logs = new ArrayList<>();
    }

    /** function to print the message */
    public final void addLog(final String command, final String movie,
                       final double rating, final UserInputData user) {
        id++;
        switch (command) {
            case FAVORITE:
                logs.add(new LogForCommand(id, "success -> " + movie + " was added as favourite"));
                break;
            case VIEW:
                logs.add(
                        new LogForCommand(id,
                                "success -> "
                                        + movie
                                        + " was viewed with total views of "
                                        + user.getHistory().get(movie)));
                break;
            case RATING:
                logs.add(
                        new LogForCommand(id,
                                "success -> "
                                        + movie
                                        + " was rated with "
                                        + rating
                                        + " by " + user.getUsername()));
                break;
            default:
                break;
        }
    }

    /** function to print the message */
    public final void addLog(final int error, final String command,
                             final String movie, final UserInputData user) {
        id++;
        switch (error) {
            case ERROR_FAVORITE_NOTSEEN:
                logs.add(new LogForCommand(id, "error -> " + movie + " is not seen"));
                break;
            case ERROR_FAVORITE_ALREADY:
                logs.add(new LogForCommand(id, "error -> "
                        + movie + " is already in favourite list"));
                break;
            case ERROR_RATING_NOTSEEN:
                logs.add(new LogForCommand(id, "error -> " + movie + " is not seen"));
                break;
            default:
                break;
        }
    }

    public final List<LogForCommand> getLogs() {
        return logs;
    }
}
