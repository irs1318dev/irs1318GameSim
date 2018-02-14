package org.usfirst.irs1318.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ActorTest {

    @Test
    public void builderTest(){

        Actor actor = new Actor.Builder()

                .setName("redPlateRedSwitch")
                .setAlliance(Alliance.RED)
                .build();

        assertEquals("redPlateRedSwitch", actor.getName());
        assertEquals(Alliance.RED, actor.getAlliance());


    }

}