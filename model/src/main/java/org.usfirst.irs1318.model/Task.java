package org.usfirst.irs1318.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Objects;

@JsonDeserialize(builder = Task.Builder.class)
public class Task {
    private final String name;
    private final String id;
    private final String activity;
    private final String object;
    private final String targetType;
    private final String direction;
    private final String actor;

    private Task(String name, String id, String activity,
                 String object, String targetType,
                 String direction, String actor) {
        this.name = name;
        this.id = id;
        this.activity = activity;
        this.object = object;
        this.targetType = targetType;
        this.direction = direction;
        this.actor = actor;
    }

    @JsonProperty(value = "name")
    public String getName() {
        return name;
    }

    @JsonProperty(value = "id")
    public String getId() {
        return id;
    }

    @JsonProperty(value = "activity")
    public String getActivity() {
        return activity;
    }

    @JsonProperty(value = "object")
    public String getObject() {
        return object;
    }

    @JsonProperty(value = "targetType")
    public String getTargetType() {
        return targetType;
    }

    @JsonProperty(value = "direction")
    public String getDirection() {
        return direction;
    }

    @JsonProperty(value = "actor")
    public String getActor() {
        return actor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name) &&
                Objects.equals(id, task.id) &&
                Objects.equals(activity, task.activity) &&
                Objects.equals(object, task.object) &&
                Objects.equals(targetType, task.targetType) &&
                Objects.equals(direction, task.direction) &&
                Objects.equals(actor, task.actor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, id, activity, object, targetType, direction, actor);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", activity='" + activity + '\'' +
                ", object='" + object + '\'' +
                ", targetType='" + targetType + '\'' +
                ", direction='" + direction + '\'' +
                ", actor='" + actor + '\'' +
                '}';
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String name;
        private String id;
        private String activity;
        private String object;
        private String targetType;
        private String direction;
        private String actor;

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

        @JsonProperty(value = "activity")
        public Builder setActivity(String activity) {
            this.activity = activity;
            return this;
        }

        @JsonProperty(value = "object")
        public Builder setObject(String object) {
            this.object = object;
            return this;
        }

        @JsonProperty(value = "targetType")
        public Builder setTargetType(String targetType) {
            this.targetType = targetType;
            return this;
        }

        @JsonProperty(value = "direction")
        public Builder setDirection(String direction) {
            this.direction = direction;
            return this;
        }

        @JsonProperty(value = "actor")
        public Builder setActor(String actor) {
            this.actor = actor;
            return this;
        }

        public Task build() {
            return new Task(name, id, activity, object, targetType, direction, actor);
        }
    }
}
