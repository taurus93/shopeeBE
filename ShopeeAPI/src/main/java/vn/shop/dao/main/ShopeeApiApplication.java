package vn.shop.dao.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "vn.shop.dao"})
public class ShopeeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopeeApiApplication.class, args);
	}
}
