package org.usfirst.irs1318.gamesim.game;

import org.jooq.lambda.Seq;
import org.usfirst.irs1318.gamesim.units.Time;
import org.usfirst.irs1318.model.*;

import java.util.Optional;

public final class ActorEvent implements Event {
    private final Time time;
    private final String actorName;

    public ActorEvent(Time time, String actorName) {
        this.time = time;
        this.actorName = actorName;
    }

    @Override
    public Time getTime() {
        return time;
    }

    @Override
    public GameState apply(GameState gameState) {
        return gameState.mapActor(actorName, matchActor -> {
            Actor actor = matchActor.getActor();
            MatchState newState = Seq.seq(actor.getBehaviors().stream())
                    .foldRight(matchActor.getCurrentState(), this::run);
            return new MatchActor.Builder()
                    .setActor(actor)
                    .setCurrentState(newState)
                    .build();
        });
    }

    private MatchState run(ActorStateMachine stateMachine, MatchState state) {
        return getTransition(stateMachine, state.getActorState())
                .map(transition -> new MatchState.Builder()
                        .setActorState(transition.getTo())
                        .build())
                .orElse(state);
    }

    private Optional<ActorTransition> getTransition(ActorStateMachine stateMachine, ActorState state) {
        return stateMachine.getTransitions()
                .stream()
                .filter(transition -> state.equals(transition.getFrom()))
                .findFirst();
    }
}
