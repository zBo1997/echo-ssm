package beer.zeer.conf;

import java.util.logging.Level;

public class LoggerConfig {
    public static final DebugLevel DEBUG = new DebugLevel("DEBUG", 850);

    static class DebugLevel extends Level {

        protected DebugLevel(String name, int value) {
            super(name, value);
        }
    }
}
