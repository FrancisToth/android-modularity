package com.example.androidmontreal.mvp.domain.event.listener;

public interface OnRaceResultCreationEventListener extends EventListener {
    void onRaceResultCreation(long result);
}