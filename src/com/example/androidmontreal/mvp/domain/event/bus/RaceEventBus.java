package com.example.androidmontreal.mvp.domain.event.bus;

import com.example.androidmontreal.mvp.domain.event.event.Event;
import com.example.androidmontreal.mvp.domain.event.listener.EventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class RaceEventBus implements EventBus {

    private HashMap<Class<? extends Event<? extends EventListener>>, ArrayList<EventListener>> listenersByEvent = new HashMap<Class<? extends Event<? extends EventListener>>, ArrayList<EventListener>>();

    public void plug(EventListener listener) {
        listener.registerTo(this);
    }

    @Override
    public <T extends EventListener> void register(Class<? extends Event<T>> eventKlazz, T listener) {
        ArrayList<EventListener> listeners = listenersByEvent.get(eventKlazz);
        if (listeners == null) {
            listeners = new ArrayList<EventListener>();
            listenersByEvent.put(eventKlazz, listeners);
        }
        listeners.add(listener);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends EventListener> void push(Event<T> event) {
        ArrayList<EventListener> listeners = listenersByEvent.get(event.getClass());
        if (listeners != null) {
            for (EventListener listener : listeners) {
                event.sendTo((T) listener);
            }
        }
    }
}