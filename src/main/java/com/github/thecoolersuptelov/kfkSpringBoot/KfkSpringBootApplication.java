package com.github.thecoolersuptelov.kfkSpringBoot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KfkSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(KfkSpringBootApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate){
		return args -> {
			for (int i = 0; i < 100_000; i++) {
				kafkaTemplate.send("someNewTopic", String.valueOf(i));
			}

		};
	}

}
