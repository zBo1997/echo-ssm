package zeer.beer.echo.controller;

import beer.zeer.echo.conf.ContextConfig;
import beer.zeer.echo.entity.KVPair;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.util.logging.Logger;

@SpringJUnitWebConfig(ContextConfig.class)
public class EchoControllerTest { }
