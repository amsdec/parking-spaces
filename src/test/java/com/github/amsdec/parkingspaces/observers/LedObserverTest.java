package com.github.amsdec.parkingspaces.observers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LedObserverTest {

    @Test
    public void updateInUse() {
        final LedObserver observer = new LedObserver();
        observer.update(true);

        assertEquals("RED", observer.getLedColor());
    }

    @Test
    public void updateFree() {
        final LedObserver observer = new LedObserver();
        observer.update(false);

        assertEquals("GREEN", observer.getLedColor());
    }

}
