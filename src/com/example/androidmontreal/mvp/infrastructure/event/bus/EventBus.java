package com.example.androidmontreal.mvp.infrastructure.event.bus;

import com.example.androidmontreal.mvp.infrastructure.event.event.Event;
import com.example.androidmontreal.mvp.infrastructure.event.listener.EventListener;

public interface EventBus {

    <T extends EventListener> void push(Event<T> event);

    void plug(EventListener listener);

    <T extends EventListener> void register(Class<? extends Event<T>> eventKlazz, T listener);
}
