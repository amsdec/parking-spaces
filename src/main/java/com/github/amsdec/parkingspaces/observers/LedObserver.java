package com.github.amsdec.parkingspaces.observers;

import com.github.amsdec.parkingspaces.Observer;

import lombok.Getter;

public class LedObserver implements Observer {

    @Getter
    private String ledColor;

    @Override
    public void update(final boolean inUse) {
        this.ledColor = inUse ? "RED" : "GREEN";
    }

}
