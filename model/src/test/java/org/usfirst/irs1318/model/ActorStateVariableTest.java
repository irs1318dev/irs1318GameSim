package org.usfirst.irs1318.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;


public class ActorStateVariableTest {

    @Test
    public void testBuilder() {

        ActorStateVariable actorStateVariable = new ActorStateVariable.Builder()

                .setName("ownershipCount")
                .setType(StateVariableType.INT)
                .build();

        assertEquals("ownershipCount", actorStateVariable.getName());
        assertEquals(StateVariableType.INT, actorStateVariable.getType());
    }

    @Test
    public void testBuilderWithJackson()throws Exception{

        ActorStateVariable actorStateVariable = new ActorStateVariable.Builder()

                .setName("ownershipCount")
                .setType(StateVariableType.INT)
                .build();

        assertEquals("ownershipCount", actorStateVariable.getName());
        assertEquals(StateVariableType.INT, actorStateVariable.getType());
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(actorStateVariable);
        System.out.println(value);
        ActorStateVariable actorStateVariableValue = objectMapper.readValue(value, ActorStateVariable.class);
        System.out.println(actorStateVariableValue.toString());
        assertEquals(actorStateVariable, actorStateVariableValue);
    }
}