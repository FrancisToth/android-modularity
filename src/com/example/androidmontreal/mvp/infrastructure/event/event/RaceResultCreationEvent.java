package com.example.androidmontreal.mvp.infrastructure.event.event;

import com.example.androidmontreal.mvp.infrastructure.event.listener.OnRaceResultCreationEventListener;

public class RaceResultCreationEvent implements Event<OnRaceResultCreationEventListener>{

    private long result;

    public RaceResultCreationEvent(long result) {
        this.result = result;
    }

    @Override
    public void sendTo(OnRaceResultCreationEventListener listener) {
        listener.onRaceResultCreation(result);
    }
}
