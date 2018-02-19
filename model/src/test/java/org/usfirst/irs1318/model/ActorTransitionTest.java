package org.usfirst.irs1318.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActorTransitionTest {

    @Test
    public void builderTest(){

        ActorState actorState1 = new ActorState.Builder().build();
        AcceptedEvent acceptedEvent = new AcceptedEvent.Builder().build();
        ActorState actorState2 = new ActorState.Builder().build();

        ActorTransition actorTransition = new ActorTransition.Builder()

                .setFrom(actorState1)
                .setTrigger(acceptedEvent)
                .setGuard("calculateOwnership")
                .setTo(actorState2)
                .build();

        assertEquals(actorState1, actorTransition.getFrom());
        assertEquals(acceptedEvent, actorTransition.getTrigger());
        assertEquals("calculateOwnership", actorTransition.getGuard());
        assertEquals(actorState2, actorTransition.getTo());
    }
    @Test
    public void testBuilderWithJackson() throws Exception {

        ActorState actorState1 = new ActorState.Builder().build();
        AcceptedEvent acceptedEvent = new AcceptedEvent.Builder().build();
        ActorState actorState2 = new ActorState.Builder().build();

        ActorTransition actorTransition = new ActorTransition.Builder()

                .setFrom(actorState1)
                .setTrigger(acceptedEvent)
                .setGuard("calculateOwnership")
                .setTo(actorState2)
                .build();

        assertEquals(actorState1, actorTransition.getFrom());
        assertEquals(acceptedEvent, actorTransition.getTrigger());
        assertEquals("calculateOwnership", actorTransition.getGuard());
        assertEquals(actorState2, actorTransition.getTo());
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writeValueAsString(actorTransition);
        System.out.println(value);
        ActorTransition actorTransitionValue = objectMapper.readValue(value, ActorTransition.class);
        System.out.println(actorTransitionValue.toString());
        assertEquals(actorTransition, actorTransitionValue);
    }


}