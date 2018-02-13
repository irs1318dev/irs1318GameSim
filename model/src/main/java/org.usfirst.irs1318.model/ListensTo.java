package org.usfirst.irs1318.model;

import java.util.ArrayList;
import java.util.List;

public class ListensTo {
    private final String actorName;
    private final List<EmittedEvent> emittedEvents;

    private ListensTo(String actorName, List<EmittedEvent> emittedEvents){
        this.emittedEvents = emittedEvents;
        this.actorName = actorName;
    }

    public static class Builder {
        private String actorName;
        private List<EmittedEvent> emittedEvents;

        public Builder(){
            emittedEvents = new ArrayList<>();
        }
        public Builder setActorName(String actorName){
            this.actorName = actorName;
            return this;
        }
        public Builder addEmittedEvent(EmittedEvent emittedEvent) {
            emittedEvents.add(emittedEvent);
            return this;
        }
        public ListensTo build(){
            return new ListensTo(actorName, emittedEvents);
        }
    }
}
