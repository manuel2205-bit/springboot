package com.example.sprinboot_crud.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import com.example.sprinboot_crud.service.impl.CustomUserDetailsService;

@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    
    @Autowired
    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    // Configuración de seguridad
    @SuppressWarnings("removal")
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
                        // Usamos requestMatchers() en lugar de antMatchers()
                        .requestMatchers("/login", "/css/**", "/js/**", "/index").permitAll() // Permitir acceso a login y recursos estáticos
                        .anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/login") // Página de login personalizada
                        .loginProcessingUrl("/login") // URL para procesar el login
                        .defaultSuccessUrl("/index", true) // Redirige a index tras un login exitoso
                        .failureUrl("/login?error=true") // Redirige a login con error si el login falla
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout") // URL para cerrar sesión
                        .logoutSuccessUrl("/login?logout=true") // Redirige a login tras cerrar sesión
                        .permitAll());

        return http.build();
    }

    // Bean AuthenticationManager para Spring Security
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
            http.getSharedObject(AuthenticationManagerBuilder.class);
        
        authenticationManagerBuilder.userDetailsService(customUserDetailsService)
            .passwordEncoder(passwordEncoder());
        
        return authenticationManagerBuilder.build();
    }

    // Bean para PasswordEncoder (usamos BCrypt en este caso)
    @Bean
    public PasswordEncoder passwordEncoder() {
        //return new BCryptPasswordEncoder();
    	return NoOpPasswordEncoder.getInstance();
    }

    // Bean para UserDetailsService (usamos el CustomUserDetailsService para cargar los usuarios)
    /*@Bean
    public UserDetailsService userDetailsService() {
        return customUserDetailsService;
    }*/
}
