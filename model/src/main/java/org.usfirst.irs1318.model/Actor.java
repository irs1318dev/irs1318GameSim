package org.usfirst.irs1318.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.ImmutableSet;

@JsonDeserialize(builder = Actor.Builder.class)
public class Actor {
    private final String name;
    private final ImmutableSet<ListensTo> listensTo;
    private final Alliance alliance;
    private final String type;
    private final ImmutableSet<ActorStateMachine> behaviors;

    private Actor(String name, ImmutableSet<ListensTo> listensTo, Alliance alliance, String type, ImmutableSet<ActorStateMachine> behaviors) {
        this.name = name;
        this.listensTo = listensTo; //Copy into immutable set
        this.alliance = alliance;
        this.type = type;
        this.behaviors = behaviors;
    }

    public String getName() {
        return name;
    }

    public Alliance getAlliance() {
        return alliance;
    }

    public String getType() {
        return type;
    }

    public ImmutableSet<ListensTo> getListensTo() {
        return listensTo;
    }

    public ImmutableSet<ActorStateMachine> getBehaviors() {
        return behaviors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(name, actor.name) &&
                Objects.equals(listensTo, actor.listensTo) &&
                alliance == actor.alliance &&
                Objects.equals(type, actor.type) &&
                Objects.equals(behaviors, actor.behaviors);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, listensTo, alliance, type, behaviors);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", listensTo=" + listensTo +
                ", alliance=" + alliance +
                ", type='" + type +
                ", behaviors='" + behaviors + '\'' +
                '}';
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String name;
        private Set<ListensTo> listensTo = new HashSet<>();
        private Alliance alliance;
        private String type;
        private Set<ActorStateMachine> behaviors;

        @JsonProperty(value = "name")
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        @JsonProperty(value = "listensTo")
        public Builder setListensTo(ImmutableSet<ListensTo> listensTo) {
            this.listensTo = listensTo;
            return this;
        }

        @JsonProperty(value = "alliance")
        public Builder setAlliance(Alliance alliance) {
            this.alliance = alliance;
            return this;
        }

        @JsonProperty(value = "type")
        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setBehaviors(Set<ActorStateMachine> behaviors) {
            this.behaviors = behaviors;
            return this;
        }

        public Actor build() {
            return new Actor(name, ImmutableSet.copyOf(listensTo), alliance, type, ImmutableSet.copyOf(behaviors));
        }
    }
}
