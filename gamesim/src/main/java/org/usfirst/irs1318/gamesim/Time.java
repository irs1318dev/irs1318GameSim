package org.usfirst.irs1318.gamesim;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Interface representing an immutable instant in time.
 *
 * This class does not expose its internals. This is so that
 * we can change what we use to represent time in the future
 * if necessary.
 */
public final class Time implements Comparable<Time> {
    private final BigInteger value;

    /**
     * @param value A positive long representing the time.
     * @throws IllegalArgumentException if passed a negative value.
     */
    public Time(long value) {
        this(BigInteger.valueOf(value));
    }

    /**
     * @param value A positive BigInteger representing the time.
     * @throws IllegalArgumentException if passed a negative value.
     */
    public Time(BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) < 0)
            throw new IllegalArgumentException(value.toString());
        this.value = Objects.requireNonNull(value);
    }

    public boolean isBefore(Time time) {
        return compareTo(time) < 0;
    }

    public boolean isAfter(Time time) {
        return compareTo(time) > 0;
    }

    public Time translateFuture(Time time) {
        return new Time(value.add(time.value));
    }

    public Time translatePast(Time time) {
        return new Time(value.subtract(time.value));
    }

    @Override
    public int compareTo(Time time) {
        return value.compareTo(time.value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Time && ((Time) obj).value.equals(value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
