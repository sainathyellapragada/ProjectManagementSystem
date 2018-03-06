package com.example.tinku.projectmanagementsystem.fragment.login;

import android.view.View;

/**
 * Created by KinhangPoon on 5/3/2018.
 */

public interface LoginPresenter {
    public void onCreatedView(View view);
    public void sendLoginRequest(String email, String password);
}
