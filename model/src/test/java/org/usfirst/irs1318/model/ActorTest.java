package org.usfirst.irs1318.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActorTest {

    @Test
    public void testBuilder(){

        Actor actor = new Actor.Builder()

                .setName("redPlateRedSwitch")
                .setAlliance(Alliance.RED)
                .setType("ScoreKeeper")
                .build();

        assertEquals("redPlateRedSwitch", actor.getName());
        assertEquals(Alliance.RED, actor.getAlliance());
        assertEquals("ScoreKeeper", actor.getType());
    }
    @Test
    public void testBuilderWithJackson()throws Exception{

        Actor actor = new Actor.Builder()

                .setName("redPlateRedSwitch")
                .setAlliance(Alliance.RED)
                .setType("ScoreKeeper")
                .build();

        assertEquals("redPlateRedSwitch", actor.getName());
        assertEquals(Alliance.RED, actor.getAlliance());
        assertEquals("ScoreKeeper", actor.getType());
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writeValueAsString(actor);
        System.out.println(value);
        Actor actorValue = objectMapper.readValue(value, Actor.class);
        System.out.println(actorValue.toString());
        assertEquals(actor, actorValue);
    }
}