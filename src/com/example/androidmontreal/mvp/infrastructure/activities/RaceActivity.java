package com.example.androidmontreal.mvp.infrastructure.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.example.androidmontreal.R;
import com.example.androidmontreal.mvp.infrastructure.event.bus.RaceEventBus;
import com.example.androidmontreal.mvp.infrastructure.factories.PresenterFactory;
import com.example.androidmontreal.mvp.domain.presenters.ChronometerViewPresenter;
import com.example.androidmontreal.mvp.domain.presenters.RaceResultsViewPresenter;
import com.example.androidmontreal.mvp.infrastructure.views.AndroidRaceResultsView;
import com.example.androidmontreal.mvp.domain.views.ChronometerView;
import com.example.androidmontreal.mvp.domain.views.RaceResultsView;

public class RaceActivity extends Activity {

    private RaceEventBus eventBus = new RaceEventBus();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvp_main);

        PresenterFactory presenterFactory = new PresenterFactory();

        LinearLayout mainView = (LinearLayout) findViewById(R.id.main_view);

        ChronometerView chronometerView = buildChronometerView(presenterFactory);
        mainView.addView((View) chronometerView);

        RaceResultsView raceResultsView = buildRaceResultsView(presenterFactory);
        mainView.addView((View) raceResultsView);
    }

    private RaceResultsView buildRaceResultsView(PresenterFactory presenterFactory) {
        RaceResultsViewPresenter raceResultsViewPresenter = presenterFactory.buildRaceResultsViewPresenter();
        raceResultsViewPresenter.registerTo(eventBus);
        RaceResultsView raceResultsView = (AndroidRaceResultsView) View.inflate(this, R.layout.mvp_raceresults_view, null);
        raceResultsView.plugWith(raceResultsViewPresenter);
        return raceResultsView;
    }

    private ChronometerView buildChronometerView(PresenterFactory presenterFactory) {
        ChronometerViewPresenter chronometerViewPresenter = presenterFactory.buildChronometerViewPresenter();
        chronometerViewPresenter.registerTo(eventBus);
        ChronometerView chronometerView = (ChronometerView) View.inflate(this, R.layout.mvp_chronometer_view, null);
        chronometerView.plugWith(chronometerViewPresenter);
        return chronometerView;
    }
}