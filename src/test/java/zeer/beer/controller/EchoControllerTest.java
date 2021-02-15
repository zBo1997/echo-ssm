package zeer.beer.controller;

import beer.zeer.conf.ContextConfig;
import beer.zeer.entity.KVPair;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.logging.Logger;

@SpringJUnitConfig(ContextConfig.class)
@WebAppConfiguration
public class EchoControllerTest {
    @Autowired
    KVPair kv;

    @Test
    void testIOC() {
        log.info("IOC test [ctx] [" + kv.getVal() + "]");
    }

    Logger log = Logger.getLogger(this.getClass().getName());

}
