package com.example.tinku.projectmanagementsystem.fragment.login;

import android.view.View;

/**
 * Created by KinhangPoon on 5/3/2018.
 */

public interface LoginView {
    public void updateView(View view);
    public void showToast(String s);
    public void saveSection(String email, String password, String userid);
    public void switchToUserActivity();
}
