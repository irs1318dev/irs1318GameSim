package org.usfirst.irs1318.gamesim.units;

import java.util.Objects;

/**
 * Class that represents an immutable instant in time.
 *
 * One unit of time is equivalent to one second in a game.
 */
public final class Time {
    private final int x;

    public Time(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Time{" +
                "x=" + x +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return Float.compare(time.x, x) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }
}
