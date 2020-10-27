package rentalbook;

import rentalbook.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBookDelvCreated_StatusUpdated(@Payload BookDelvCreated bookDelvCreated){

        if(bookDelvCreated.isMe()){
            System.out.println("##### listener StatusUpdated : " + bookDelvCreated.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBookDelvCanceled_StatusUpdated(@Payload BookDelvCanceled bookDelvCanceled){

        if(bookDelvCanceled.isMe()){
            System.out.println("##### listener StatusUpdated : " + bookDelvCanceled.toJson());
        }
    }

}
