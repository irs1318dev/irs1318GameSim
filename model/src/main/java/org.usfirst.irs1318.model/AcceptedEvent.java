package org.usfirst.irs1318.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.ImmutableMap;

@JsonDeserialize(builder = AcceptedEvent.Builder.class)
public class AcceptedEvent {

    private String eventName;
    private String type;
    private ImmutableMap<String, String> data;

    private AcceptedEvent(String eventName,
                         String type,
                         ImmutableMap<String, String> data) {
        this.eventName = eventName;
        this.type = type;
        this.data = data;
    }

    @JsonProperty(value = "eventName")
    public String getEventName() {
        return eventName;
    }

    @JsonProperty(value = "type")
    public String getType() {
        return type;
    }

    @JsonProperty(value = "data")
    public Map<String, String> getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcceptedEvent that = (AcceptedEvent) o;
        return Objects.equals(eventName, that.eventName) &&
                Objects.equals(type, that.type) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(eventName, type, data);
    }

    @Override
    public String toString() {
        return "AcceptedEvent{" +
                "eventName='" + eventName + '\'' +
                ", type='" + type + '\'' +
                ", data=" + data +
                '}';
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String eventName;
        private String type;
        private Map<String, String> data = new HashMap<>();

        @JsonProperty(value = "eventName")
        public Builder setEventName(String eventName) {
            this.eventName = eventName;
            return this;
        }

        @JsonProperty(value = "type")
        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        @JsonProperty(value = "data")
        public Builder setData(Map<String, String> data) {
            this.data = data;
            return this;
        }

        public AcceptedEvent build() {
            return new AcceptedEvent(eventName, type, ImmutableMap.copyOf(data));
        }
    }
}
