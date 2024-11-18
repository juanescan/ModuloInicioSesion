package NuestraSenoraDeLaSabiduria.LoginBack.Configuracion;

import static org.springframework.security.config.Customizer.withDefaults;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SeguridadConfiguracion {

  public SecurityFilterChain securityFilterChain(HttpSecurity http)
    throws Exception {
    return http
      .csrf(csrf -> csrf.disable())
      .authorizeHttpRequests(authorize ->
        authorize
          .requestMatchers("/acceder/**")
          .permitAll()
          .requestMatchers("/registrar/**")
          .permitAll()
          .anyRequest()
          .authenticated()
      )
      .formLogin(withDefaults())
      .build();
  }
}
