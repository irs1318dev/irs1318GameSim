package org.usfirst.irs1318.model;

import java.util.Objects;

public class ActorState {
    private final String name;
    private final String onEntry;
    private final String onExit;

    private ActorState(String name, String onEntry, String onExit) {
        this.name = name;
        this.onEntry = onEntry;
        this.onExit = onExit;
    }

    public String getName() {
        return name;
    }

    public String getOnEntry() {
        return onEntry;
    }

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

    public static class Builder {
        private String name;
        private String onEntry;
        private String onExit;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setOnEntry(String onEntry) {
            this.onEntry = onEntry;
            return this;
        }

        public Builder setOnExit(String onExit) {
            this.onExit = onExit;
            return this;
        }

        public ActorState build(){
            return new ActorState(name, onEntry, onExit);
        }
    }


}
