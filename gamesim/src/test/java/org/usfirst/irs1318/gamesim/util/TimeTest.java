package org.usfirst.irs1318.gamesim.util;

import org.junit.Test;

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
        assertEquals(later.translatePast(later), now);
    }

    @Test
    public void translateFuture() {
        assertEquals(now.translateFuture(later), later);
    }

    @Test
    public void constructNegativeShouldFail() {
        try {
            new Time(-1);
            fail();
        } catch (IllegalArgumentException ignored) { }
    }
}