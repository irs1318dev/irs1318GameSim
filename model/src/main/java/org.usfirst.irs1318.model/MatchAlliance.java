package org.usfirst.irs1318.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MatchAlliance {

    private final Map<String, MatchRobot> robots;
    private final Map<String, MatchPerson> people;

    private MatchAlliance(Map<String, MatchRobot> robots, Map<String, MatchPerson> people) {
        this.robots = robots;
        this.people = people;
    }

    public Map<String, MatchRobot> getRobots() {
        return robots;
    }

    public Map<String, MatchPerson> getPeople() {
        return people;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchAlliance that = (MatchAlliance) o;
        return Objects.equals(robots, that.robots) &&
                Objects.equals(people, that.people);
    }

    @Override
    public int hashCode() {

        return Objects.hash(robots, people);
    }

    @Override
    public String toString() {
        return "MatchAlliance{" +
                "robots=" + robots +
                ", people=" + people +
                '}';
    }

    public static class Builder {

        private Map<String,MatchRobot> robots = new HashMap<>();
        private Map<String,MatchPerson> people = new HashMap<>();

        public Builder setRobots(Map<String, MatchRobot> robots) {
            this.robots = robots;
            return this;
        }

        public Builder setPeople(Map<String, MatchPerson> people) {
            this.people = people;
            return this;
        }

        public MatchAlliance build() {
            return new MatchAlliance(robots, people);
        }
    }
}
