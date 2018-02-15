package org.usfirst.irs1318.gamesim.util;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.usfirst.irs1318.gamesim.util.Direction.*;

public class LocationTest {
    private final Location left = new Location(-1, 0);
    private final Location right = new Location(1, 0);
    private final Location top = new Location(0, 1);
    private final Location bottom = new Location(0, -1);

    @Test
    public void translate() {
        assertEquals(left.translate(RIGHT, 2), right);
        assertEquals(right.translate(LEFT, 2), left);
        assertEquals(top.translate(DOWN, 2), bottom);
        assertEquals(bottom.translate(UP, 2), top);
    }
}