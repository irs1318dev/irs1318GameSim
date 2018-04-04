package org.usfirst.irs1318.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Objects;

@JsonDeserialize(builder = ActorTransition.Builder.class)
public class ActorTransition {
    private final ActorState from;
    private final AcceptedEvent trigger;
    private final String guard;
    private final ActorState to;

    private ActorTransition(ActorState from,
                           AcceptedEvent trigger,
                           String guard,
                           ActorState to) {
        this.from = from;
        this.trigger = trigger;
        this.guard = guard;
        this.to = to;
    }

    @JsonProperty(value = "from")
    public ActorState getFrom() {
        return from;
    }

    @JsonProperty(value = "trigger")
    public AcceptedEvent getTrigger() {
        return trigger;
    }

    @JsonProperty(value = "guard")
    public String getGuard() {
        return guard;
    }

    @JsonProperty(value = "to")
    public ActorState getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorTransition that = (ActorTransition) o;
        return Objects.equals(from, that.from) &&
                Objects.equals(trigger, that.trigger) &&
                Objects.equals(guard, that.guard) &&
                Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {

        return Objects.hash(from, trigger, guard, to);
    }

    @Override
    public String toString() {
        return "ActorTransition{" +
                "from=" + from +
                ", trigger=" + trigger +
                ", guard=" + guard +
                ", to=" + to +
                '}';
    }

    @JsonPOJOBuilder
    public static class Builder {
        private ActorState from;
        private AcceptedEvent trigger;
        private String guard;
        private ActorState to;

        public Builder copyOf(ActorTransition actorTransition) {
            this.from = actorTransition.getFrom();
            this.trigger = actorTransition.getTrigger();
            this.guard = actorTransition.getGuard();
            this.to = actorTransition.getTo();
            return this;


        }

        @JsonProperty(value = "from")
        public Builder setFrom(ActorState from) {
            this.from = from;
            return this;
        }

        @JsonProperty(value = "trigger")
        public Builder setTrigger(AcceptedEvent trigger) {
            this.trigger = trigger;
            return this;
        }

        @JsonProperty(value = "guard")
        public Builder setGuard(String guard) {
            this.guard = guard;
            return this;
        }

        @JsonProperty(value = "to")
        public Builder setTo(ActorState to) {
            this.to = to;
            return this;
        }
        public ActorTransition build(){
            return new ActorTransition(from, trigger, guard, to);
        }

    }
}

