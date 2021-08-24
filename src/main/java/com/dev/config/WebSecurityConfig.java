package com.dev.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.dev.jpa.usr.service.UsrService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
   
	@Autowired
	UsrService usrService;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests() /*인가 설정*/
       		.antMatchers("/admin/**", "/city/list").hasAuthority("ADMIN")
        	//.antMatchers("/admin/**", "/city/list").access("hasRole('USER')") 
            .antMatchers("/", "/usr/join", "/resources/**", "/docs/**", "/bbs/totallist").permitAll() //모든 권한 인가 허용
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/usr/login") //로그인 페이지 URL
            .defaultSuccessUrl("/usr/loginSuccess")
            .loginProcessingUrl("/usr/login")
            .usernameParameter("usrId")
            .passwordParameter("usrPw")
            .permitAll()
            .and()
        .logout()
        	.logoutUrl("/usr/logout")
        	.logoutSuccessUrl("/")
        	.invalidateHttpSession(true)
            .permitAll();
        
	}
	
    
    @Override
    /*
     * 인증 시 비밀번호 암호화 설정
     * 인가 권한 조회
     */
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //인증 시 비밀번호 암호화 설정
    	auth.userDetailsService(usrService).passwordEncoder(passwordEncoder());
    	
    	//auth.jdbcAuthentication().dataSource(dataSource);
		
    	//인가 권한 조회
		
//		  auth.jdbcAuthentication() .dataSource(dataSource)
//		  .usersByUsernameQuery("SELECT USR_ID as principal, USR_PW as password, TRUE FROM TB_USR WHERE USR_ID = ?"
//		  )
//		  .authoritiesByUsernameQuery("SELECT USR_ID as principal, ROLE_CD as ROLE FROM TB_USR_ROLE WHERE USR_ID = ?"
//		  );
		 
		 
        		
    }    
}
