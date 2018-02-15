package org.usfirst.irs1318.gamesim.util;

import java.util.Objects;

/**
 * Class that represents an immutable location.
 *
 * A game can be treated as though it were on a graph. The
 * origin is at the bottom left of the arena, and the scale
 * is three feet per one unit. This location represents
 * a point on that graph.
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

    /**
     * Translates a location in any {@link Direction}.
     * @param distance The distance to translate the location.
     */
    public Location translate(Direction direction, float distance) {
        switch (direction) {
            case LEFT: return new Location(x - distance, y);
            case RIGHT: return new Location(x + distance, y);
            case UP: return new Location(x, y + distance);
            case DOWN: return new Location(x, y - distance);
            default: throw new IllegalArgumentException(direction.toString());
        }
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
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
