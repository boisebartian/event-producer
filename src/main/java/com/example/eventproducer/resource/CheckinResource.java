package com.example.eventproducer.resource;

import com.example.eventproducer.message.EventSource;
import com.example.eventproducer.model.Checkin;
import com.example.eventproducer.model.Event;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.Date;

@RestController
@RequestMapping(value = "/v1/checkin", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CheckinResource {

    private final EventSource eventSource;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Checkin> createCheckin(@RequestBody Checkin checkin) {
        checkin.setCheckinDate(new Date());
        eventSource.send(new Event("customer_checkin", checkin));
        return ResponseEntity.ok(checkin);
    }
}
