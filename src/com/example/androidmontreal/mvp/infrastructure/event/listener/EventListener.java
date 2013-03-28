package com.example.androidmontreal.mvp.infrastructure.event.listener;

import com.example.androidmontreal.mvp.infrastructure.event.bus.EventBus;

public interface EventListener {
    void registerTo(EventBus bus);
}
