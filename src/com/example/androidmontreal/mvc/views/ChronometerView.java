package com.example.androidmontreal.mvc.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.androidmontreal.R;
import com.example.androidmontreal.mvc.models.ChronometerModelObserver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChronometerView extends LinearLayout implements ObservableView, ChronometerModelObserver {

    private ViewObserver observer;
    private TextView timerText;
    private SimpleDateFormat timerFormat;
    private final Date date;
    private Button startButton;

    public ChronometerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        timerFormat = new SimpleDateFormat("mm:ss");
        date = new Date();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        timerText = (TextView) findViewById(R.id.timerText);

        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observer.onStartButtonClicked();
            }
        });

        Button resetButton = (Button) findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observer.onResetButtonClicked();
            }
        });
    }

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void onTimeChanged(long timeAmount) {
        date.setTime(timeAmount);
        timerText.setText(timerFormat.format(date));
    }

    public void displayStopButton() {
        startButton.setText(R.string.stop_time);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observer.onStopButtonClicked();
            }
        });
    }

    public void displayResumeButton() {
        startButton.setText(R.string.resume_time);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observer.onStartButtonClicked();
            }
        });
    }

    public void displayStartButton() {
        startButton.setText(R.string.start_time);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observer.onStartButtonClicked();
            }
        });
    }
}
