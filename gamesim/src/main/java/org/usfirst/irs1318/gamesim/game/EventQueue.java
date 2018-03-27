package org.usfirst.irs1318.gamesim.game;

import fj.Ord;
import fj.data.Set;
import org.jooq.lambda.tuple.Tuple2;

import java.util.Objects;

/**
 * A queue of events, sorted by time.
 */
public final class EventQueue {
    private final Set<Event> events;

    public EventQueue(java.util.Set<Event> events) {
        this(Set.iterableSet(Ord.comparableOrd(), events));
    }

    public EventQueue(Set<Event> events) {
        this.events = events;
    }

    public boolean isEmpty() {
        return events.isEmpty();
    }

    public EventQueue add(Event event) {
        return new EventQueue(events.insert(event));
    }

    public Event peek() {
        return events.min().some();
    }

    public Tuple2<Event, EventQueue> pop() {
        Event min = events.min().some();
        return new Tuple2<>(min, new EventQueue(events.delete(min)));
    }

    @Override
    public String toString() {
        return events.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventQueue that = (EventQueue) o;
        return Objects.equals(events, that.events);
    }

    @Override
    public int hashCode() {
        return events.hashCode();
    }
}
