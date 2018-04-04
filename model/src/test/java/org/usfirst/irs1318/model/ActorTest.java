package org.usfirst.irs1318.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ActorTest {

    @Test
    public void testBuilder(){

        //behaviors
        ActorStateMachine actorStateMachine = new ActorStateMachine.Builder().build();
        Set<ActorStateMachine> behaviors = new HashSet<ActorStateMachine>();
        behaviors.add(actorStateMachine);

        //listensTos
        ListensTo listensTo = new ListensTo.Builder().build();
        Set<ListensTo> listensTos = new HashSet<ListensTo>();
        listensTos.add(listensTo);

        Actor actor = new Actor.Builder()

                .setName("redPlateRedSwitch")
                .setAlliance(Alliance.RED)
                .setType("ScoreKeeper")
                .setListensTo(listensTos)
                .setBehaviors(behaviors)
                .build();

        assertEquals("redPlateRedSwitch", actor.getName());
        assertEquals(Alliance.RED, actor.getAlliance());
        assertEquals("ScoreKeeper", actor.getType());
    }
    @Test
    public void testBuilderWithJackson() throws Exception{

        //behaviors
        ActorStateMachine actorStateMachine = new ActorStateMachine.Builder().build();
        Set<ActorStateMachine> behaviors = new HashSet<ActorStateMachine>();
        behaviors.add(actorStateMachine);

        //listensTos
        ListensTo listensTo = new ListensTo.Builder().build();
        Set<ListensTo> listensTos = new HashSet<ListensTo>();
        listensTos.add(listensTo);

        Actor actor = new Actor.Builder()

                .setName("redPlateRedSwitch")
                .setAlliance(Alliance.RED)
                .setType("ScoreKeeper")
                .setListensTo(listensTos)
                .setBehaviors(behaviors)
                .build();

        assertEquals("redPlateRedSwitch", actor.getName());
        assertEquals(Alliance.RED, actor.getAlliance());
        assertEquals("ScoreKeeper", actor.getType());
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(actor);
        System.out.println(value);
        Actor actorValue = objectMapper.readValue(value, Actor.class);
        System.out.println(actorValue.toString());
        assertEquals(actor, actorValue);

        Actor copyActor = new Actor.Builder().copyOf(actor).build();
        assertEquals(actor, copyActor);

    }

}