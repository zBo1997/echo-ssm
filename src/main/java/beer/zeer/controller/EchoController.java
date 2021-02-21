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
        logger.info(String.format("[%s] [%s] [%s] \n", "/ping", "pong", "ok"));
        return "pong";
    }

    @GetMapping("/ping/ioc")
    public String echoIOC() {
        String rsp = kv.getVal();
        logger.info(String.format("[%s] [%s] [%s] \n", "/ping/ioc", rsp, "ok"));
        return rsp;
    }

    @GetMapping("/ping/db")
    public String echoDB() {
        SqlSession sqlSession = MybatisConfig.openSession();
        KVPairMapper mapper = sqlSession.getMapper(KVPairMapper.class);
        String rsp = mapper.echo("ping");
        logger.info(String.format("[%s] [%s] [%s] \n", "/ping/db", rsp, "ok"));
        return rsp;
    }

    @GetMapping("/security/ping")
    public String echoSecurity() {
        logger.info(String.format("[%s] [%s] [%s] \n", "/security/ping", "pong", "ok"));
        return "pong";
    }

    Logger logger = Logger.getLogger(this.getClass().getName());
}
