package org.usfirst.irs1318.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Objects;

@JsonDeserialize(builder = DataUpdate.Builder.class)
public class DataUpdate {
    private final String event;
    private final String onReceive;


    private DataUpdate(String event, String onReceive){
        this.event = event;
        this.onReceive = onReceive;

    }

    public String getEvent() {
        return event;
    }

    public String getOnReceive() {
        return onReceive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataUpdate that = (DataUpdate) o;
        return Objects.equals(event, that.event) &&
                Objects.equals(onReceive, that.onReceive);
    }

    @Override
    public int hashCode() {

        return Objects.hash(event, onReceive);
    }

    @Override
    public String toString() {
        return "DataUpdate{" +
                "event='" + event + '\'' +
                ", onReceive='" + onReceive + '\'' +
                '}';
    }
    @JsonPOJOBuilder
    public static class Builder{
        private String event;
        private String onReceive;

        public Builder copyOf(DataUpdate dataUpdate){
            this.event = dataUpdate.getEvent();
            this.onReceive = dataUpdate.onReceive;
            return this;

        }
        @JsonProperty(value = "event")
        public Builder setEvent(String event) {
            this.event = event;
            return this;
        }
        @JsonProperty(value = "onReceive")
        public Builder setOnReceive(String onReceive) {
            this.onReceive = onReceive;
            return this;
        }
        public DataUpdate build() {
            return new DataUpdate(event, onReceive);
        }
    }
}
