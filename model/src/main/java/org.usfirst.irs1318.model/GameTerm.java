package org.usfirst.irs1318.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@JsonDeserialize(builder = GameTerms.Builder.class)
public class GameTerms {
    private final ImmutableMap<String, ImmutableSet<String>> definitions;

    private GameTerms(ImmutableMap<String, ImmutableSet<String>> definitions) {
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
        GameTerms gameTerms = (GameTerms) o;
        return Objects.equals(definitions, gameTerms.definitions);
    }

    @Override
    public int hashCode() {

        return Objects.hash(definitions);
    }

    @Override
    public String toString() {
        return "GameTerms{" +
                "definitions=" + definitions +
                '}';
    }

    @JsonPOJOBuilder
    public static class Builder {
        private Map<String, Set<String>> definitions = new HashMap<>();

        @JsonProperty(value = "definitions")
        public Builder setDefinitions(Map<String, Set<String>> definitions) {
            this.definitions = definitions;
            return this;
        }


        public GameTerms build() {
            Map<String, ImmutableSet<String>> temp = new HashMap<>();
            definitions.keySet().stream()
                    .forEach(key ->
                    temp.put(key, ImmutableSet.copyOf(definitions.get(key)))
                    );
            return new GameTerms(ImmutableMap.copyOf(temp));
        }
    }
}