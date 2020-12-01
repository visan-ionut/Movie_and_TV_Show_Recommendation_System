package processors;

import common.Constants;
import fileio.Input;
import fileio.LogForCommand;
import fileio.ResultOutput;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/** class to execute and print all command we get */
public class MainProcessor {
    /** function to execute and print all command we get */
    public final void startProcessing(final Input input, final JSONArray arrayResult) {
        ResultOutput resultOutput = new ResultOutput();
        UserProcessor userProcessor = new UserProcessor(input.getUsers(), resultOutput);
        CommandProcessor.processorCommands(input.getCommands());
        for (LogForCommand log : resultOutput.getLogs()) {
            JSONObject object = new JSONObject();
            object.put(Constants.ID_STRING, log.getId());
            object.put(Constants.MESSAGE, log.getMessage());
            arrayResult.add(object);
        }
    }
}
