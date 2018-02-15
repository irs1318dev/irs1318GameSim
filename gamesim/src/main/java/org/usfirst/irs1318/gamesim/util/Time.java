package org.usfirst.irs1318.gamesim.util;

/**
 * Class that represents an immutable instant in time.
 *
 * One unit of time is equivalent to one second in a game.
 *
 * This class does not expose its internals. This is so that
 * we can change what we use to represent time in the future
 * if necessary.
 */
public final class Time implements Comparable<Time> {
    private final double value;

    /**
     * @param value A positive double representing the time.
     * @throws IllegalArgumentException if passed a negative value.
     */
    public Time(double value) {
        if (value < 0)
            throw new IllegalArgumentException(Double.toString(value));
        this.value = value;
    }

    public boolean isBefore(Time time) {
        return compareTo(time) < 0;
    }

    public boolean isAfter(Time time) {
        return compareTo(time) > 0;
    }

    public Time translateFuture(Time time) {
        return new Time(value + time.value);
    }

    public Time translatePast(Time time) {
        return new Time(value - time.value);
    }

    @Override
    public int compareTo(Time time) {
        return Double.compare(value, time.value);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Time && ((Time) obj).value == value;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }
}
