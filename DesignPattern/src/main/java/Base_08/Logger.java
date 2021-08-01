package Base_08;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class Logger {
    private String name;
    private boolean enabled;
    private Level minPermittedLevel;

    public Logger(String name, boolean enabled, Level minPermittedLevel) {
        this.name = name;
        this.enabled = enabled;
        this.minPermittedLevel = minPermittedLevel;
    }

    protected boolean isLoggable() {
        boolean loggable = enabled && (minPermittedLevel.intValue() <= minPermittedLevel.intValue());
        return loggable;
    }

}

class FileLogger extends Logger {
    private Writer fileWriter;

    public FileLogger(String name, boolean enabled, Level minPermittedLevel, String filePath) {
        super(name, enabled, minPermittedLevel);
    }

    public void log(Level level, String message) {
        if (!isLoggable()) {
            return;
        }
        try {
            fileWriter.write("...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
class MessageQueueLogger extends Logger {
    public MessageQueueLogger(String name, boolean enabled, Level minPermittedLevel,MessageQueueClient msgQueueClient) {
        super(name, enabled, minPermittedLevel);
    }
}
*/
