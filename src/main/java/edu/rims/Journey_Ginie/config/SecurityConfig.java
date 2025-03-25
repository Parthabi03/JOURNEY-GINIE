// package edu.rims.Journey_Ginie.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// import edu.rims.Journey_Ginie.entity.User;
// import edu.rims.Journey_Ginie.repository.UserRepository;

// @Configuration
// public class SecurityConfig {
    
//     @Autowired
//     private UserRepository userRepository;

//     @Bean
//     SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http.authorizeHttpRequests(request -> request
//                 .requestMatchers("/customer/login", "/style/**", "/script/**", "/img/**", "/video/**", 
//                                 "/customer/home", "/customer/destination", "/customer/destination/pdp", 
//                                 "/destination/search", "/customer/registration", "/customer/tour", 
//                                 "/customer/packages/pdp2", "/customer/booking", "/customer/attraction")
//                 .permitAll()
//                 .requestMatchers("/admin/**").hasRole("ADMIN")
//                 .anyRequest().authenticated()  // ✅ Ensures all other requests require authentication
//         );

//         http.formLogin(form -> form
//                 .loginPage("/customer/login")
//                 .loginProcessingUrl("/customer/login")  // ✅ Spring processes the form submission here
//                 .usernameParameter("email")  // ✅ Uses "email" instead of "username"
//                 .passwordParameter("password")
//                 .defaultSuccessUrl("/customer/home", true)  // ✅ Redirect after successful login
//                 .permitAll()
//         );

//         http.logout(Customizer.withDefaults());

//         return http.build(); // ✅ Required to apply security configuration
//     }

//     @Bean
//     PasswordEncoder encoder() {
//         return new BCryptPasswordEncoder(12);
//     }

//     @Bean
//     UserDetailsService detailsService() {
//         return (email) -> {
//             User user = userRepository.findByEmail(email)
//                     .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//             return org.springframework.security.core.userdetails.User.builder()
//                     .username(user.getEmail())
//                     .password(user.getPassword())
//                     .roles(user.getRole().toString())
//                     .build();
//         };
//     }
// }

package edu.rims.Journey_Ginie.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import edu.rims.Journey_Ginie.entity.User;
import edu.rims.Journey_Ginie.repository.UserRepository;

@Configuration
public class SecurityConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> request
                .requestMatchers("/customer/login", "/style/**", "/script/**", "/img/**", "/video/**",
                        "/customer/home", "/customer/destination", "/customer/destination/pdp", "/destination/search",
                        "/customer/registration", "/customer/tour", "/customer/packages/pdp2", "/customer/booking",
                        "/customer/attraction")
                .permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated() // ✅ This was missing!
        );

        http.formLogin(form -> form
                .loginPage("/customer/login")
                .loginProcessingUrl("/customer/login") // Ensure Spring processes login requests here
                .usernameParameter("email") // Spring Security should use "email" as username
                .passwordParameter("password")
                .defaultSuccessUrl("/customer/home", true)
                .permitAll()
        );


        http.logout(Customizer.withDefaults()); // Ensures proper logout handling

        return http.build(); // ✅ Missing return statement in your previous version!
    }

    @Bean
    PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    UserDetailsService detailsService() {
        return (email) -> {
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getEmail()) // ✅ Using email as username
                    .password(user.getPassword()) // Ensure passwords are encoded!
                    .roles(user.getRole().toString())
                    .build();
        };
    }
}

