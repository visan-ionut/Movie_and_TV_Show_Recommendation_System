package processors;

import fileio.ResultOutput;
import fileio.UserInputData;

import java.util.List;

import static common.Constants.FAVORITE;
import static common.Constants.VIEW;
import static common.Constants.RATING;
import static common.Constants.ERROR_FAVORITE_NOTSEEN;
import static common.Constants.ERROR_FAVORITE_ALREADY;
import static common.Constants.ERROR_RATING_NOTSEEN;

public class UserProcessor {
    private static List<UserInputData> users;
    private static ResultOutput resultOutput;

    public UserProcessor(final List<UserInputData> users, final ResultOutput resultOutput) {
        this.users = users;
        this.resultOutput = resultOutput;
    }
    /** command to execute for FAVORITE */
    public static void addMovieToFavorite(final String user, final String movie) {
        for (UserInputData u : users) {
            if (u.getUsername().equals(user)) {
                if (u.getHistory().containsKey(movie)) {
                    if (u.getHistory().get(movie) >= 1) {
                        if (!u.getFavoriteMovies().contains(movie)) {
                            u.getFavoriteMovies().add(movie);
                            resultOutput.addLog(FAVORITE, movie, 0, u);
                        } else {
                            resultOutput.addLog(ERROR_FAVORITE_ALREADY, FAVORITE, movie, u);
                        }
                    }
                } else {
                    resultOutput.addLog(ERROR_FAVORITE_NOTSEEN, FAVORITE, movie, u);
                }
            }
        }
    }
    /** command to execute for VIEW */
    public static void addToHistory(final String user, final String title) {
        for (UserInputData u : users) {
            if (u.getUsername().equals(user)) {
                if (u.getHistory().containsKey(title)) {
                    u.getHistory().put(title, u.getHistory().get(title) + 1);
                    resultOutput.addLog(VIEW, title, 0, u);
                } else {
                    u.getHistory().put(title, 1);
                    resultOutput.addLog(VIEW, title, 0, u);
                }
            }
        }
    }
    /** command to execute for RATING */
    public static void addRating(final double rating, final String user, final String title) {
        for (UserInputData u : users) {
            if (u.getUsername().equals(user)) {
                if (u.getHistory().containsKey(title)) {
                    if (u.getHistory().get(title) >= 1) {
                        resultOutput.addLog(RATING, title, rating, u);
                    } else {
                        resultOutput.addLog(ERROR_RATING_NOTSEEN, RATING, title, u);
                    }
                }
            }
        }
    }
}
