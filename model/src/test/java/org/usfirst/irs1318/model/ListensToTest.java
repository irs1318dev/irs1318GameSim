package org.usfirst.irs1318.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ListensToTest {

    @Test
    public void testBuilder() throws Exception {

        Map<String, String> properties = new HashMap<>();
        properties.put("powerup", "boost");

        ArrayList<EmittedEvent> emittedEventsList = new ArrayList<>();
        EmittedEvent emittedEvent = new EmittedEvent.Builder()
                .setEventName("powerupActivatedEvent")
                .setProperties(properties)
                .build();
        emittedEventsList.add(emittedEvent);


        ListensTo listensTo = new ListensTo.Builder()
                .setActorName("redPlateRedSwitch")
                .setEmittedEvent(emittedEventsList)
                .build();

        assertEquals("redPlateRedSwitch", listensTo.getActorName());
    }

    @Test
    public void testBuilderWithJackson() throws Exception {

        Map<String, String> properties = new HashMap<>();
        properties.put("powerup", "boost");

        ArrayList<EmittedEvent> emittedEventsList = new ArrayList<>();
        EmittedEvent emittedEvent = new EmittedEvent.Builder()
                .setEventName("powerupActivatedEvent")
                .setProperties(properties)
                .build();
        emittedEventsList.add(emittedEvent);


        ListensTo listensTo = new ListensTo.Builder()
                .setActorName("redPlateRedSwitch")
                .setEmittedEvent(emittedEventsList)
                .build();

        assertEquals("redPlateRedSwitch", listensTo.getActorName());
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writeValueAsString(listensTo);
        System.out.println(value);
        ListensTo listensToValue = objectMapper.readValue(value, ListensTo.class);
        System.out.println(listensToValue.toString());
        assertEquals(listensTo, listensToValue);
    }

}