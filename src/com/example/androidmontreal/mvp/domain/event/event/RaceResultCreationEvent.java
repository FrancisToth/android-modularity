package com.example.androidmontreal.mvp.domain.event.event;

import com.example.androidmontreal.mvp.domain.event.listener.OnRaceResultCreationEventListener;

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
