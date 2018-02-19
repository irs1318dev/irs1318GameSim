package org.usfirst.irs1318.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class AcceptedEventTest {

    @Test
    public void builderTest(){

        Map<String, String> data = new HashMap<>();
        data.put("owner", "red");

        AcceptedEvent acceptedEvent = new AcceptedEvent.Builder()

                .setEventName("ownershipChangeEvent")
                .setData(data)
                .setType("output")
                .build();

        assertEquals("ownershipChangeEvent", acceptedEvent.getEventName());
        assertEquals("output", acceptedEvent.getType());
    }
    @Test
    public void testBuilderWithJackson() throws Exception {

        Map<String, String> data = new HashMap<>();
        data.put("owner", "red");

        AcceptedEvent acceptedEvent = new AcceptedEvent.Builder()

                .setEventName("ownershipChangeEvent")
                .setData(data)
                .setType("output")
                .build();

        assertEquals("ownershipChangeEvent", acceptedEvent.getEventName());
        assertEquals("output", acceptedEvent.getType());
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writeValueAsString(acceptedEvent);
        System.out.println(value);
        AcceptedEvent acceptedEventValue = objectMapper.readValue(value, AcceptedEvent.class);
        System.out.println(acceptedEventValue.toString());
        assertEquals(acceptedEvent, acceptedEventValue);
    }


}