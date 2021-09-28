package br.edu.infnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VenturaWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(VenturaWebApplication.class, args);
    }

}
