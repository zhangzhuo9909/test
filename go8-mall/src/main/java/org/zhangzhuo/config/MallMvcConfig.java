package org.zhangzhuo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.zhangzhuo.interceptor.LogInterceptor;

@Configuration
public class MallMvcConfig extends WebMvcConfigurationSupport {
	@Bean
	public LogInterceptor getLoginInterceptor() {
		return new LogInterceptor();
	}
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(this.getLoginInterceptor())
			.addPathPatterns("/order.html","/pay.html","/member.html","/cart/list","/cart/sync");
		super.addInterceptors(registry);
	}
	
	//放行静态资源
	@Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
