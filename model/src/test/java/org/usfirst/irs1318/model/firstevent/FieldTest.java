package org.usfirst.irs1318.model.firstevent;



import org.junit.Test;
import org.usfirst.irs1318.model.*;

import javax.annotation.Nonnull;
import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * this class exercises the match actor for the field through at least one phase event
 */
public class FieldTest {

    @Test
    public void testFieldMatchActor() {

        Set<ActorState> states = new HashSet<>();
        states.add(new ActorState.Builder()
                .setName("pre")
                .build());
        states.add(new ActorState.Builder()
                .setName("auto")
                .build());
        states.add(new ActorState.Builder()
                .setName("teleop")
                .build());
        states.add(new ActorState.Builder()
                .setName("endGame")
                .build());
        states.add(new ActorState.Builder()
                .setName("post")
                .build());

        AcceptedEvent phaseChangeEvent =
                new AcceptedEvent.Builder()
                        .setEventName("phaseChangeEvent")
                        .setType("input")
                        .build();

        Set<AcceptedEvent> events = new HashSet<>();
        events.add(phaseChangeEvent);

        List<ActorTransition> transitions = new ArrayList<>();
        transitions.add(new ActorTransition.Builder()
                .setFrom(getByName(states, "pre").get())
                .setTo(getByName(states, "auto").get())
                .setTrigger(phaseChangeEvent)
                .build());
        transitions.add(new ActorTransition.Builder()
                .setFrom(getByName(states, "auto").get())
                .setTo(getByName(states, "teleop").get())
                .setTrigger(phaseChangeEvent)
                .build());
        transitions.add(new ActorTransition.Builder()
                .setFrom(getByName(states, "teleop").get())
                .setTo(getByName(states, "endGame").get())
                .setTrigger(phaseChangeEvent)
                .build());
        transitions.add(new ActorTransition.Builder()
                .setFrom(getByName(states, "endGame").get())
                .setTo(getByName(states, "post").get())
                .setTrigger(phaseChangeEvent)
                .build());

        ActorStateMachine fieldPhaseStateMachine = new ActorStateMachine.Builder()

                .setName("fieldPhase")
                .setEvents(events)
                .setInitialState("pre")
                .setStates(states)
                .setTransitions(transitions)
                .build();

        Set<ActorStateMachine> behaviors = new HashSet<ActorStateMachine>();
        behaviors.add(fieldPhaseStateMachine);

        Actor field = new Actor.Builder()
                .setName("Field")
                .setAlliance(Alliance.NEUTRAL)
                .setType("Field")
                .setBehaviors(behaviors)
                .build();

        MatchActor matchActor =
                new MatchActor.Builder()
                        .setActor(field)
                        .setCurrentState(new MatchState.Builder()
                                .setActorState(getByName(states, "pre").get())
                                .build())
                        .build();

        //this is the initial state
        assertEquals(getByName(states,"pre").get(),matchActor.getCurrentState().getActorState());

        // transition from pre to auto
        AcceptedEventResponse response = matchActor.accept(phaseChangeEvent);
        matchActor = response.getMatchActor();
        assertEquals(getByName(states,"auto").get(),matchActor.getCurrentState().getActorState());

        // transition from auto to teleop
        response = matchActor.accept(phaseChangeEvent);
        matchActor = response.getMatchActor();
        assertEquals(getByName(states,"teleop").get(),matchActor.getCurrentState().getActorState());

        // transition from teleop to endGame
        response = matchActor.accept(phaseChangeEvent);
        matchActor = response.getMatchActor();
        assertEquals(getByName(states,"endGame").get(),matchActor.getCurrentState().getActorState());

        // transition from endGame to post
        response = matchActor.accept(phaseChangeEvent);
        matchActor = response.getMatchActor();
        assertEquals(getByName(states,"post").get(),matchActor.getCurrentState().getActorState());

    }

    private Optional<ActorState> getByName(@Nonnull Set<ActorState> states,
                                           @Nonnull String name) {

        return states.stream()
                .filter(state -> name.equals(state.getName()))
                .findFirst();

    }
}
