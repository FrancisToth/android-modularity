package com.example.androidmontreal.mvp.domain.views;

import com.example.androidmontreal.mvc.models.ChronometerModelObserver;
import com.example.androidmontreal.mvp.domain.presenters.ChronometerViewPresenter;

public interface ChronometerView extends ChronometerModelObserver {

    void plugWith(ChronometerViewPresenter presenter);

    void displayResumeButton();

    void displayStartButton();

    void displayStopButton();
}
