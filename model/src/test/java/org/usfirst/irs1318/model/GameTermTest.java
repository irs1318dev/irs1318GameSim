package org.usfirst.irs1318.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTermTest {
    @Test
    public void testBuilder(){
        GameTerm gameTerm = new GameTerm.Builder()
                .build();
    }
    @Test
    public void testBuilderWithJackson()throws Exception{

        GameTerm gameTerm = new GameTerm.Builder()
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(gameTerm);
        System.out.println(value);
        GameTerm gameTermValue = objectMapper.readValue(value, GameTerm.class);
        System.out.println(gameTermValue.toString());
        assertEquals(gameTerm, gameTermValue);
    }
}