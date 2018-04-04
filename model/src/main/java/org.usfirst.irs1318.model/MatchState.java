package org.usfirst.irs1318.model;

import java.util.Objects;

public class MatchState {
    private final ActorState actorState;

    private MatchState(ActorState actorState) {
        this.actorState = actorState;
    }

    public ActorState getActorState() {
        return actorState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchState that = (MatchState) o;
        return Objects.equals(actorState, that.actorState);
    }

    @Override
    public int hashCode() {

        return Objects.hash(actorState);
    }

    @Override
    public String toString() {
        return "MatchState{" +
                "actorState=" + actorState +
                '}';
    }

    public static class Builder {
        private ActorState actorState;

        public Builder setActorState(ActorState actorState) {
            this.actorState = actorState;
            return this;
        }
        public MatchState build() {
            return new MatchState(actorState);
        }
    }

}
