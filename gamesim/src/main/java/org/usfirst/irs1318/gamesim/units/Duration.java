package org.usfirst.irs1318.gamesim.units;

import java.util.Objects;

/**
 * Class that represents an immutable duration.
 *
 * A duration is a time and a size. It uses the same units
 * as {@link Time}.
 */
public final class Duration {
    private final Time time;
    private final Time size;

    public Duration(Time time, Time size) {
        this.time = time;
        this.size = size;
    }

    public boolean contains(Time time) {
        return time.getX() > this.time.getX() &&
                time.getX() < this.time.getX() + size.getX();
    }

    public Time getTime() {
        return time;
    }

    public Time getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Duration{" +
                "time=" + time +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duration duration = (Duration) o;
        return Objects.equals(time, duration.time) &&
                Objects.equals(size, duration.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, size);
    }
}
