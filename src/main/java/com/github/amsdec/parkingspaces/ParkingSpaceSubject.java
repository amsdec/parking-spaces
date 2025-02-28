package com.github.amsdec.parkingspaces;

import java.util.ArrayList;
import java.util.List;

public abstract class ParkingSpaceSubject {

    private final List<Observer> observers = new ArrayList<>();

    public void attach(final Observer observer) {
        this.observers.add(observer);
    }

    public void detach(final Observer observer) {
        this.observers.remove(observer);
    }

    protected void notifyObservers(final boolean inUse) {
        for (final Observer observer : this.observers) {
            observer.update(inUse);
        }
    }
}
