package org.usfirst.irs1318.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Objects;

@JsonDeserialize(builder = ActorStateVariable.Builder.class)
public class ActorStateVariable {
    private final String name;
    private final StateVariableType type;

    private ActorStateVariable(String name, StateVariableType type) {
        this.name = name;
        this.type = type;
    }

    @JsonProperty(value = "name")
    public String getName() {
        return name;
    }

    @JsonProperty(value = "type")
    public StateVariableType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorStateVariable that = (ActorStateVariable) o;
        return Objects.equals(name, that.name) &&
                type == that.type;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, type);
    }

    @Override
    public String toString() {
        return "ActorStateVariable{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String name;
        private StateVariableType type;

        public Builder copyOf(ActorStateVariable actorStateVariable){
            this.name = actorStateVariable.getName();
            this.type = actorStateVariable.getType();
            return this;
        }

        @JsonProperty(value = "name")
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        @JsonProperty(value = "type")
        public Builder setType(StateVariableType type) {
            this.type = type;
            return this;
        }
        public ActorStateVariable build() {
            return new ActorStateVariable(name, type);
        }
    }
}

