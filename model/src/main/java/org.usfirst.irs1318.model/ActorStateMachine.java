package org.usfirst.irs1318.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.*;

@JsonDeserialize(builder = ActorStateMachine.Builder.class)
public class ActorStateMachine {
    private final String name;
    private final ImmutableSet<AcceptedEvent> events;
    private final ImmutableSet<ActorStateVariable> data;
    private final ImmutableList<DataUpdate> dataUpdates;
    private final String initialState;
    private final ImmutableSet<ActorState> states;
    private final ImmutableList<ActorTransition> transitions;

    public ActorStateMachine(String name,
                             ImmutableSet<AcceptedEvent> events,
                             ImmutableSet<ActorStateVariable> data,
                             ImmutableList<DataUpdate> dataUpdates,
                             String initialState,
                             ImmutableSet<ActorState> states,
                             ImmutableList<ActorTransition> transitions) {
        this.name = name;
        this.events = events;
        this.data = data;
        this.dataUpdates = dataUpdates;
        this.initialState = initialState;
        this.states = states;
        this.transitions = transitions;
    }

    @JsonProperty(value = "name")
    public String getName() {
        return name;
    }

    @JsonProperty(value = "events")
    public Set<AcceptedEvent> getEvents() {
        return events;
    }

    @JsonProperty(value = "data")
    public Set<ActorStateVariable> getData() {
        return data;
    }

    @JsonProperty(value = "dataUpdates")
    public List<DataUpdate> getDataUpdates() {
        return dataUpdates;
    }

    @JsonProperty(value = "initialState")
    public String getInitialState() {
        return initialState;
    }

    @JsonProperty(value = "states")
    public Set<ActorState> getStates() {
        return states;
    }

    @JsonProperty(value = "transitions")
    public List<ActorTransition> getTransitions() {
        return transitions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorStateMachine that = (ActorStateMachine) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(events, that.events) &&
                Objects.equals(data, that.data) &&
                Objects.equals(dataUpdates, that.dataUpdates) &&
                Objects.equals(initialState, that.initialState) &&
                Objects.equals(states, that.states) &&
                Objects.equals(transitions, that.transitions);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, events, data, dataUpdates, initialState, states, transitions);
    }

    @Override
    public String toString() {
        return "ActorStateMachine{" +
                "name='" + name + '\'' +
                ", events=" + events +
                ", data=" + data +
                ", dataUpdates=" + dataUpdates +
                ", initialState='" + initialState + '\'' +
                ", states=" + states +
                ", transitions=" + transitions +
                '}';
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String name;
        private Set<AcceptedEvent> events = new HashSet<>();
        private Set<ActorStateVariable> data = new HashSet<>();
        private List<DataUpdate> dataUpdates = new ArrayList<>();
        private String initialState;
        private Set<ActorState> states = new HashSet<>();
        private List<ActorTransition> transitions = new ArrayList<>();

        @JsonProperty(value = "name")
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        @JsonProperty(value = "events")
        public Builder setEvents(Set<AcceptedEvent> events) {
            this.events = events;
            return this;
        }

        @JsonProperty(value = "data")
        public Builder setData(Set<ActorStateVariable> data) {
            this.data = data;
            return this;
        }

        @JsonProperty(value = "dataUpdates")
        public Builder setDataUpdates(List<DataUpdate> dataUpdates) {
            this.dataUpdates = dataUpdates;
            return this;
        }

        @JsonProperty(value = "initialState")
        public Builder setInitialState(String initialState) {
            this.initialState = initialState;
            return this;
        }

        @JsonProperty(value = "states")
        public Builder setStates(Set<ActorState> states) {
            this.states = states;
            return this;
        }

        @JsonProperty(value = "transitions")
        public Builder setTransitions(List<ActorTransition> transitions) {
            this.transitions = transitions;
            return this;
        }

        public ActorStateMachine build() {
            return new ActorStateMachine(name,
                    ImmutableSet.copyOf(events),
                    ImmutableSet.copyOf(data),
                    ImmutableList.copyOf(dataUpdates),
                    initialState,
                    ImmutableSet.copyOf(states),
                    ImmutableList.copyOf(transitions));
        }
    }
}
