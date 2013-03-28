package com.example.androidmontreal.mvp.infrastructure.adapters;

public interface RunnableHandler {
    void removeCallbacks(Runnable r);
    void postDelayed(Runnable r, int delay);
}
