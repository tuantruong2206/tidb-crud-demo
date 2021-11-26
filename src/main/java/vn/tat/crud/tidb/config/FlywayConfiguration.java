package vn.tat.crud.tidb.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Tuan.Truong Brian
 * @version 1.0
 * Class INFO
 * @date 11/23/21 11:38
 */
@Configuration
public class FlywayConfiguration {
    @Autowired
    public FlywayConfiguration(DataSource dataSource) {
        Flyway flyway = Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).outOfOrder(true).load();
        flyway.repair();
        flyway.migrate();
    }
}
