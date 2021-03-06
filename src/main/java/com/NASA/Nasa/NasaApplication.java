package com.NASA.Nasa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class NasaApplication {

	private static final Logger log = LoggerFactory.getLogger(NasaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(NasaApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			APOD quote = restTemplate.getForObject(
					"https://api.nasa.gov/planetary/apod?api_key=kw9WkUDnlcLiqnobGeDfT9mBiEl0QGxLYs5wLPjS", APOD.class);
			log.info(quote.getTitle());
			log.info(quote.getDate());
			log.info(quote.getExplanation());

		};
	}

	@GetMapping("/api-data")
	public APOD info (RestTemplate restTemplate) {
				APOD apod = restTemplate.getForObject("https://api.nasa.gov/planetary/apod?api_key" +
						"=kw9WkUDnlcLiqnobGeDfT9mBiEl0QGxLYs5wLPjS", APOD.class);
				return apod;

	}

}
