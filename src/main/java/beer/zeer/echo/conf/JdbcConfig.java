package beer.zeer.echo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

@Configuration
@EnableJdbcRepositories("beer.zeer.echo")
public class JdbcConfig {
    @Bean public DataSource dataSource() throws IOException {
        Properties properties = new Properties();
        InputStream in = JdbcConfig.class.getClassLoader().getResourceAsStream("database-jdbc.properties");
        properties.load(in);
        DriverManagerDataSource dataSource = new DriverManagerDataSource(properties.getProperty("url"),
                properties.getProperty("username"), properties.getProperty("password"));
        dataSource.setDriverClassName(properties.getProperty("driver-class-name"));
        logger.log(LoggerConfig.DEBUG, String.format("[load data source ok] [url:%s u:%s p:%s d:%s] \n", dataSource.getUrl(),
                dataSource.getUsername(), dataSource.getPassword(), properties.getProperty("driver-class-name")));
        return dataSource;
    }

    @Bean NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean TransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    Logger logger = Logger.getLogger(this.getClass().getName());
}
