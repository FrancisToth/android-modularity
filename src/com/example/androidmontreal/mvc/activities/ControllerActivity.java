package com.example.androidmontreal.mvc.activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.example.androidmontreal.R;
import com.example.androidmontreal.mvc.models.ChronometerModel;
import com.example.androidmontreal.mvc.views.ChronometerView;
import com.example.androidmontreal.mvc.views.ViewObserver;

public class ControllerActivity extends Activity {

    private Handler handler;
    private boolean isTimerRunning;
    private long initialTime;
    private ChronometerModel model;
    private ChronometerView view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = (ChronometerView) View.inflate(this, R.layout.mvc_chronometer_view, null);
        view.setObserver(viewListener);
        setContentView(view);

        model = new ChronometerModel();
        model.setObserver(view);

        handler = new Handler();
    }

    private ViewObserver viewListener = new ViewObserver() {

        @Override
        public void onStartButtonClicked() {
            isTimerRunning = true;
            initialTime = System.currentTimeMillis();
            timerRunnable.run();
            view.displayStopButton();
        }

        @Override
        public void onStopButtonClicked() {
            isTimerRunning = false;
            handler.removeCallbacks(timerRunnable);
            view.displayResumeButton();
        }

        @Override
        public void onResetButtonClicked() {
            initialTime = System.currentTimeMillis();
            handler.removeCallbacks(timerRunnable);
            model.resetTime();
            view.displayStartButton();
        }
    };

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
}