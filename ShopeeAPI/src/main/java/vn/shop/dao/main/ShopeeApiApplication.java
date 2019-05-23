package vn.shop.dao.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import vn.shop.dao.util.FileStorageProperties;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "vn.shop.dao"})
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class ShopeeApiApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(ShopeeApiApplication.class, args);
//	}
	public static void main(String[] args) {
		SpringApplication.run(ShopeeApiApplication.class, args);
	}
}
