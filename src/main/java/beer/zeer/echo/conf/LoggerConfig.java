package beer.zeer.echo.conf;

import java.util.logging.Level;

public class LoggerConfig {
    public static final CustomLevel DEBUG = new CustomLevel("DEBUG", 850);
    public static final CustomLevel TEST = new CustomLevel("TEST", 850);

    static class CustomLevel extends Level {
        protected CustomLevel(String name, int value) {
            super(name, value);
        }
    }
}
