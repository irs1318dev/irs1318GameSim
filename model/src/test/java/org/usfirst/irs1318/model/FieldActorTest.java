package org.usfirst.irs1318.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class FieldActorTest {

    @Test
    public void builderTest(){

        FieldActor fieldActor = new FieldActor.Builder()
                .setId("puq")
                .setName("powerUpQueue")
                .setType("powerUpQueue")
                .build();

        assertEquals("puq", fieldActor.getId());
        assertEquals("powerUpQueue", fieldActor.getName());
        assertEquals("powerUpQueue", fieldActor.getType());

    }
    @Test
    public void testBuilderWithJackson() throws Exception {

        FieldActor fieldActor = new FieldActor.Builder()
                .setId("puq")
                .setName("powerUpQueue")
                .setType("powerUpQueue")
                .build();

        assertEquals("puq", fieldActor.getId());
        assertEquals("powerUpQueue", fieldActor.getName());
        assertEquals("powerUpQueue", fieldActor.getType());
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fieldActor);
        System.out.println(value);
        FieldActor fieldActorValue = objectMapper.readValue(value, FieldActor.class);
        System.out.println(fieldActorValue.toString());
        assertEquals(fieldActor, fieldActorValue);
    }

}