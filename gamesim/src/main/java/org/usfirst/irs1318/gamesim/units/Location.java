package org.usfirst.irs1318.gamesim.units;

import java.util.Objects;

/**
 * Class that represents an immutable location.
 *
 * A game can be treated as though it were on a graph. The origin is at the
 * bottom left of the arena, and the scale is three feet per one unit. This
 * location represents a point on that graph.
 */
public final class Location {
    private final int x;
    private final int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
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
