package processors;

import fileio.ActionInputData;

import java.util.List;

import static common.Constants.*;

/** class to process all comands and execute them */
public class CommandProcessor {
    /** function to process all comands and execute them */
    public static void processorCommands(final List<ActionInputData> commands) {
        for (ActionInputData command : commands) {
            switch (command.getActionType()) {
                case COMMAND:
                    switch (command.getType()) {
                        case FAVORITE:
                            executeCommandFavorite(command);
                            break;
                        case VIEW:
                            executeCommandView(command);
                            break;
                        case RATING:
                            executeCommandRating(command);
                            break;
                        default:
                            break;
                    }
                    break;
                case QUERY:
                    break;
                case RECOMMENDATION:
                    break;
                default:
                    break;
            }
        }
    }

    private static void executeCommandFavorite(final ActionInputData command) {
        UserProcessor.addMovieToFavorite(command.getUsername(), command.getTitle());
    }

    private static void executeCommandView(final ActionInputData command) {
        UserProcessor.addToHistory(command.getUsername(), command.getTitle());
    }

    private static void executeCommandRating(final ActionInputData command) {
        UserProcessor.addRating(command.getGrade(), command.getUsername(), command.getTitle());
    }
}
