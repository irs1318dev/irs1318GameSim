package org.usfirst.irs1318.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void testBuilder(){
        Field field = new Field.Builder()
                .build();
    }
    @Test
    public void testBuilderWithJackson()throws Exception{

        Field field = new Field.Builder()
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(field);
        System.out.println(value);
        Field fieldValue = objectMapper.readValue(value, Field.class);
        System.out.println(fieldValue.toString());
        assertEquals(field, fieldValue);
    }
}