package com.github.thecoolersuptelov.kfkSpringBoot;


import org.apache.logging.log4j.LogBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    Logger logger = LogManager.getLogger();

    @KafkaListener(topics = "someNewTopic",groupId = "groupId")
    void listener(String data){
        logger.info(data);
    }

}
