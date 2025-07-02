package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((requests) ->
//                ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.anyRequest()).authenticated());
        http.authorizeHttpRequests(requests ->
                requests
                        .requestMatchers("/userAccount","/userBalance","/userLoan","/userCards")
                        .authenticated().requestMatchers("/notices","/contacts","/error","/welcome").permitAll());
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        // to disable formlogin and basic authentication
       /* http.formLogin(flc->flc.disable());
        http.httpBasic(hbc->hbc.disable());*/

        return (SecurityFilterChain)http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){

       UserDetails user = User.withUsername("user")
        .password(passwordEncoder().encode("{noop}12345"))
        .authorities("read").build();

       UserDetails admin = User.withUsername("admin")
        .password(passwordEncoder().encode("{noop}54321"))
        .authorities("admin").build();

    return new InmemoryUserDetailsManager(user,admin);
    }


    }

