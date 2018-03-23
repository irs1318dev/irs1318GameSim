package org.usfirst.irs1318.model;

import java.util.Objects;

/**
 * The match actor provides state tracking for match objects that are shared between alliances such as field 
 */
public class MatchActor {
    private final Actor actor;
    private final MatchState currentState;

    private MatchActor(Actor actor, MatchState currentState) {
        this.actor = actor;
        this.currentState = currentState;
    }
    
    public Actor getActor() {
        return actor;
    }

    public MatchState getCurrentState() {
        return currentState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchActor that = (MatchActor) o;
        return Objects.equals(actor, that.actor) &&
                Objects.equals(currentState, that.currentState);
    }

    @Override
    public int hashCode() {

        return Objects.hash(actor, currentState);
    }

    @Override
    public String toString() {
        return "MatchActor{" +
                "actor=" + actor +
                ", currentState=" + currentState +
                '}';
    }

    public AcceptedEventResponse accept(AcceptedEvent acceptedEvent) {
       return actor.accept(this,acceptedEvent);
    }

    public static class Builder {
        private Actor actor;
        private MatchState currentState;

        public Builder setActor(Actor actor) {
            this.actor = actor;
            return this;
        }

        public Builder setCurrentState(MatchState currentState) {
            this.currentState = currentState;
            return this;
        }
        
        public MatchActor build(){
            return new MatchActor(actor, currentState);
        }
    }
}
