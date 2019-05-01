package com.qf.distributionsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.qf.distributionsys.dao")
@EnableSwagger2
public class DistributionsysApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributionsysApplication.class, args);
	}

}
