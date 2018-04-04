package org.usfirst.irs1318.gamesim;

import fj.Equal;
import fj.Monoid;
import fj.data.PriorityQueue;
import org.jooq.lambda.tuple.Tuple2;
import org.usfirst.irs1318.model.Time;

import java.util.Objects;

/**
 * A queue of events, sorted by time.
 */
public final class EventQueue {
    private static final Monoid<Time> timeMonoid = Monoid.monoid((x, y) -> x.getX() < y.getX() ? x : y, new Time(0));

    private final PriorityQueue<Time, Event> events;

    public EventQueue() {
        //noinspection RedundantTypeArguments
        this(PriorityQueue.empty(timeMonoid, Equal.anyEqual()));
    }

    public EventQueue(PriorityQueue<Time, Event> events) {
        this.events = events;
    }

    public boolean isEmpty() {
        return events.isEmpty();
    }

    public EventQueue add(Event event) {
        return new EventQueue(events.enqueue(event.getTime(), event));
    }

    public Event peek() {
        return events.top().some()._2();
    }

    public Tuple2<Event, EventQueue> pop() {
        Event min = events.top().some()._2();
        return new Tuple2<>(min, new EventQueue(events.dequeue()));
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
