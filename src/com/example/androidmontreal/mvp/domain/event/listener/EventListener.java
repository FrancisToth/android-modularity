package com.example.androidmontreal.mvp.domain.event.listener;

import com.example.androidmontreal.mvp.domain.event.bus.EventBus;

public interface EventListener {
    void registerTo(EventBus bus);
}
