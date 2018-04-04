package org.usfirst.irs1318.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;


public class ActorStateMachineTest {
    @Test
    public void builderTest(){

        //events
        AcceptedEvent acceptedEvent = new AcceptedEvent.Builder().build();
        Set<AcceptedEvent> events = new HashSet<>();
        events.add(acceptedEvent);

        //data
        ActorStateVariable actorStateVariable = new ActorStateVariable.Builder().build();
        Set<ActorStateVariable> data = new HashSet<>();
        data.add(actorStateVariable);

        //dataUpdates
        DataUpdate dataUpdate = new DataUpdate.Builder().build();
        List<DataUpdate> dataUpdates = new ArrayList<>();
        dataUpdates.add(dataUpdate);

        //states
        ActorState actorState = new ActorState.Builder().build();
        Set<ActorState> states = new HashSet<>();
        states.add(actorState);

        //transitions
        ActorTransition actorTransition = new ActorTransition.Builder().build();
        List<ActorTransition> transitions = new ArrayList<>();
        transitions.add(actorTransition);


        ActorStateMachine actorStateMachine = new ActorStateMachine.Builder()

                .setName("switchOwnership")
                .setEvents(events)
                .setData(data)
                .setDataUpdates(dataUpdates)
                .setInitialState("neutral")
                .setStates(states)
                .setTransitions(transitions)
                .build();

        assertEquals("switchOwnership", actorStateMachine.getName());
        assertEquals("neutral", actorStateMachine.getInitialState());
    }
    @Test
    public void testBuilderWithJackson() throws Exception {

        //events
        AcceptedEvent acceptedEvent = new AcceptedEvent.Builder().build();
        Set<AcceptedEvent> events = new HashSet<>();
        events.add(acceptedEvent);

        //data
        ActorStateVariable actorStateVariable = new ActorStateVariable.Builder().build();
        Set<ActorStateVariable> data = new HashSet<>();
        data.add(actorStateVariable);

        //dataUpdates
        DataUpdate dataUpdate = new DataUpdate.Builder().build();
        List<DataUpdate> dataUpdates = new ArrayList<>();
        dataUpdates.add(dataUpdate);

        //states
        ActorState actorState = new ActorState.Builder().build();
        Set<ActorState> states = new HashSet<>();
        states.add(actorState);

        //transitions
        ActorTransition actorTransition = new ActorTransition.Builder().build();
        List<ActorTransition> transitions = new ArrayList<>();
        transitions.add(actorTransition);


        ActorStateMachine actorStateMachine = new ActorStateMachine.Builder()

                .setName("switchOwnership")
                .setEvents(events)
                .setData(data)
                .setDataUpdates(dataUpdates)
                .setInitialState("neutral")
                .setStates(states)
                .setTransitions(transitions)
                .build();

        assertEquals("switchOwnership", actorStateMachine.getName());
        assertEquals("neutral", actorStateMachine.getInitialState());
        ObjectMapper objectMapper = new ObjectMapper();
        String value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(actorStateMachine);
        System.out.println(value);
        ActorStateMachine actorStateMachineValue = objectMapper.readValue(value, ActorStateMachine.class);
        System.out.println(actorStateMachineValue.toString());
        assertEquals(actorStateMachine, actorStateMachineValue);

        ActorStateMachine copyActorStateMachine = new ActorStateMachine.Builder().copyOf(actorStateMachine).build();
        assertEquals(actorStateMachine, copyActorStateMachine);
    }
}