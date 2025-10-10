package com.encora.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.encora.model.User;
import com.encora.repository.UserDetailsRepository;

@Component
public class AdminUserInitializer {

	@Bean
	public CommandLineRunner createAdminUser(UserDetailsRepository userDetailsRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if(userDetailsRepository.findByUsername("admin").isEmpty()) {
				User admin = new User();
				admin.setUsername("admin");
				admin.setPassword(passwordEncoder.encode("admin123"));
				admin.setRole("ROLE_ADMIN");
				
				userDetailsRepository.save(admin);
				System.out.println("Default admin user created!");
			}
		};
	}
}
