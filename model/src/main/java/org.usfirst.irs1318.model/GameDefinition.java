package org.usfirst.irs1318.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.*;

@JsonDeserialize(builder = GameDefinition.Builder.class)
public class GameDefinition {
    private final ImmutableMap<String, Task> personTasks;
    private final ImmutableMap<String, Task> robotTasks;
    private final ImmutableMap<String, Actor> scoreKeepers;
    private final ImmutableMap<String, Actor> foulTrackers;
    private final ImmutableMap<String, Actor> playBook;
    private final ImmutableSet<GameTerm> gameTerms;

    private GameDefinition(ImmutableMap<String, Task> personTasks,
                          ImmutableMap<String, Task> robotTasks,
                          ImmutableMap<String, Actor> scoreKeepers,
                          ImmutableMap<String, Actor> foulTrackers,
                          ImmutableMap<String, Actor> playBook,
                          ImmutableSet<GameTerm> gameTerms) {
        this.personTasks = personTasks;
        this.robotTasks = robotTasks;
        this.scoreKeepers = scoreKeepers;
        this.foulTrackers = foulTrackers;
        this.playBook = playBook;
        this.gameTerms = gameTerms;
    }

    @JsonProperty(value = "personTasks")
    public ImmutableMap<String, Task> getPersonTasks() {
        return personTasks;
    }

    @JsonProperty(value = "robotTasks")
    public ImmutableMap<String, Task> getRobotTasks() {
        return robotTasks;
    }

    @JsonProperty(value = "scoreKeepers")
    public ImmutableMap<String, Actor> getScoreKeepers() {
        return scoreKeepers;
    }

    @JsonProperty(value = "foulTrackers")
    public ImmutableMap<String, Actor> getFoulTrackers() {
        return foulTrackers;
    }

    @JsonProperty(value = "playBook")
    public ImmutableMap<String, Actor> getPlayBook() {
        return playBook;
    }

    @JsonProperty(value = "gameTerms")
    public ImmutableSet<GameTerm> getGameTerms() {
        return gameTerms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameDefinition that = (GameDefinition) o;
        return Objects.equals(personTasks, that.personTasks) &&
                Objects.equals(robotTasks, that.robotTasks) &&
                Objects.equals(scoreKeepers, that.scoreKeepers) &&
                Objects.equals(foulTrackers, that.foulTrackers) &&
                Objects.equals(playBook, that.playBook) &&
                Objects.equals(gameTerms, that.gameTerms);
    }

    @Override
    public int hashCode() {

        return Objects.hash(personTasks, robotTasks, scoreKeepers, foulTrackers, playBook, gameTerms);
    }

    @Override
    public String toString() {
        return "GameDefinition{" +
                "personTasks=" + personTasks +
                ", robotTasks=" + robotTasks +
                ", scoreKeepers=" + scoreKeepers +
                ", foulTrackers=" + foulTrackers +
                ", playBook=" + playBook +
                ", gameTerms=" + gameTerms +
                '}';
    }

    @JsonPOJOBuilder
    public static class Builder {
        private Map<String, Task> personTasks = new HashMap<>();
        private Map<String, Task> robotTasks = new HashMap<>();;
        private Map<String, Actor> scoreKeepers = new HashMap<>();;
        private Map<String, Actor> foulTrackers = new HashMap<>();;
        private Map<String, Actor> playBook = new HashMap<>();;
        private Set<GameTerm> gameTerms = new HashSet<>();;

        public Builder copyOf(GameDefinition gameDefinition){
            this.foulTrackers = gameDefinition.getFoulTrackers();
            this.gameTerms = gameDefinition.getGameTerms();
            this.personTasks = gameDefinition.getPersonTasks();
            this.playBook = gameDefinition.getPlayBook();
            this.robotTasks = gameDefinition.getRobotTasks();
            this.scoreKeepers = gameDefinition.getScoreKeepers();
            return this;
        }

        @JsonProperty(value = "personTasks")
        public Builder setPersonTasks(Map<String, Task> personTasks) {
            this.personTasks = personTasks;
            return this;
        }

        @JsonProperty(value = "robotTasks")
        public Builder setRobotTasks(Map<String, Task> robotTasks) {
            this.robotTasks = robotTasks;
            return this;
        }

        @JsonProperty(value = "scoreKeepers")
        public Builder setScoreKeepers(Map<String, Actor> scoreKeepers) {
            this.scoreKeepers = scoreKeepers;
            return this;
        }

        @JsonProperty(value = "foulTrackers")
        public Builder setFoulTrackers(Map<String, Actor> foulTrackers) {
            this.foulTrackers = foulTrackers;
            return this;
        }

        @JsonProperty(value = "playBook")
        public Builder setPlayBook(Map<String, Actor> playBook) {
            this.playBook = playBook;
            return this;
        }

        @JsonProperty(value = "gameTerms")
        public Builder setGameTerms(Set<GameTerm> gameTerms) {
            this.gameTerms = gameTerms;
            return this;
        }

        public GameDefinition build() {
            return new GameDefinition(ImmutableMap.copyOf(personTasks),
                                      ImmutableMap.copyOf(robotTasks),
                                      ImmutableMap.copyOf(scoreKeepers),
                                      ImmutableMap.copyOf(foulTrackers),
                                      ImmutableMap.copyOf(playBook),
                                      ImmutableSet.copyOf(gameTerms));
        }
    }
}
