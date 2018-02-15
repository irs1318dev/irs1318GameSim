package org.usfirst.irs1318.gamesim.data;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class AreaTest {
    private final Area center = new Area(new Location(0, 0), 1, 1);
    private final Location origin = new Location(0, 0);
    private final Location farRight = new Location(10, 0);
    private final Location farUp = new Location(0, 10);

    @Test
    public void bounds() {
        assertEquals(center.getLeftBound(), -1f);
        assertEquals(center.getRightBound(), 1f);
        assertEquals(center.getTopBound(), 1f);
        assertEquals(center.getBottomBound(), -1f);
    }

    @Test
    public void contains() {
        assertTrue(center.contains(origin));
        assertFalse(center.contains(farRight));
        assertFalse(center.contains(farUp));
    }
}