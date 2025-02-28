package com.github.amsdec.parkingspaces;

import java.util.ArrayList;
import java.util.List;

public class ObservableParkingSpaceSensor extends ParkingSpaceSensor implements ParkingSpaceSubject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(final Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(final Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(final boolean inUse) {
        for (final Observer observer : this.observers) {
            observer.update(inUse);
        }
    }

    @Override
    public void setInUse(final boolean inUse) {

        if (this.isInUse() != inUse) {
            super.setInUse(inUse);
            this.notifyObservers(this.isInUse());
        }
    }
}
