package com.example.kafkaconsumer.producer;
import org.springframework.kafka.support.SendResult;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class Producer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "confluent_spring_boot_topic";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String key, String value) {
        ListenableFuture<SendResult<String, String>> future = (ListenableFuture<SendResult<String, String>>) kafkaTemplate.send(TOPIC, key, value);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info(String.format("Produced event to topic %s: key = %-10s value = %s", TOPIC, key, value));
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.error(String.format("Unable to produce event to topic %s: key = %s value = %s", TOPIC, key, value), ex);
            }
        });
    }
}

