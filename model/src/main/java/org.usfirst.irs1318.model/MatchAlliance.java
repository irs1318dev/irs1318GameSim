package org.usfirst.irs1318.model;

import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MatchAlliance {

    private final ImmutableMap<String, MatchRobot> robots; //string = position
    private final ImmutableMap<String, MatchPerson> people; // string = role
    private final ImmutableMap <String, AllianceActor> scoreKeepers; // string = name of keeper
    private final ImmutableMap<String, AllianceActor> foulTrackers; // string = name of tracker
    private final ImmutableMap<String, AllianceActor> zones; // string = name of zone
    private final ImmutableMap <String, AllianceActor> targets; // string = name of target

    private MatchAlliance(ImmutableMap<String, MatchRobot> robots,
                         ImmutableMap<String, MatchPerson> people,
                         ImmutableMap<String, AllianceActor> scoreKeepers,
                         ImmutableMap<String, AllianceActor> foulTrackers,
                         ImmutableMap<String, AllianceActor> zones,
                         ImmutableMap<String, AllianceActor> targets) {
        this.robots = robots;
        this.people = people;
        this.scoreKeepers = scoreKeepers;
        this.foulTrackers = foulTrackers;
        this.zones = zones;
        this.targets = targets;
    }

    public ImmutableMap<String, MatchRobot> getRobots() {
        return robots;
    }

    public ImmutableMap<String, MatchPerson> getPeople() {
        return people;
    }

    public ImmutableMap<String, AllianceActor> getScoreKeepers() {
        return scoreKeepers;
    }

    public ImmutableMap<String, AllianceActor> getFoulTrackers() {
        return foulTrackers;
    }

    public ImmutableMap<String, AllianceActor> getZones() {
        return zones;
    }

    public ImmutableMap<String, AllianceActor> getTargets() {
        return targets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchAlliance that = (MatchAlliance) o;
        return Objects.equals(robots, that.robots) &&
                Objects.equals(people, that.people) &&
                Objects.equals(scoreKeepers, that.scoreKeepers) &&
                Objects.equals(foulTrackers, that.foulTrackers) &&
                Objects.equals(zones, that.zones) &&
                Objects.equals(targets, that.targets);
    }

    @Override
    public int hashCode() {

        return Objects.hash(robots, people, scoreKeepers, foulTrackers, zones, targets);
    }

    @Override
    public String toString() {
        return "MatchAlliance{" +
                "robots=" + robots +
                ", people=" + people +
                ", scoreKeepers=" + scoreKeepers +
                ", foulTrackers=" + foulTrackers +
                ", zones=" + zones +
                ", targets=" + targets +
                '}';
    }

    public static class Builder {

        private Map<String, MatchRobot> robots;
        private Map<String, MatchPerson> people;
        private Map <String, AllianceActor> scoreKeepers; // string = name of keeper
        private Map<String, AllianceActor> foulTrackers; // string = name of tracker
        private Map<String, AllianceActor> zones; // string = name of zone
        private Map <String, AllianceActor> targets; // string = name of target

        public Builder() {
            robots = new HashMap<>();
            people = new HashMap<>();
        }

        public Builder setRobots(Map<String, MatchRobot> robots) {
            this.robots = robots;
            return this;
        }

        public Builder setPeople(Map<String, MatchPerson> people) {
            this.people = people;
            return this;
        }

        public Builder setScoreKeepers(Map<String, AllianceActor> scoreKeepers) {
            this.scoreKeepers = scoreKeepers;
            return this;
        }

        public Builder setFoulTrackers(Map<String, AllianceActor> foulTrackers) {
            this.foulTrackers = foulTrackers;
            return this;
        }

        public Builder setZones(Map<String, AllianceActor> zones) {
            this.zones = zones;
            return this;
        }

        public Builder setTargets(Map<String, AllianceActor> targets) {
            this.targets = targets;
            return this;
        }

        public MatchAlliance build() {
            return new MatchAlliance(ImmutableMap.copyOf(robots), ImmutableMap.copyOf(people), ImmutableMap.copyOf(scoreKeepers), ImmutableMap.copyOf(foulTrackers), ImmutableMap.copyOf(zones), ImmutableMap.copyOf(targets));
        }
    }
}
