package com.example.androidmontreal.mvp.domain.event.bus;

import com.example.androidmontreal.mvp.domain.event.event.Event;
import com.example.androidmontreal.mvp.domain.event.listener.EventListener;

public interface EventBus {

    <T extends EventListener> void push(Event<T> event);

    void plug(EventListener listener);

    <T extends EventListener> void register(Class<? extends Event<T>> eventKlazz, T listener);
}
