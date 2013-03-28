package com.example.androidmontreal.mvp.infrastructure.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.androidmontreal.R;
import com.example.androidmontreal.mvp.domain.presenters.ChronometerViewPresenter;
import com.example.androidmontreal.mvp.domain.views.ChronometerView;
import com.example.androidmontreal.utils.RaceResultUtil;

public class AndroidChronometerView extends LinearLayout implements ChronometerView {

    private TextView timerText;
    private Button startButton;

    private ChronometerViewPresenter presenter;

    public AndroidChronometerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void plugWith(ChronometerViewPresenter presenter) {
        this.presenter = presenter;
        presenter.plugView(this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        timerText = (TextView) findViewById(R.id.timerText);

        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onStartButtonClicked();
            }
        });

        Button resetButton = (Button) findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onResetButtonClicked();
            }
        });
    }

    @Override
    public void displayStartButton() {
        startButton.setText(R.string.start_time);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onStartButtonClicked();
            }
        });
    }

    @Override
    public void onTimeChanged(long timeAmount) {
        String timeAmountAsString = RaceResultUtil.toString(timeAmount);
        timerText.setText(timeAmountAsString);
    }

    @Override
    public void displayStopButton() {
        startButton.setText(R.string.stop_time);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onStopButtonClicked();
            }
        });
    }

    @Override
    public void displayResumeButton() {
        startButton.setText(R.string.resume_time);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onStartButtonClicked();
            }
        });
    }
}