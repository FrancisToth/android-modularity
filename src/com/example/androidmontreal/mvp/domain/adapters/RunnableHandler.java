package com.example.androidmontreal.mvp.domain.adapters;

public interface RunnableHandler {
    void removeCallbacks(Runnable r);
    void postDelayed(Runnable r, int delay);
}
