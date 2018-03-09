package org.usfirst.irs1318.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class GameDefinitionTest {

    @Test
    public void builderTest(){

        GameDefinition gameDefinition = new GameDefinition.Builder().build();

    }
    @Test
    public void testBuilderWithJackson() throws Exception {

        GameDefinition gameDefinition = new GameDefinition.Builder().build();

        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(gameDefinition);
        System.out.println(value);
        GameDefinition gameDefinitionValue = objectMapper.readValue(value, GameDefinition.class);
        System.out.println(gameDefinitionValue.toString());
        assertEquals(gameDefinition, gameDefinitionValue);
    }

}