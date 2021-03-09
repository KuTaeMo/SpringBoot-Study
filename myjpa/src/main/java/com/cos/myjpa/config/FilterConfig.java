package com.cos.myjpa.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cos.myjpa.filter.MyAuthenticationFilter;

// web.xml

// 설정파일이니까 configuration -> 스캔 됨
@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean authenticationFilterAddRegister() {
		// 필터 객체 생성
		FilterRegistrationBean<MyAuthenticationFilter> bean =new FilterRegistrationBean<>(new MyAuthenticationFilter());
		
		bean.addUrlPatterns("/test");
		// 필터 순서(낮은 숫자 순으로 실행)
		bean.setOrder(0);
		
		// return 해서 IoC에 등록
		return bean;
	}
}
