package vn.shop.SPRestService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"vn.shop.SPRestService",
"vn.shop.SPRestService.api"})
public class ShopeeRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopeeRestServiceApplication.class, args);
	}

}

