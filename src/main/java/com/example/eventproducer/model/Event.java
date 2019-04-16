package com.example.eventproducer.model;

import lombok.Data;

@Data
public class Event {

    private String eventType;
    private Object data;

    public Event(String eventType, Object data) {
        this.eventType = eventType;
        this.data = data;
    }
}
