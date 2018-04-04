package org.usfirst.irs1318.gamesim;

import fj.data.Stream;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.Assert;
import org.junit.Test;
import org.usfirst.irs1318.model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class FieldTest {
    @Test
    public void fieldTest() {
        ActorState pre = new ActorState.Builder().setName("pre").build();
        ActorState auto = new ActorState.Builder().setName("auto").build();
        ActorState teleop = new ActorState.Builder().setName("teleop").build();
        ActorState endGame = new ActorState.Builder().setName("endGame").build();
        ActorState post = new ActorState.Builder().setName("post").build();

        Set<ActorState> states = new HashSet<>();
        states.add(pre);
        states.add(auto);
        states.add(teleop);
        states.add(endGame);
        states.add(post);

        AcceptedEvent phaseChangeEvent =
                new AcceptedEvent.Builder()
                        .setEventName("phaseChangeEvent")
                        .setType("input")
                        .build();

        List<ActorTransition> transitions = new ArrayList<>();
        transitions.add(new ActorTransition.Builder()
                .setFrom(pre)
                .setTo(auto)
                .setTrigger(phaseChangeEvent)
                .build());
        transitions.add(new ActorTransition.Builder()
                .setFrom(auto)
                .setTo(teleop)
                .setTrigger(phaseChangeEvent)
                .build());
        transitions.add(new ActorTransition.Builder()
                .setFrom(teleop)
                .setTo(endGame)
                .setTrigger(phaseChangeEvent)
                .build());
        transitions.add(new ActorTransition.Builder()
                .setFrom(endGame)
                .setTo(post)
                .setTrigger(phaseChangeEvent)
                .build());

        ActorStateMachine fieldPhaseStateMachine = new ActorStateMachine.Builder()
                .setName("fieldPhase")
                .setInitialState("pre")
                .setStates(states)
                .setTransitions(transitions)
                .build();

        Set<ActorStateMachine> behaviors = new HashSet<>();
        behaviors.add(fieldPhaseStateMachine);

        Actor fieldActor = new Actor.Builder()
                .setName("Field")
                .setType("Field")
                .setAlliance(Alliance.NEUTRAL)
                .setBehaviors(behaviors)
                .build();

        MatchActor fieldMatchActor = new MatchActor.Builder()
                .setActor(fieldActor)
                .setCurrentState(new MatchState.Builder()
                        .setActorState(pre)
                        .build())
                .build();

        GameState gameState = new GameState()
                .addActor(fieldMatchActor)
                .addEvent(new NamedEvent(new Time(0), phaseChangeEvent.getEventName()))
                .addEvent(new NamedEvent(new Time(0), phaseChangeEvent.getEventName()))
                .addEvent(new NamedEvent(new Time(15), phaseChangeEvent.getEventName()))
                .addEvent(new NamedEvent(new Time(215), phaseChangeEvent.getEventName()))
                .addEvent(new NamedEvent(new Time(245), phaseChangeEvent.getEventName()));

        Stream<Tuple2<Event, GameState>> log = new GameEngine().run(gameState);

        log.forEach(x -> System.out.println(x.v2.getActors().get("Field").some().getCurrentState().getActorState().getName()));

        Assert.assertEquals("pre", getEventName(log, 0));
        Assert.assertEquals("auto", getEventName(log, 1));
        Assert.assertEquals("teleop", getEventName(log, 2));
        Assert.assertEquals("endGame", getEventName(log, 3));
        Assert.assertEquals("post", getEventName(log, 4));
    }

    private String getEventName(Stream<Tuple2<Event, GameState>> log, int i) {
        return log.index(i).v2.getActors().get("Field").some().getCurrentState().getActorState().getName();
    }
}
