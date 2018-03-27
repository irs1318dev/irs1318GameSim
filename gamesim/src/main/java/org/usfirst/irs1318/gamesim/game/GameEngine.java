package org.usfirst.irs1318.gamesim.game;

import org.jooq.lambda.tuple.Tuple2;

public final class GameEngine {
    public GameState run(GameState gameState) {
        Tuple2<Event, EventQueue> pop = gameState.getEventQueue().pop();
        Event event = pop.v1;
        EventQueue newQueue = pop.v2;
        return event.apply(gameState.setEventQueue(newQueue));
    }
}
