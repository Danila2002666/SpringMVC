package com.example.lesson.config;

import com.example.lesson.models.Person;
import com.example.lesson.repository.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/person/main", true)
                        .permitAll())
                .logout()
                .permitAll()
                .and()
                .authorizeHttpRequests((authz) -> authz.anyRequest().authenticated())
                .httpBasic();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PersonRepository personRepository) {
        return email -> {
            Person person = personRepository.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден: " + email));
            return new org.springframework.security.core.userdetails.User(person.getEmail(), person.getPassword(), person.getRoles());
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}