package com.example.androidmontreal.mvp.domain.views;

import com.example.androidmontreal.mvp.domain.models.RaceResultsModelObserver;
import com.example.androidmontreal.mvp.domain.presenters.RaceResultsViewPresenter;

public interface RaceResultsView extends RaceResultsModelObserver {
    void clearRaceResultsList();
    void plugWith(RaceResultsViewPresenter presenter);
}
