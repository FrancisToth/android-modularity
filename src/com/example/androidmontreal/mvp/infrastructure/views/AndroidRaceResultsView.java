package com.example.androidmontreal.mvp.infrastructure.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.example.androidmontreal.R;
import com.example.androidmontreal.mvp.domain.models.RaceResultsModelObserver;
import com.example.androidmontreal.mvp.domain.presenters.Presenter;
import com.example.androidmontreal.mvp.domain.presenters.RaceResultsViewPresenter;
import com.example.androidmontreal.mvp.domain.views.RaceResultsView;
import com.example.androidmontreal.utils.RaceResultUtil;

import java.util.ArrayList;

public class AndroidRaceResultsView extends LinearLayout implements RaceResultsModelObserver, RaceResultsView {

    private RaceResultsViewPresenter presenter;
    private ArrayList<String> results;
    private ArrayAdapter<String> resultsAdapter;

    public AndroidRaceResultsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        results = new ArrayList<String>();
        resultsAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, results);
    }

    @Override
    public void plugWith(RaceResultsViewPresenter presenter) {
        this.presenter = presenter;
        presenter.plugView(this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        Button clearButton = (Button) findViewById(R.id.clear_button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClearButtonClicked();
            }
        });

        ListView resultList = (ListView) findViewById(R.id.race_results_list_view);
        resultList.setAdapter(resultsAdapter);
    }

    @Override
    public void clearRaceResultsList() {
        results.clear();
        resultsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRaceResultAdded(long result) {
        String resultAsString = RaceResultUtil.toString(result);
        results.add(resultAsString);
        resultsAdapter.notifyDataSetChanged();
    }
}