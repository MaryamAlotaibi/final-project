package com.example.demoproject.config;

import com.example.demoproject.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetailsService myUserDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/register").permitAll()
                .antMatchers("/api/v1/customer").permitAll()
                .antMatchers("/api/v1/user/{id}").permitAll()
                .antMatchers("/api/v1/merchantStock").permitAll()
                .antMatchers("/api/v1/merchant").permitAll()



                .antMatchers("/api/v1/admin").hasAuthority("Admin")
                .antMatchers("/api/v1/product/{price}").hasAuthority("Admin")
                .antMatchers("/api/v1/add-product").hasAuthority("Admin")
                .antMatchers("/api/v1/update-product/{id}").hasAuthority("Admin")
                .antMatchers("/api/v1/delete-product/{id}").hasAuthority("Admin")
                .antMatchers("/api/v1/add-merchantStock").hasAuthority("Admin")
                .antMatchers("/api/v1/update-merchantStock/{index}").hasAuthority("Admin")
                .antMatchers("/api/v1/delete-merchantStock/{index}").hasAuthority("Admin")
                .antMatchers("/api/v1/merchantStock/add-product").hasAuthority("Admin")
                .antMatchers("/api/v1/add-merchant").hasAuthority("Admin")
                .antMatchers("/api/v1/update-merchant/{index}").hasAuthority("Admin")
                .antMatchers("/api/v1/delete-merchant/{index}").hasAuthority("Admin")



                .anyRequest().authenticated()
                .and()
                .httpBasic();


    }
}

