package org.usfirst.irs1318.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonDeserialize(builder = Field.Builder.class)
public class Field {
    private final int length;
    private final int width;
    private final int gridStepX;
    private final int gridStepY;
    private final ImmutableMap<String, FieldSquare> fieldSquares;

    public Field(int length, int width, int gridStepX, int gridStepY, ImmutableMap<String, FieldSquare> fieldSquares) {
        this.length = length;
        this.width = width;
        this.gridStepX = gridStepX;
        this.gridStepY = gridStepY;
        this.fieldSquares = fieldSquares;
    }

    @JsonProperty(value = "length")
    public int getLength() {
        return length;
    }

    @JsonProperty(value = "width")
    public int getWidth() {
        return width;
    }

    @JsonProperty(value = "gridStepX")
    public int getGridStepX() {
        return gridStepX;
    }

    @JsonProperty(value = "gridStepY")
    public int getGridStepY() {
        return gridStepY;
    }

    @JsonProperty(value = "fieldSquares")
    public ImmutableMap<String, FieldSquare> getFieldSquares() {
        return fieldSquares;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return length == field.length &&
                width == field.width &&
                gridStepX == field.gridStepX &&
                gridStepY == field.gridStepY &&
                Objects.equals(fieldSquares, field.fieldSquares);
    }

    @Override
    public int hashCode() {

        return Objects.hash(length, width, gridStepX, gridStepY, fieldSquares);
    }

    @Override
    public String toString() {
        return "Field{" +
                "length=" + length +
                ", width=" + width +
                ", gridStepX=" + gridStepX +
                ", gridStepY=" + gridStepY +
                ", fieldSquares=" + fieldSquares +
                '}';
    }

    @JsonPOJOBuilder
    public static class Builder {
        private int length;
        private int width;
        private int gridStepX;
        private int gridStepY;
        private Map<String, FieldSquare> fieldSquares = new HashMap<>();

        public Builder copyOf(Field field){
            this.length = field.getLength();
            this.width = field.getWidth();
            this.gridStepX = field.getGridStepX();
            this.gridStepY = field.getGridStepY();
            this.fieldSquares = field.getFieldSquares();
            return this;
        }

        @JsonProperty(value = "length")
        public Builder setLength(int length) {
            this.length = length;
            return this;
        }

        @JsonProperty(value = "width")
        public Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        @JsonProperty(value = "gridStepX")
        public Builder setGridStepX(int gridStepX) {
            this.gridStepX = gridStepX;
            return this;
        }

        @JsonProperty(value = "gridStepY")
        public Builder setGridStepY(int gridStepY) {
            this.gridStepY = gridStepY;
            return this;
        }

        @JsonProperty(value = "fieldSquares")
        public Builder setFieldSquares(Map<String, FieldSquare> fieldSquares) {
            this.fieldSquares = fieldSquares;
            return this;
        }

        public Field build() {
            return new Field(length, width, gridStepX, gridStepY, ImmutableMap.copyOf(fieldSquares));
        }
    }
}
