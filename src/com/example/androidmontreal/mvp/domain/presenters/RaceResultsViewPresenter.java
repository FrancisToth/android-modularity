package com.example.androidmontreal.mvp.domain.presenters;

import com.example.androidmontreal.mvp.infrastructure.event.bus.EventBus;
import com.example.androidmontreal.mvp.infrastructure.event.listener.OnRaceResultCreationEventListener;
import com.example.androidmontreal.mvp.infrastructure.event.event.RaceResultCreationEvent;
import com.example.androidmontreal.mvp.domain.models.RaceResultsModel;
import com.example.androidmontreal.mvp.domain.views.RaceResultsView;

public class RaceResultsViewPresenter  implements Presenter<RaceResultsView>, OnRaceResultCreationEventListener {

    private RaceResultsView view;
    private RaceResultsModel model;

    public RaceResultsViewPresenter(RaceResultsModel model) {
        this.model = model;
    }

    @Override
    public void plugView(RaceResultsView view) {
        this.view = view;
        model.setObserver(view);
    }

    @Override
    public void registerTo(EventBus bus) {
        bus.register(RaceResultCreationEvent.class, this);
    }

    @Override
    public void onRaceResultCreation(long result) {
        model.addRaceResult(result);
//        view.addResult(result);
    }

    public void onClearButtonClicked() {
        view.clearRaceResultsList();
    }
}