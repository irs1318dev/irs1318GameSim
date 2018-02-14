package org.usfirst.irs1318.gamesim.data;

import java.util.Objects;

/**
 * Class representing an immutable location.
 *
 * A game can be treated as though it were on a graph. The
 * origin is at the bottom left of the arena, and the scale
 * is three feet per one unit. This location represents
 * a point on that graph.
 *
 * Locations may be negative, but this should be avoided if
 * possible.
 */
public final class Location {
    private final int x;
    private final int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return This location translated one unit in any {@link Direction}.
     */
    public Location translate(Direction direction) {
        switch (direction) {
            case LEFT: return new Location(x - 1, y);
            case RIGHT: return new Location(x + 1, y);
            case UP: return new Location(x, y + 1);
            case DOWN: return new Location(x, y - 1);
            default: throw new IllegalArgumentException(direction.toString());
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return Integer.toString(x) + ", " + Integer.toString(y);
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
