package br.com.bb.jayloja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class JayLojaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JayLojaApplication.class, args);
	}

}
