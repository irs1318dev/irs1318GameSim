package org.usfirst.irs1318.model;

import com.google.common.collect.ImmutableSet;
import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AcceptedEventResponse {
    private final MatchActor matchActor;
    private final ImmutableSet<EmittedEvent> emittedEvents;

    private AcceptedEventResponse(MatchActor matchActor, ImmutableSet<EmittedEvent> emittedEvents) {
        this.matchActor = matchActor;
        this.emittedEvents = emittedEvents;
    }

    public MatchActor getMatchActor() {
        return matchActor;
    }

    public ImmutableSet<EmittedEvent> getEmittedEvents() {
        return emittedEvents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcceptedEventResponse that = (AcceptedEventResponse) o;
        return Objects.equals(matchActor, that.matchActor) &&
                Objects.equals(emittedEvents, that.emittedEvents);
    }

    @Override
    public int hashCode() {

        return Objects.hash(matchActor, emittedEvents);
    }

    @Override
    public String toString() {
        return "AcceptedEventResponse{" +
                "matchActor=" + matchActor +
                ", emittedEvents=" + emittedEvents +
                '}';
    }

    public static class Builder {
        private MatchActor matchActor;
        private Set<EmittedEvent> emittedEvents = new HashSet<>();

        public Builder setMatchActor(MatchActor matchActor) {
            this.matchActor = matchActor;
            return this;
        }

        public Builder setEmittedEvents(Set<EmittedEvent> emittedEvents) {
            this.emittedEvents = emittedEvents;
            return this;
        }

        public AcceptedEventResponse build() {
            return new AcceptedEventResponse(matchActor, ImmutableSet.copyOf(emittedEvents));
        }
    }
}
