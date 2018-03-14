package org.usfirst.irs1318.gamesim.units;

import java.util.Objects;

/**
 * Class that represents an immutable area.
 *
 * An area is a location and a size. It uses the same units
 * as {@link Location}.
 */
public final class Area {
    private final Location location;
    private final Location size;

    public Area(Location location, Location size) {
        this.location = location;
        this.size = size;
    }

    public boolean contains(Location location) {
        return location.getX() > this.location.getX() &&
                location.getX() < this.location.getX() + size.getX() &&
                location.getY() > this.location.getY() &&
                location.getY() < this.location.getY() + size.getY();
    }

    public Location getLocation() {
        return location;
    }

    public Location getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Area{" +
                "location=" + location +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(location, area.location) &&
                Objects.equals(size, area.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, size);
    }
}
