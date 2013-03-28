package com.example.androidmontreal.mvp.infrastructure.factories;

import android.os.Handler;
import com.example.androidmontreal.mvc.models.ChronometerModel;
import com.example.androidmontreal.mvp.infrastructure.adapters.HandlerAdapter;
import com.example.androidmontreal.mvp.domain.models.RaceResultsModel;
import com.example.androidmontreal.mvp.domain.presenters.ChronometerViewPresenter;
import com.example.androidmontreal.mvp.domain.presenters.RaceResultsViewPresenter;

public class PresenterFactory {

    public ChronometerViewPresenter buildChronometerViewPresenter() {
        HandlerAdapter handlerAdapter = buildHandler();
        ChronometerModel chronometerModel = new ChronometerModel();
        return new ChronometerViewPresenter(chronometerModel, handlerAdapter);
    }

    private HandlerAdapter buildHandler() {
        Handler handler = new Handler();
        return new HandlerAdapter(handler);
    }

    public RaceResultsViewPresenter buildRaceResultsViewPresenter() {
        RaceResultsModel raceResultsModel = new RaceResultsModel();
        return new RaceResultsViewPresenter(raceResultsModel);
    }
}
