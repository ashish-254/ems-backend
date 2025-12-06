package com.employeemanagement.backend.passwordencoding;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * creating a class to encode password.
 */
@Configuration
public class SecurityConfig {
  /**
  * use to encode password.
  *
  * @return object BCryptPasswordEncoder().
  */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
