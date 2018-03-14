package org.usfirst.irs1318.gamesim.units;

import java.util.Objects;

/**
 * Class that represents an immutable location.
 *
 * A game can be treated as though it were on a graph. The
 * origin is at the bottom left of the arena, and the scale
 * is one meter per one unit. This location represents a point
 * on that graph.
 *
 * Locations should not be compared directly. Instead, they
 * should be checked to see if they're in an {@link Area}.
 */
public final class Location {
    private final float x;
    private final float y;

    public Location(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x &&
                y == location.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
