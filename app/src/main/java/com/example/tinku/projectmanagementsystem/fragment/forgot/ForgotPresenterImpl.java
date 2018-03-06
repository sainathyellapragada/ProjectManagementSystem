package com.example.tinku.projectmanagementsystem.fragment.forgot;

import android.view.View;

/**
 * Created by KinhangPoon on 5/3/2018.
 */

public class ForgotPresenterImpl implements ForgotPresenter {
    ForgotFragmentView forgotFragmentView;

    public ForgotPresenterImpl(ForgotFragment forgotFragment) {
        forgotFragmentView = forgotFragment;
    }

    @Override
    public void onViewCreated(View view) {
        forgotFragmentView.updateView(view);
    }
}
