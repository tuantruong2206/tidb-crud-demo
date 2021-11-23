package vn.tat.crud.tidb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {/*"com.nab.icommerce.base.*", */"vn.tat.crud.tidb.*"})
@SpringBootApplication
public class TidbCrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TidbCrudDemoApplication.class, args);
	}

}
