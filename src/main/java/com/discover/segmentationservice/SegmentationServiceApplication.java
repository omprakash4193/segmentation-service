package com.discover.segmentationservice;

import com.discover.segmentationservice.client.ExtoleApiClient;
import com.discover.segmentationservice.config.AppConfig;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SegmentationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SegmentationServiceApplication.class, args);
	}

	@Autowired
	AppConfig appConfig;

	@Bean
	public ExtoleApiClient getEmployeeServiceClient(){
		return Feign.builder()
				.encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder())
				.target(ExtoleApiClient.class, appConfig.getExtoleBaseUrl());
	}
}
