package beer.zeer.echo.controller;

import beer.zeer.echo.dao.KVPairDao;
import beer.zeer.echo.entity.KVPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController public class EchoController {
    @Autowired KVPairDao kvPairDao;

    @GetMapping("/ping") public String echo() {
        return "pong";
    }

    @GetMapping("/ping/db") public String echoDB() {
        return kvPairDao.findById("ping").orElse(new KVPair()).getVal();
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/security")public String echoSecurity() {
        return "pong";
    }
}
