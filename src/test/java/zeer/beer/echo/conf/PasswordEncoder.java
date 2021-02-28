package zeer.beer.echo.conf;

import beer.zeer.echo.conf.ContextConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

@SpringJUnitWebConfig(ContextConfig.class)
public class PasswordEncoder {
    @Autowired BCryptPasswordEncoder passwordEncoder;

    @Test public void genPassTest() {
        String s = "password";
        String encode = passwordEncoder.encode(s);
        assert passwordEncoder.matches(s, encode);
    }
}
