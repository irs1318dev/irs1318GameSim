package org.usfirst.irs1318.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.*;
import java.util.stream.Collectors;

@JsonDeserialize(builder = GameTerm.Builder.class)
public class GameTerm {
    private final ImmutableMap<String, ImmutableSet<String>> definitions;

    private GameTerm(ImmutableMap<String, ImmutableSet<String>> definitions) {
        this.definitions = definitions;
    }

    @JsonProperty(value = "definitions")
    public ImmutableMap<String, ImmutableSet<String>> getDefinitions() {
        return definitions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameTerm gameTerm = (GameTerm) o;
        return Objects.equals(definitions, gameTerm.definitions);
    }

    @Override
    public int hashCode() {

        return Objects.hash(definitions);
    }

    @Override
    public String toString() {
        return "GameTerm{" +
                "definitions=" + definitions +
                '}';
    }

    @JsonPOJOBuilder
    public static class Builder {
        private Map<String, Set<String>> definitions = new HashMap<>();

        public Builder copyOf (GameTerm gameTerm){
            gameTerm.getDefinitions().keySet()
                    .forEach(key ->
                            definitions.put(key,
                                    new HashSet<String>(gameTerm.getDefinitions().get(key))
                            )
                    );
                    return this;
        }

        @JsonProperty(value = "definitions")
        public Builder setDefinitions(Map<String, Set<String>> definitions) {
            this.definitions = definitions;
            return this;
        }


        public GameTerm build() {
            Map<String, ImmutableSet<String>> temp = new HashMap<>();
            definitions.keySet().stream()
                    .forEach(key ->
                    temp.put(key, ImmutableSet.copyOf(definitions.get(key)))
                    );
            return new GameTerm(ImmutableMap.copyOf(temp));
        }
    }
}