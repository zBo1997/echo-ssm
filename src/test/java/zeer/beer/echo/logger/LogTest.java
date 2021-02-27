package zeer.beer.echo.logger;

import beer.zeer.echo.conf.LoggerConfig;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class LogTest {
    @Test public void logTest(){
        Logger logger = Logger.getLogger(LogTest.class.getName());
        logger.log(LoggerConfig.DEBUG,"DEBUG");
        logger.log(LoggerConfig.TEST,"TEST");
    }
}
