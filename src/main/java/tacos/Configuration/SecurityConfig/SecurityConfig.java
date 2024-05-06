package tacos.Configuration.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests-> requests.requestMatchers("/design","/orders").authenticated()
                        .requestMatchers("/","/**").permitAll()
                        .anyRequest().permitAll())
                .formLogin(login -> login.loginPage("/login").permitAll());
        return http.build();

        // when we direct the process to authenticate the user,
        // spring Security's UsernamePasswordAuthenticationFilter will intercept the request to /authenticate and initiate the authentication process using the provided credentials.
    }
}
