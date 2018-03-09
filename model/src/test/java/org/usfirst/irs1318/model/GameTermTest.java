package org.usfirst.irs1318.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTermsTest {
    @Test
    public void testBuilder(){
        GameTerms gameTerms = new GameTerms.Builder()
                .build();
    }
    @Test
    public void testBuilderWithJackson()throws Exception{

        GameTerms gameTerms = new GameTerms.Builder()
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(gameTerms);
        System.out.println(value);
        GameTerms gameTermsValue = objectMapper.readValue(value, GameTerms.class);
        System.out.println(gameTermsValue.toString());
        assertEquals(gameTerms, gameTermsValue);
    }
}