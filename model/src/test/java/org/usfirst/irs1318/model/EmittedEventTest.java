package org.usfirst.irs1318.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class EmittedEventTest {

    @Test
    public void builderTest(){

        Map<String, String> properties = new HashMap<>();
        properties.put("owner", "red");

        EmittedEvent emittedEvent = new EmittedEvent.Builder()

                .setEventName("addCubeEvent")
                .setProperties(properties)
                .build();

        assertEquals("addCubeEvent", emittedEvent.getEventName());
    }
    @Test
    public void testBuilderWithJackson() throws Exception {

        Map<String, String> properties = new HashMap<>();
        properties.put("owner", "red");

        EmittedEvent emittedEvent = new EmittedEvent.Builder()

                .setEventName("addCubeEvent")
                .setProperties(properties)
                .build();

        assertEquals("addCubeEvent", emittedEvent.getEventName());
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emittedEvent);
        System.out.println(value);
        EmittedEvent emittedEventValue = objectMapper.readValue(value, EmittedEvent.class);
        System.out.println(emittedEventValue.toString());
        assertEquals(emittedEvent, emittedEventValue);

        EmittedEvent copyEmittedEvent = new EmittedEvent.Builder().copyOf(emittedEvent).build();
        assertEquals(emittedEvent, copyEmittedEvent);
    }

}