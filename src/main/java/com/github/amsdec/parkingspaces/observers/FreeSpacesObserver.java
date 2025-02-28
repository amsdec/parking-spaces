package com.github.amsdec.parkingspaces.observers;

import com.github.amsdec.parkingspaces.Observer;

import lombok.Getter;

public class FreeSpacesObserver implements Observer {

    @Getter
    private int freeSpaces;

    public FreeSpacesObserver(final int freeSpaces) {
        this.freeSpaces = freeSpaces;
    }

    @Override
    public void update(final boolean inUse) {
        if (inUse) {
            if (this.freeSpaces > 0) {
                this.freeSpaces--;
            }
        } else {
            this.freeSpaces++;
        }
    }

}
