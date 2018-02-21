package org.usfirst.irs1318.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Objects;

@JsonDeserialize(builder = FieldActor.Builder.class)
public class FieldActor {
    private final String name;
    private final String id;
    private final String type;

    public FieldActor(String name, String id, String type) {
        this.name = name;
        this.id = id;
        this.type = type;
    }

    @JsonProperty(value = "name")
    public String getName() {
        return name;
    }

    @JsonProperty(value = "id")
    public String getId() {
        return id;
    }

    @JsonProperty(value = "type")
    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldActor that = (FieldActor) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(id, that.id) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, id, type);
    }

    @Override
    public String toString() {
        return "FieldActor{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String name;
        private String id;
        private String type;

        @JsonProperty(value = "name")
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        @JsonProperty(value = "id")
        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        @JsonProperty(value = "type")
        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public FieldActor build() {
            return new FieldActor(name, id, type);
        }

    }


}
