package org.usfirst.irs1318.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Objects;

public class TaskDetail {
    private final int duration;
    private final int reactionTime;
    private final double reliability;
    private final Task task;

    private TaskDetail(int duration,
                       int reactionTime,
                       double reliability,
                       Task task) {
        this.duration = duration;
        this.reactionTime = reactionTime;
        this.reliability = reliability;
        this.task = task;
    }

    public int getDuration() {
        return duration;
    }

    public int getReactionTime() {
        return reactionTime;
    }

    public double getReliability() {
        return reliability;
    }

    public Task getTask() {
        return task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDetail that = (TaskDetail) o;
        return duration == that.duration &&
                reactionTime == that.reactionTime &&
                reliability == that.reliability &&
                Objects.equals(task, that.task);
    }

    @Override
    public int hashCode() {

        return Objects.hash(duration, reactionTime, reliability, task);
    }

    @Override
    public String toString() {
        return "TaskDetail{" +
                "duration=" + duration +
                ", reactionTime=" + reactionTime +
                ", reliability=" + reliability +
                ", task=" + task +
                '}';
    }
    @JsonPOJOBuilder
    public static class Builder {
        private int duration;
        private int reactionTime;
        private double reliability;
        private Task task;
        @JsonProperty(value = "duration")
        public Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }
        @JsonProperty(value = "reactionTime")
        public Builder setReactionTime(int reactionTime) {
            this.reactionTime = reactionTime;
            return this;
        }
        @JsonProperty(value = "reliability")
        public Builder setReliability(double reliability) {
            this.reliability = reliability;
            return this;
        }
        @JsonProperty(value = "task")
        public Builder setTask(Task task) {
            this.task = task;
            return this;
        }

        public TaskDetail build() {
            return new TaskDetail(duration, reactionTime, reliability, task);

        }


    }




}
