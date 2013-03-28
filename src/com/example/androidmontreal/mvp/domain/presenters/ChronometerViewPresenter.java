package com.example.androidmontreal.mvp.domain.presenters;

import com.example.androidmontreal.mvc.models.ChronometerModel;
import com.example.androidmontreal.mvp.infrastructure.adapters.HandlerAdapter;
import com.example.androidmontreal.mvp.infrastructure.event.bus.EventBus;
import com.example.androidmontreal.mvp.infrastructure.event.event.RaceResultCreationEvent;
import com.example.androidmontreal.mvp.infrastructure.event.listener.EventListener;
import com.example.androidmontreal.mvp.domain.views.ChronometerView;

public class ChronometerViewPresenter implements Presenter<ChronometerView>, EventListener {
    private ChronometerView view;
    private final ChronometerModel model;
    private final HandlerAdapter handler;
    private EventBus eventBus;

    private long initialTime;
    private boolean isTimerRunning;

    public ChronometerViewPresenter(ChronometerModel model, HandlerAdapter handler) {
        this.handler = handler;
        this.model = model;
    }

    @Override
    public void plugView(ChronometerView chronometerView) {
        view = chronometerView;
        model.setObserver(view);
    }

    @Override
    public void registerTo(EventBus bus) {
        this.eventBus = bus;
    }

    public void onStartButtonClicked() {
        isTimerRunning = true;
        initialTime = System.currentTimeMillis();
        timerRunnable.run();
        view.displayStopButton();
    }

    private Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            if (isTimerRunning) {
                long delta = System.currentTimeMillis() - initialTime;
                initialTime = System.currentTimeMillis();
                model.addTime(delta);
                handler.postDelayed(timerRunnable, 100);
            }
        }
    };

    public void onResetButtonClicked() {
        initialTime = System.currentTimeMillis();
        handler.removeCallbacks(timerRunnable);

        long currentTime = model.getCurrentTime();
        eventBus.push(new RaceResultCreationEvent(currentTime));

        model.resetTime();
        view.displayStartButton();
    }

    public void onStopButtonClicked() {
        isTimerRunning = false;
        handler.removeCallbacks(timerRunnable);
        view.displayResumeButton();
    }
}