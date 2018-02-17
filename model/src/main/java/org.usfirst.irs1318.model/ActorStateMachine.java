package org.usfirst.irs1318.model;

import java.util.*;

public class ActorStateMachine {
    private final String name;
    private final Set<AcceptedEvent> events;
    private final Set<ActorStateVariable> data;
    private final List<DataUpdate> dataUpdates;
    private final String initialState;
    private final Set<ActorState> states;
    private final List<ActorTransition> transitions;

    public ActorStateMachine(String name,
                             Set<AcceptedEvent> events,
                             Set<ActorStateVariable> data,
                             List<DataUpdate> dataUpdates,
                             String initialState,
                             Set<ActorState> states,
                             List<ActorTransition> transitions) {
        this.name = name;
        this.events = events;
        this.data = data;
        this.dataUpdates = dataUpdates;
        this.initialState = initialState;
        this.states = states;
        this.transitions = transitions;
    }

    public String getName() {
        return name;
    }

    public Set<AcceptedEvent> getEvents() {
        return events;
    }

    public Set<ActorStateVariable> getData() {
        return data;
    }

    public List<DataUpdate> getDataUpdates() {
        return dataUpdates;
    }

    public String getInitialState() {
        return initialState;
    }

    public Set<ActorState> getStates() {
        return states;
    }

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

    public static class Builder {
        private String name;
        private Set<AcceptedEvent> events;
        private Set<ActorStateVariable> data;
        private List<DataUpdate> dataUpdates;
        private String initialState;
        private Set<ActorState> states;
        private List<ActorTransition> transitions;

        public Builder(){
            events = new HashSet<>();
            data = new HashSet<>();
            states = new HashSet<>();
            dataUpdates = new ArrayList<>();
            transitions = new ArrayList<>();
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEvents(Set<AcceptedEvent> events) {
            this.events = events;
            return this;
        }

        public Builder setData(Set<ActorStateVariable> data) {
            this.data = data;
            return this;
        }

        public Builder setDataUpdates(List<DataUpdate> dataUpdates) {
            this.dataUpdates = dataUpdates;
            return this;
        }

        public Builder setInitialState(String initialState) {
            this.initialState = initialState;
            return this;
        }

        public Builder setStates(Set<ActorState> states) {
            this.states = states;
            return this;
        }

        public Builder setTransitions(List<ActorTransition> transitions) {
            this.transitions = transitions;
            return this;
        }

        public ActorStateMachine build(){
            return new ActorStateMachine(name,
                    events,
                    data,
                    dataUpdates,
                    initialState,
                    states,
                    transitions);
        }
    }
}
