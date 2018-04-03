package org.usfirst.irs1318.gamesim;

import fj.data.Stream;
import org.jooq.lambda.tuple.Tuple2;

public final class GameEngine {
    public Stream<Tuple2<Event, GameState>> run(GameState gameState) {
        if (gameState.getEventQueue().isEmpty()) {
            return Stream.nil();
        } else {
            Tuple2<Event, EventQueue> pop = gameState.getEventQueue().pop();
            Event event = pop.v1;
            EventQueue newQueue = pop.v2;
            return Stream.cons(
                    new Tuple2<>(event, gameState),
                    () -> run(event.apply(gameState.setEventQueue(newQueue)))
            );
        }
    }
}
