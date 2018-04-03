package org.usfirst.irs1318.gamesim;

import org.usfirst.irs1318.gamesim.units.Time;

import javax.annotation.Nonnull;
import java.util.function.UnaryOperator;

/**
 * An event is a change in a {@link GameState} at a time. It is represented as a
 * function from an old game state to a new game state.
 */
public interface Event extends Comparable<Event>, UnaryOperator<GameState> {
    Time getTime();

    @Override
    default int compareTo(@Nonnull Event event) {
        return Integer.compare(this.getTime().getX(), event.getTime().getX());
    }
}
