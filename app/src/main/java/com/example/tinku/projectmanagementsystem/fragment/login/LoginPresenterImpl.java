package com.example.tinku.projectmanagementsystem.fragment.login;

import android.util.Log;
import android.view.View;

import com.example.tinku.projectmanagementsystem.model.UserInfo;
import com.example.tinku.projectmanagementsystem.network.RetrofitInstance;
import com.example.tinku.projectmanagementsystem.network.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KinhangPoon on 5/3/2018.
 */

public class LoginPresenterImpl implements LoginPresenter {
    LoginView loginView;
    public LoginPresenterImpl(LoginFragment loginFragment) {
        loginView = loginFragment;
    }

    @Override
    public void onCreatedView(View view) {
        loginView.updateView(view);
    }

    @Override
    public void sendLoginRequest(final String email, final String password) {
            UserService service = RetrofitInstance.getRetrofitInstance().create(UserService.class);

            Call<UserInfo> call = service.getUserInforDetail(email,password);

            call.enqueue(new Callback<UserInfo>() {
                @Override
                public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                    Log.i("Login", response.body().getMsg().toString());
                    Log.i("Login UserID",response.body().getUserid().toString());
                    String userid = response.body().getUserid().toString();
                    loginView.showToast(response.body().getMsg().toString());
                    /**
                     * save email and password to sharedPreferences, section maintain
                     */
                    loginView.saveSection(email,password,userid);

                    loginView.switchToUserActivity();

                }

                @Override
                public void onFailure(Call<UserInfo> call, Throwable t) {
                    Log.i("login",t.getMessage());
                    loginView.showToast("Fail to log in");
                }
            });
    }
}
