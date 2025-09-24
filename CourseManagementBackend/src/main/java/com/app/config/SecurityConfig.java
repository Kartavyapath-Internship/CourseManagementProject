package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.app.service.StaffUserDetailsService;


import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity()
//@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	
	private final StaffUserDetailsService userDetailsService;
	
    private final JwtAuthenticationFilter jwtAuthFilter;
    
    //  Security Filter Chain
 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http  
        
        .csrf(csrf -> csrf.disable())
        // Enable CORS for frontend calls
        .cors(Customizer.withDefaults())

        // Authorization rules
        .authorizeHttpRequests(auth -> auth
            // Schedules
            .requestMatchers(HttpMethod.GET, "/api/schedules/**").hasAnyRole("ADMIN", "COORDINATOR") 
            .requestMatchers(HttpMethod.POST, "/api/schedules/**").hasRole("COORDINATOR")           
            .requestMatchers(HttpMethod.PUT, "/api/schedules/**").hasRole("COORDINATOR")            
            .requestMatchers(HttpMethod.DELETE, "/api/schedules/**").hasRole("COORDINATOR")         

            // Other endpoints (example)
            .requestMatchers("/infrastructure/**").hasRole("ADMIN") 
            .requestMatchers("/coursetype/**").hasRole("ADMIN")
            .requestMatchers("/infrastructure/**").hasRole("ADMIN")
            .requestMatchers("/menuitems/**").hasRole("ADMIN")
            .requestMatchers("/premises/**").hasRole("ADMIN")
            .requestMatchers("/roles/**").hasRole("ADMIN")
            .requestMatchers("/section/**").hasRole("ADMIN")
            .requestMatchers("/staff/**").hasRole("ADMIN")
            .requestMatchers("/api/subjects/**").hasRole("ADMIN")
            .requestMatchers("/topic/**").hasRole("ADMIN")
            .requestMatchers("/batchcycle/**").hasRole("ADMIN")
            .requestMatchers("/coursegroup/**").hasRole("COORDINATOR")
            .requestMatchers("/session/**").hasRole("COORDINATOR")
            .requestMatchers("/api/course-modules/**").hasRole("COORDINATOR")
            .requestMatchers("/students/**").hasRole("COORDINATOR")
            .requestMatchers("/login/**").permitAll()                       // Login
            .anyRequest().authenticated()
         )

        // Use our UserDetailsService
       // .userDetailsService(userDetailsService)

        // Add JWT filter before username/password auth filter
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)

       //  Disable default login forms
        .formLogin(form -> form.disable())
        .httpBasic(basic -> basic.disable());

    return http.build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf(csrf -> csrf.disable())   // disable CSRF
//            .cors(Customizer.withDefaults())  // disable CORS security (optional, frontend can call directly)
//            .authorizeHttpRequests(auth -> auth
//                .anyRequest().permitAll()   // 🔓 allow all requests
//            )
//            .formLogin(form -> form.disable()) // disable login form
//            .httpBasic(basic -> basic.disable()); // disable basic auth
//        	
//        return http.build();
//    }
    
 
    // Authentication Manager (used in AuthService for login)
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
    
    // Password encoder (BCrypt)
   
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
}
