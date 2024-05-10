package tacos.Configuration.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(requests->
//                        requests.requestMatchers("/test").permitAll()
//                        .anyRequest().authenticated())
//                .formLogin(login -> login.loginPage("/login").permitAll()).logout(lOut -> {
//                    lOut.invalidateHttpSession(true)
//                            .clearAuthentication(true)
//                            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                            .logoutSuccessUrl("/login?logout")
//                            .permitAll();
//            });

//        return http.build();

        return http
                .csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/register").permitAll()
                        .anyRequest().authenticated())
                .formLogin(login -> login.loginPage("/login").defaultSuccessUrl("/home",true).permitAll())
                .logout(logout ->
                        logout.clearAuthentication(true).invalidateHttpSession(true).logoutUrl("/logout"))
                .build();

        // when we direct the process to authenticate the user,
        // spring Security's UsernamePasswordAuthenticationFilter will intercept the request to /authenticate and initiate the authentication process using the provided credentials.
    }
}
