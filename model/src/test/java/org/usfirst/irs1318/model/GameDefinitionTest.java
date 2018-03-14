package org.usfirst.irs1318.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class GameDefinitionTest {

    @Test
    public void builderTest(){
        Task task = new Task.Builder()
                .build();
        Actor actor = new Actor.Builder()
                .build();
        Map<String, Task> personTasks = new HashMap<>();
        personTasks.put("String", task);

        Map<String, Task> robotTasks = new HashMap<>();
        robotTasks.put("String", task);

        Map<String, Actor> scoreKeepers = new HashMap<>();
        scoreKeepers.put("String", actor);

        Map<String, Actor> foulTrackers = new HashMap<>();
        foulTrackers.put("String", actor);

        Map<String, Actor> playBook = new HashMap<>();
        playBook.put("String", actor);

        GameTerm gameTerm = new GameTerm.Builder().build();
        Set<GameTerm> gameTerms = new HashSet<>();
        gameTerms.add(gameTerm);

        GameDefinition gameDefinition = new GameDefinition.Builder()

                .setGameTerms(gameTerms)
                .setRobotTasks(robotTasks)
                .setPersonTasks(personTasks)
                .setScoreKeepers(scoreKeepers)
                .setFoulTrackers(foulTrackers)
                .setPlayBook(playBook)
                .build();

    }
    @Test
    public void testBuilderWithJackson() throws Exception {

        Task task = new Task.Builder()
                .build();
        Actor actor = new Actor.Builder()
                .build();
        Map<String, Task> personTasks = new HashMap<>();
        personTasks.put("String", task);

        Map<String, Task> robotTasks = new HashMap<>();
        robotTasks.put("String", task);

        Map<String, Actor> scoreKeepers = new HashMap<>();
        scoreKeepers.put("String", actor);

        Map<String, Actor> foulTrackers = new HashMap<>();
        foulTrackers.put("String", actor);

        Map<String, Actor> playBook = new HashMap<>();
        playBook.put("String", actor);

        GameTerm gameTerm = new GameTerm.Builder().build();
        Set<GameTerm> gameTerms = new HashSet<>();
        gameTerms.add(gameTerm);

        GameDefinition gameDefinition = new GameDefinition.Builder()

                .setGameTerms(gameTerms)
                .setRobotTasks(robotTasks)
                .setPersonTasks(personTasks)
                .setScoreKeepers(scoreKeepers)
                .setFoulTrackers(foulTrackers)
                .setPlayBook(playBook)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(gameDefinition);
        System.out.println(value);
        GameDefinition gameDefinitionValue = objectMapper.readValue(value, GameDefinition.class);
        System.out.println(gameDefinitionValue.toString());
        assertEquals(gameDefinition, gameDefinitionValue);
    }

}