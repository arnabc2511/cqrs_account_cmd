package com.techbank.account.cmd.infrastruture;

import com.techbank.cqrs.core.events.BaseEvents;
import com.techbank.cqrs.core.producers.EventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountEventProducer implements EventProducer {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    /**
     * @param topic
     * @param events
     */
    @Override
    public void produce(String topic, BaseEvents events) {

        this.kafkaTemplate.send(topic,events);
    }
}
