package org.usfirst.irs1318.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Objects;

@JsonDeserialize(builder = FieldSquare.Builder.class)
public class FieldSquare {
    private final int x;
    private final int y;

    public FieldSquare(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @JsonProperty(value = "x")
    public int getX() {
        return x;
    }

    @JsonProperty(value = "y")
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldSquare that = (FieldSquare) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "FieldSquare{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @JsonPOJOBuilder
    public static class Builder {
        private int x;
        private int y;

        @JsonProperty(value = "x")
        public Builder setX(int x) {
            this.x = x;
            return this;
        }

        @JsonProperty(value = "y")
        public Builder setY(int y) {
            this.y = y;
            return this;
        }

        public FieldSquare build() {
            return new FieldSquare(x, y);
        }
    }

}
