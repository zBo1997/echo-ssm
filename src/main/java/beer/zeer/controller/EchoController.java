package beer.zeer.controller;

import beer.zeer.conf.MybatisConfig;
import beer.zeer.entity.KVPair;
import beer.zeer.mapper.KVPairMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class EchoController {
    @Autowired
    KVPair kv;

    @GetMapping("/ping")
    public String echo() {
        log.info("EchoController.echo [null] [pong]: /ping rsp");
        return "pong";
    }

    @GetMapping("/ping/ioc")
    public String echoIOC() {
        String rsp = kv.getVal();
        log.info("EchoController.echoIOC [null] [" + rsp + "]: /ping/ioc rsp");
        return rsp;
    }

    @GetMapping("/ping/db")
    public String echoDB() {
        SqlSession sqlSession = MybatisConfig.openSession();
        KVPairMapper mapper = sqlSession.getMapper(KVPairMapper.class);
        String rsp = mapper.echo("ping");
        log.info("EchoController.echoDB [null] [" + rsp + "]: /ping/db rsp");
        return rsp;
    }

    Logger log = Logger.getLogger(this.getClass().getName());
}
