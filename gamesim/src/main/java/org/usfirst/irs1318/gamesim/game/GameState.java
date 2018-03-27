package org.usfirst.irs1318.gamesim.game;

import fj.data.TreeMap;
import org.usfirst.irs1318.model.MatchActor;

import java.util.function.UnaryOperator;

/**
 * A game state is the state of a game at a single point in time.
 */
public final class GameState {
    private final EventQueue eventQueue;
    private final TreeMap<String, MatchActor> actors;

    public GameState(EventQueue eventQueue, TreeMap<String, MatchActor> actors) {
        this.eventQueue = eventQueue;
        this.actors = actors;
    }

    public EventQueue getEventQueue() {
        return eventQueue;
    }

    public GameState setEventQueue(EventQueue eventQueue) {
        return new GameState(eventQueue, actors);
    }

    public GameState mapEventQueue(UnaryOperator<EventQueue> fn) {
        return setEventQueue(fn.apply(eventQueue));
    }

    public TreeMap<String, MatchActor> getActors() {
        return actors;
    }

    public GameState setActors(TreeMap<String, MatchActor> actors) {
        return new GameState(eventQueue, actors);
    }

    public GameState mapActors(UnaryOperator<TreeMap<String, MatchActor>> fn) {
        return setActors(fn.apply(actors));
    }

    public GameState mapActor(String name, UnaryOperator<MatchActor> fn) {
        return mapActors(actors -> actors.update(name, fn::apply, null));
    }
}
