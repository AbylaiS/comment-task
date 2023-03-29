//package kz.dar.university.commenttask.service.send;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//@Slf4j
//public class SendService {
//    @Autowired
//    private KafkaTemplate<String, String>kafkaTemplate;
//
//    @Value("${quickstart-comments}")
//
//    private String topic;
//
//
//    public void send(String message){
//
//        log.info("Message send to kafka: {}" + message);
//        kafkaTemplate.send(topic , message);
//    }
//
//}
