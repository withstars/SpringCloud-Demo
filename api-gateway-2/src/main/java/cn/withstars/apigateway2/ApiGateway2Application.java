package cn.withstars.apigateway2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ApiGateway2Application {

	@Bean
	@RefreshScope // 将zuul的配置内容动态化
	@ConfigurationProperties("zuul")
	public ZuulProperties zuulProperties(){
		return new ZuulProperties();
	}



	public static void main(String[] args) {
		SpringApplication.run(ApiGateway2Application.class, args);
	}
}
