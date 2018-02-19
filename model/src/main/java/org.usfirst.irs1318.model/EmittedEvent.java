package org.usfirst.irs1318.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.ImmutableMap;

@JsonDeserialize(builder = EmittedEvent.Builder.class)
public class EmittedEvent {

    private final String eventName;
    private final ImmutableMap<String, String> properties;

    private EmittedEvent(String eventName,
                         ImmutableMap<String, String> properties) {
        this.eventName = eventName;
        this.properties = properties;
    }

    @JsonProperty(value = "eventName")
    public String getEventName() {
        return eventName;
    }

    @JsonProperty(value = "properties")
    public Map<String, String> getProperties() {
        return properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmittedEvent that = (EmittedEvent) o;
        return Objects.equals(eventName, that.eventName) &&
                Objects.equals(properties, that.properties);
    }

    @Override
    public int hashCode() {

        return Objects.hash(eventName, properties);
    }

    @Override
    public String toString() {
        return "EmittedEvent{" +
                "eventName='" + eventName + '\'' +
                ", properties=" + properties +
                '}';
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String eventName;
        private Map<String, String> properties = new HashMap<>();

        @JsonProperty(value = "eventName")
        public Builder setEventName(String eventName) {
            this.eventName = eventName;
            return this;
        }

        @JsonProperty(value = "properties")
        public Builder setProperties(Map<String, String> properties) {
            this.properties = properties;
            return this;
        }

        public EmittedEvent build() {
            return new EmittedEvent(eventName, ImmutableMap.copyOf(properties));
        }
    }
}
