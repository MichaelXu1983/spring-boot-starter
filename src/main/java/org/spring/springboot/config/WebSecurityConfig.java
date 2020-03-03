package org.spring.springboot.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MyUserDetailsService muds;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest()// .permitAll();
				.authenticated()// 其他的路径都是登录后即可访问
				.and().formLogin() // 默认请求拦截
				// .loginPage("http://www.lsswp.com/#/user/login") // 自定义请求拦截地址
				.successHandler(new AuthenticationSuccessHandler() {
					@Override
					public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
							HttpServletResponse httpServletResponse, Authentication authentication)
							throws IOException, ServletException {
						httpServletResponse.setContentType("application/json;charset=utf-8");
						PrintWriter out = httpServletResponse.getWriter();
						out.write("{\"status\":\"ok\",\"msg\":\"登录成功\"}");
						out.flush();
						out.close();
					}
				}).failureHandler(new AuthenticationFailureHandler() {

					@Override
					public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
							org.springframework.security.core.AuthenticationException exception)
							throws IOException, ServletException {
						// TODO Auto-generated method stub
						response.setContentType("application/json;charset=utf-8");
						PrintWriter out = response.getWriter();
						out.write("{\"status\":\"error\",\"msg\":\"登录失败\"}");
						out.flush();
						out.close();
					}
				}).loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password").permitAll()
				.and().logout().permitAll().and().csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(muds);// 添加自定义的userDetailsService认证
	}

}
