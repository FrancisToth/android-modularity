package com.example.androidmontreal.mvp.domain.presenters;

public interface Presenter<ViewType> {

    void plugView(ViewType view);
}
