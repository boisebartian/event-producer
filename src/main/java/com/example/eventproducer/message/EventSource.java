package com.example.eventproducer.message;

import com.example.eventproducer.model.Event;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(Source.class)
@AllArgsConstructor
public class EventSource {

    private final Source source;

    public boolean send(Event event) {
        return publish(MessageBuilder.withPayload(event).build());
    }

    private boolean publish(Message<Event> message) {
        if (source.output().send(message)) {
            return true;
        }
        else {
            return false;
        }
    }
}
