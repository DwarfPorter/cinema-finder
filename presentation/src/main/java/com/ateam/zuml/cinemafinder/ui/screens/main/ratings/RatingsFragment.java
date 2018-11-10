package com.ateam.zuml.cinemafinder.ui.screens.main.ratings;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.ateam.zuml.cinemafinder.App;
import com.ateam.zuml.cinemafinder.R;
import com.ateam.zuml.cinemafinder.ui.BaseFragment;
import com.ateam.zuml.cinemafinder.ui.common.BackButtonListener;

public class RatingsFragment extends BaseFragment implements RatingsView, BackButtonListener {

    @InjectPresenter RatingsPresenter presenter;

    public static RatingsFragment newInstance() {
        return new RatingsFragment();
    }

    @ProvidePresenter
    RatingsPresenter provideRatingsPresenter() {
        RatingsPresenter presenter = new RatingsPresenter();
        App.getApp().getAppComponent().inject(presenter);
        return presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ratings, container, false);
        setupToolbar(R.string.ratings, false);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    // #################################### BackButtonListener ###################################

    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }
}
