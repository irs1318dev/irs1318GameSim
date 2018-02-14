package org.usfirst.irs1318.gamesim.data;

import java.util.Objects;

/**
 * Class that represents an immutable area.
 *
 * An area is a {@link Location}, width, and height. It uses
 * the same units as {@link Location}. The location is at
 * the center of the area.
 */
public final class Area {
    private final Location location;
    private final float width;
    private final float height;

    public Area(Location location, float width, float height) {
        this.location = location;
        this.width = width;
        this.height = height;
    }

    /**
     * @return True if an area contains a location, false otherwise.
     */
    public boolean contains(Location location) {
        return location.getX() < getRightBound() &&
                location.getX() > getLeftBound() &&
                location.getY() < getTopBound() &&
                location.getY() > getBottomBound();
    }

    public float getRightBound() {
        return location.getX() + width;
    }

    public float getLeftBound() {
        return location.getX() - width;
    }

    public float getTopBound() {
        return location.getY() + height;
    }

    public float getBottomBound() {
        return location.getY() - height;
    }

    public Location getLocation() {
        return location;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "(" + location.getX() + " +/- " + width + ", " +
                location.getY() + " +/- " + height + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Float.compare(area.width, width) == 0 &&
                Float.compare(area.height, height) == 0 &&
                Objects.equals(location, area.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, width, height);
    }
}
