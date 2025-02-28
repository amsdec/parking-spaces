package com.github.amsdec.parkingspaces.observers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FreeSpacesObserverTest {

    @Test
    public void zeroWhenNoFreeSpacesAndUsed() {
        final FreeSpacesObserver observer = new FreeSpacesObserver(0);
        observer.update(true);

        assertEquals(0, observer.getFreeSpaces());
    }

    @Test
    public void decrementWhenInUse() {
        final FreeSpacesObserver observer = new FreeSpacesObserver(10);
        observer.update(true);

        assertEquals(9, observer.getFreeSpaces());
    }

    @Test
    public void incrementWhenFree() {
        final FreeSpacesObserver observer = new FreeSpacesObserver(10);
        observer.update(false);

        assertEquals(11, observer.getFreeSpaces());
    }

}
