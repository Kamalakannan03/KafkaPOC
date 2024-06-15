package com.example.kafkaconsumer.controller;

import com.example.kafkaconsumer.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;
@Controller
public class Messagecontroller {
    @Autowired
    Producer producer;
    @Autowired
    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;
    @GetMapping("/gps")
    public String setAttributes(@RequestParam String key, @RequestParam String message){
        this.producer.sendMessage(key, message);
        /*MessageListenerContainer listenerContainer = kafkaListenerEndpointRegistry.getListenerContainer("myConsumer");
        listenerContainer.start();*/
        return "key sent successfully!!!";
    }
}
