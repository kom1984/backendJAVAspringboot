package com.parkauto.parkauto;

import com.parkauto.parkauto.entity.Role;
import com.parkauto.parkauto.entity.User;
import com.parkauto.parkauto.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ParkAutoApplication implements CommandLineRunner {

	@Autowired
	private IUserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ParkAutoApplication.class, args);
	}



	@Bean

	public CorsFilter corsFilter() {

		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();

		CorsConfiguration corsConfiguration = new CorsConfiguration();

		corsConfiguration.setAllowCredentials(true);

		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:8100","http://localhost:4200"));

		corsConfiguration.setAllowedHeaders(Arrays.asList(

				"Origin", "Access-Control-Allow-Origin",

				"Content-Type",

				"Accept", "Jwt-Token",

				"Authorization",

				"Origin, Accept",

				"X-Requested-With",

				"Access-Control-Request-Method",

				"Access-Control-Request-Headers"

		));

		corsConfiguration.setExposedHeaders(Arrays.asList(

				"Origin",

				"Content-Type",

				"Accept",

				"Jwt-Token",

				"Authorization",

				"Access-Control-Allow-Origin",

				"Access-Control-Allow-Origin",

				"Access-Control-Allow-Credentials"

		));

		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

		return new CorsFilter(urlBasedCorsConfigurationSource);

	}




	@Override
	public void run(String... args) throws Exception {
		User adminAccount = userRepository.findByRole(Role.ADMIN);
		if(adminAccount == null){
			User user = new User();
			user.setEmail("admin@mail.com");
			user.setFirstname("admin");
			user.setLastname("admin");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepository.save(user);

		}
	}
}
