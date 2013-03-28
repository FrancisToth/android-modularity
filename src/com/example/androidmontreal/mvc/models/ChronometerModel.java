package com.example.androidmontreal.mvc.models;

public class ChronometerModel implements ObservableModel {

    private ChronometerModelObserver observer;
    private long currentTime;

    @Override
    public void setObserver(ChronometerModelObserver observer) {
        this.observer = observer;
    }

    public void addTime(long delta) {
        currentTime += delta;
        notifyTimeChangedEvent();
    }

    public void resetTime() {
        this.currentTime = 0;
        notifyTimeChangedEvent();
    }

    private void notifyTimeChangedEvent() {
        observer.onTimeChanged(currentTime);
    }

    public long getCurrentTime() {
        return currentTime;
    }
}
