package com.example.androidmontreal.mvp.domain.event.event;

import com.example.androidmontreal.mvp.domain.event.listener.EventListener;

public interface Event<T extends EventListener> {
    void sendTo(T listener);
}
