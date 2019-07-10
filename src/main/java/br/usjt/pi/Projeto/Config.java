package br.usjt.pi.Projeto;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.usjt.pi.Projeto.controller.LoginInterceptor;

@Configuration
public class Config implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//registry.addInterceptor(new LoginInterceptor()). 
		//addPathPatterns("/**").    
		//excludePathPatterns("/login", "/", "/fazerLogin","/vendor/**","/fonts/**","/css/**","/images/**");
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("C:\\Users\\Joe\\Downloads\\Projeto\\**")
	            .addResourceLocations("C:\\Users\\Joe\\Downloads\\Projeto\\");
	}
	
	
}
