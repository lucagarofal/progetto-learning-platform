package it.aulab.progettolearningplatform;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProgettoLearningPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgettoLearningPlatformApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		ModelMapper mapper = new ModelMapper();
		return mapper;
	}


}
