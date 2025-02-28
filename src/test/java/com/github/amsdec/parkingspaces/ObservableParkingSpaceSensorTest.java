package com.github.amsdec.parkingspaces;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

public class ObservableParkingSpaceSensorTest {

    private ObservableParkingSpaceSensor sensor;

    @Before
    public void setup() {
        this.sensor = new ObservableParkingSpaceSensor();
    }

    @Test
    public void setInUseWithoutObservers() {
        this.sensor.setInUse(true);

        assertTrue(true);
    }

    @Test
    public void setInUseNotifiesObserver() {
        final Observer observer = mock(Observer.class);

        this.sensor.attach(observer);
        this.sensor.setInUse(true);

        verify(observer, times(1)).update(true);
    }

    @Test
    public void setInUseDoesNotNotifiesObserverIfUnchanged() {
        final Observer observer = mock(Observer.class);

        this.sensor.attach(observer);
        this.sensor.setInUse(false);

        verify(observer, times(0)).update(anyBoolean());
    }

    @Test
    public void setInUseNotifiesManyObservers() {
        final Observer observer1 = mock(Observer.class);
        final Observer observer2 = mock(Observer.class);

        this.sensor.attach(observer1);
        this.sensor.attach(observer2);
        this.sensor.setInUse(true);

        verify(observer1, times(1)).update(true);
        verify(observer2, times(1)).update(true);
    }

    @Test
    public void setInUseDoesNotNotifiesDettachedObservers() {
        final Observer observer1 = mock(Observer.class);
        final Observer observer2 = mock(Observer.class);
        final Observer observer3 = mock(Observer.class);
        final Observer observer4 = mock(Observer.class);

        this.sensor.attach(observer1);
        this.sensor.attach(observer2);
        this.sensor.attach(observer3);
        this.sensor.attach(observer4);

        this.sensor.detach(observer3);
        this.sensor.detach(observer4);

        this.sensor.setInUse(true);

        verify(observer1, times(1)).update(true);
        verify(observer2, times(1)).update(true);

        verify(observer3, times(0)).update(anyBoolean());
        verify(observer4, times(0)).update(anyBoolean());
    }
}
