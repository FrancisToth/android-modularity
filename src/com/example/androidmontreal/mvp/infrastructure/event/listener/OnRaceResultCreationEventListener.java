package com.example.androidmontreal.mvp.infrastructure.event.listener;

public interface OnRaceResultCreationEventListener extends EventListener {
    void onRaceResultCreation(long result);
}