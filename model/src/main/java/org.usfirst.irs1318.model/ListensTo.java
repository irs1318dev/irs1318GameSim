package org.usfirst.irs1318.model;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class ListensTo {
    private final String actorName;
    private final ImmutableList<EmittedEvent> emittedEvents;

    private ListensTo(String actorName, ImmutableList<EmittedEvent> emittedEvents){
        this.emittedEvents = emittedEvents;
        this.actorName = actorName;
    }

    public static class Builder {
        private String actorName;
        private List<EmittedEvent> emittedEvents = new ArrayList<>();

        public Builder setActorName(String actorName){
            this.actorName = actorName;
            return this;
        }
        public Builder addEmittedEvent(EmittedEvent emittedEvent) {
            emittedEvents.add(emittedEvent);
            return this;
        }
        public ListensTo build(){
            return new ListensTo(actorName, ImmutableList.copyOf(emittedEvents));
        }
    }
}
