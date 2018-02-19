package org.usfirst.irs1318.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import static org.junit.Assert.*;

public class ActorStateTest {

    @Test
    public void testBuilder(){

        ActorState actorState = new ActorState.Builder()

                .setName("blueOwnership")
                .setOnEntry("ownershipChangeEvent")
                .setOnExit("ownershipChangeEvent")
                .build();

        assertEquals("blueOwnership", actorState.getName());
        assertEquals("ownershipChangeEvent", actorState.getOnEntry());
        assertEquals("ownershipChangeEvent", actorState.getOnExit());
    }
    @Test
    public void testBuilderWithJackson() throws Exception {

        ActorState actorState = new ActorState.Builder()
                .setName("blueOwnership")
                .setOnEntry("ownershipChangeEvent")
                .setOnExit("ownershipChangeEvent")
                .build();

        assertEquals("blueOwnership", actorState.getName());
        assertEquals("ownershipChangeEvent", actorState.getOnEntry());
        assertEquals("ownershipChangeEvent", actorState.getOnExit());
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writeValueAsString(actorState);
        System.out.println(value);
        ActorState actorStateValue = objectMapper.readValue(value, ActorState.class);
        System.out.println(actorStateValue.toString());
        assertEquals(actorState, actorStateValue);
    }

}