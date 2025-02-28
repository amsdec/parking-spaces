package com.github.amsdec.parkingspaces;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpaceSensor {

    private final List<Observer> observers = new ArrayList<>();

    private boolean inUse = false;

    public void attach(final Observer observer) {
        this.observers.add(observer);
    }

    public void detach(final Observer observer) {
        this.observers.remove(observer);
    }

    private void notifyObservers(final boolean inUse) {
        for (final Observer observer : this.observers) {
            observer.update(inUse);
        }
    }

    public void setInUse(final boolean inUse) {
        if (this.inUse != inUse) {
            this.inUse = inUse;
            this.notifyObservers(this.inUse);
        }
    }

}
