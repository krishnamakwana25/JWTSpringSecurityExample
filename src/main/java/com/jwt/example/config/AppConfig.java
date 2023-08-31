package com.jwt.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails admin = User.builder()
//                    .username("krishna")
//                    .password(bCryptPasswordEncoder().encode("123"))
//                    .roles("ADMIN")
//                .build();
//
//        UserDetails subAdmin = User.builder()
//                .username("Harsh")
//                .password(bCryptPasswordEncoder().encode("123"))
//                .roles("SUBADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(admin, subAdmin);
//    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
