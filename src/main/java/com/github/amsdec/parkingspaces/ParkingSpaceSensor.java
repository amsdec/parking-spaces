package com.github.amsdec.parkingspaces;

public class ParkingSpaceSensor extends ParkingSpaceSubject {

    private boolean inUse = false;

    public void setInUse(final boolean inUse) {
        if (this.inUse != inUse) {
            this.inUse = inUse;
            this.notifyObservers(this.inUse);
        }
    }

}
