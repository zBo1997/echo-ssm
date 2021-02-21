package beer.zeer.conf;

import beer.zeer.mapper.KVPairMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.util.logging.Logger;

/**
 * TODO
 * */
public class MybatisConfig {

    public static void config() {
        // registry something
        c.addMapper(KVPairMapper.class);

        s = new SqlSessionFactoryBuilder().build(c);
    }

    public static SqlSession openSession() {
        return s.openSession();
    }

    private static Configuration c = null;
    private static SqlSessionFactory s = null;

    static Logger log = Logger.getLogger(new Object() {
    }.getClass().getEnclosingClass().getName());

    static {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("*******");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/k_v");
        dataSource.setDefaultAutoCommit(false);

        log.info(dataSource.toString() + ".setter [...] [null]: data source init completed");

        TransactionFactory transactionFactory = new JdbcTransactionFactory();

        c = new Configuration(new Environment("development", transactionFactory, dataSource));
    }
}
