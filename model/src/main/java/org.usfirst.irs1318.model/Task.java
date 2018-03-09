package org.usfirst.irs1318.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
@JsonDeserialize
public class Task {

    @JsonPOJOBuilder
    public static class Builder{
        private String task;

        @JsonProperty(value = "task")
        public Builder Task(){
           this.task = "Climb";
           return this;
        }


    }
}
