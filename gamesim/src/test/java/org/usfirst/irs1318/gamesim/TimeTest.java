package org.usfirst.irs1318.gamesim;

import org.junit.*;
import org.usfirst.irs1318.gamesim.data.Time;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class TimeTest {
    private final Time now = new Time(0);
    private final Time later = new Time(1);

    @Test
    public void isBefore() {
        assertTrue(now.isBefore(later));
        assertFalse(later.isBefore(now));
    }

    @Test
    public void isAfter() {
        assertTrue(later.isAfter(now));
        assertFalse(now.isAfter(later));
    }

    @Test
    public void translatePast() {
        assertTrue(later.translatePast(later).equals(now));
    }

    @Test
    public void translateFuture() {
        assertTrue(now.translateFuture(later).equals(later));
    }

    @Test
    public void constructNegativeShouldFail() {
        try {
            new Time(-1);
            fail();
        } catch (IllegalArgumentException ignored) { }

        try {
            new Time(new BigInteger("-1"));
            fail();
        } catch (IllegalArgumentException ignored) { }
    }
}