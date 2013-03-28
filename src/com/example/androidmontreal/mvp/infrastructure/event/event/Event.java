package com.example.androidmontreal.mvp.infrastructure.event.event;

import com.example.androidmontreal.mvp.infrastructure.event.listener.EventListener;

public interface Event<T extends EventListener> {
    void sendTo(T listener);
}
