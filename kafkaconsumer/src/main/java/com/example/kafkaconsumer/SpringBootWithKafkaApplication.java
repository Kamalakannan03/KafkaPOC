package com.example.kafkaconsumer;

import com.example.kafkaconsumer.producer.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootWithKafkaApplication {

	//private final Producer producer;


	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithKafkaApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner CommandLineRunnerBean() {
		return (args) -> {
			this.producer.sendMessage("key", "value");
			MessageListenerContainer listenerContainer = kafkaListenerEndpointRegistry.getListenerContainer("myConsumer");
			listenerContainer.start();
		};
	}*/

/*	@Autowired
	SpringBootWithKafkaApplication(Producer producer) {
		this.producer = producer;
	}*/



}