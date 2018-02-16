package org.usfirst.irs1318.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class EmittedEventTest {

    @Test
    public void builderTest(){

        EmittedEvent emittedEvent = new EmittedEvent.Builder()

                .setEventName("addCubeEvent")
                .build();

        assertEquals("addCubeEvent", emittedEvent.getEventName());
    }
}