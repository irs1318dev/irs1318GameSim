package org.usfirst.irs1318.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = ListensTo.Builder.class)
public class ListensTo {
    private final String actorName;
    private final List<EmittedEvent> emittedEvents;

    private ListensTo(String actorName, List<EmittedEvent> emittedEvents){
        this.emittedEvents = emittedEvents;
        this.actorName = actorName;
    }
    @JsonProperty(value = "actorName")
    public String getActorName(){
        return actorName;
    }

    @JsonProperty(value = "emmitedEvents")
    public List<EmittedEvent> getEmittedEvents(){
        return emittedEvents;
    }

    @Override
    public String toString() {
        return "ListensTo{" +
                "actorName='" + actorName + '\'' +
                ", emittedEvents=" + emittedEvents +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListensTo listensTo = (ListensTo) o;
        return Objects.equals(actorName, listensTo.actorName) &&
                Objects.equals(emittedEvents, listensTo.emittedEvents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorName, emittedEvents);
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
    public static class Builder {
        private String actorName;
        private List<EmittedEvent> emittedEvents;


        public Builder(){
            emittedEvents = new ArrayList<>();
        }
        @JsonProperty(value = "actorName")
        public Builder setActorName(String actorName){
            this.actorName = actorName;
            return this;
        }

        @JsonProperty(value = "emmitedEvents")
        public Builder setEmittedEvent(List<EmittedEvent> emittedEvents){
            this.emittedEvents = emittedEvents;
            return this;
        }

        public ListensTo build(){
            return new ListensTo(actorName, emittedEvents);
        }
    }
}
