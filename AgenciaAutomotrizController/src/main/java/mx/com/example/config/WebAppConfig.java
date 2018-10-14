package mx.com.example.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "mx.com.example")
public class WebAppConfig {
	
	@Bean
	@Autowired
	public MappingJackson2HttpMessageConverter jacksonMessageConverter() {
		return new MappingJackson2HttpMessageConverter();
	}
		
	@Bean
	public RequestMappingHandlerAdapter RequestMappingHandlerAdapter() {
		RequestMappingHandlerAdapter request = new RequestMappingHandlerAdapter();
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		messageConverters.add(jacksonMessageConverter());
		
		request.setMessageConverters(messageConverters);
		
		return request;
	}
}
