package com.github.amsdec.parkingspaces;

public interface ParkingSpaceSubject {

    public void attach(final Observer observer);

    public void detach(final Observer observer);

    void notifyObservers(final boolean inUse);
}
