package org.usfirst.irs1318.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Objects;

@JsonDeserialize(builder = ActorState.Builder.class)
public class ActorState {
    private final String name;
    private final String onEntry;
    private final String onExit;

    private ActorState(String name, String onEntry, String onExit) {
        this.name = name;
        this.onEntry = onEntry;
        this.onExit = onExit;
    }

    @JsonProperty(value = "name")
    public String getName() {
        return name;
    }

    @JsonProperty(value = "onEntry")
    public String getOnEntry() {
        return onEntry;
    }

    @JsonProperty(value = "onExit")
    public String getOnExit() {
        return onExit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorState that = (ActorState) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(onEntry, that.onEntry) &&
                Objects.equals(onExit, that.onExit);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, onEntry, onExit);
    }

    @Override
    public String toString() {
        return "ActorState{" +
                "name='" + name + '\'' +
                ", onEntry='" + onEntry + '\'' +
                ", onExit='" + onExit + '\'' +
                '}';
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String name;
        private String onEntry;
        private String onExit;

        public Builder copyOf(ActorState actorState) {
            this.name = actorState.getName();
            this.onEntry = actorState.getOnEntry();
            this.onExit = actorState.getOnExit();
            return this;
        }

        @JsonProperty(value = "name")
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        @JsonProperty(value = "onEntry")
        public Builder setOnEntry(String onEntry) {
            this.onEntry = onEntry;
            return this;
        }

        @JsonProperty(value = "onExit")
        public Builder setOnExit(String onExit) {
            this.onExit = onExit;
            return this;
        }

        public ActorState build() {
            return new ActorState(name, onEntry, onExit);
        }
    }


}
