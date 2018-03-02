package org.usfirst.irs1318.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class FieldSquareTest {
    @Test
    public void testBuilder(){
        FieldSquare fieldSquare = new FieldSquare.Builder()
                .build();
    }
    @Test
    public void testBuilderWithJackson()throws Exception{

        FieldSquare fieldSquare = new FieldSquare.Builder()
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fieldSquare);
        System.out.println(value);
        FieldSquare fieldSquareValue = objectMapper.readValue(value, FieldSquare.class);
        System.out.println(fieldSquareValue.toString());
        assertEquals(fieldSquare, fieldSquareValue);
    }
}