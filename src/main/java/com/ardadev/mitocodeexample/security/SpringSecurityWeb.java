package com.ardadev.mitocodeexample.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.ardadev.mitocodeexample.models.Employee;
import com.ardadev.mitocodeexample.service.EmployeeService;

import lombok.RequiredArgsConstructor;

/**
 * Configuraciones de Spring Security
 */
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SpringSecurityWeb {
    
    private final EmployeeService employeeService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.
            // csrf(e -> e.disable()).
            csrf(CsrfConfigurer::disable)
            .authorizeHttpRequests(req -> req
                // .requestMatchers("/books/**").permitAll()
                .requestMatchers("/categories/**").permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults())
            .userDetailsService(employeeService) // Aqui usamos los usuarios de la base de datos
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // @Bean
    // public UserDetailsService userDetailsServiceInMemory() {
    //     UserDetails user = User.builder()
    //         .username("user")
    //         .password("{noop}password")
    //         .roles("USER")
    //         .build();

    //     UserDetails admin = User.builder()
    //         .username("admin")
    //         .password("{noop}password")
    //         .roles("ADMIN")
    //         .build();

    //     return new InMemoryUserDetailsManager(user, admin);
    // }
}
