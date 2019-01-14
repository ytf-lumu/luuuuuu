package com.nico.nicoweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class NicowebApplication {
	@Bean // 自动扫描
	 //这个注解的意思是在启动时先加载注册中心的域名列表
	public RestTemplate restTemplate() //这个方法用来发http请求
	{
		RestTemplate restTemplate=new RestTemplate();
		return restTemplate;
	}
	public static void main(String[] args) {
		SpringApplication.run(NicowebApplication.class, args);
	}

}

