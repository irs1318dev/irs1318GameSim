package org.usfirst.irs1318.model;

import java.util.Objects;

public class AllianceActor {
    private final String name;
    private final Actor actor;
    // add runtime details - place holder for StateVariables and current StateToken

    private AllianceActor(String name, Actor actor) {
        this.name = name;
        this.actor = actor;
    }

    public String getName() {
        return name;
    }

    public Actor getActor() {
        return actor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllianceActor that = (AllianceActor) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(actor, that.actor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, actor);
    }

    @Override
    public String toString() {
        return "AllianceActor{" +
                "name='" + name + '\'' +
                ", actor=" + actor +
                '}';
    }

    public class Builder {
        private String name;
        private Actor actor;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setActor(Actor actor) {
            this.actor = actor;
            return this;
        }

        public AllianceActor build() {
            return new AllianceActor(name, actor);
        }
    }
}
