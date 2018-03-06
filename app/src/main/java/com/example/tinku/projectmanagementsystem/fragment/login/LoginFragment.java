package com.example.tinku.projectmanagementsystem.fragment.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.fragment.FragmentSwitch;
import com.example.tinku.projectmanagementsystem.ui.ActivitySwitch;


/**
 * Created by KinhangPoon on 3/3/2018.
 */

public class LoginFragment extends Fragment implements LoginView{
    /**
     * declaration
     */
    EditText editTextEmail,editTextPassword;
    Button buttonLogin,buttonForgot;
    SharedPreferences sharedPreferences;
    FragmentSwitch fragmentSwitch;
    ActivitySwitch activitySwitch;
    LoginPresenter presenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentSwitch = (FragmentSwitch) getActivity();
        activitySwitch = (ActivitySwitch) getActivity();
        presenter = new LoginPresenterImpl(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment,container,false);
        presenter.onCreatedView(view);

        return view;
    }


    @Override
    public void updateView(View view) {
        /**
         * initialization
         */
        sharedPreferences = getContext().getSharedPreferences("myinfo", Context.MODE_PRIVATE);

        editTextEmail = view.findViewById(R.id.editText_email_login);
        editTextPassword = view.findViewById(R.id.editText_password_login);
        buttonLogin = view.findViewById(R.id.button_login);
        buttonForgot = view.findViewById(R.id.button_forgot_login);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                /**
                 * use retrofit authenticate and interacte with APIs and sending network requests with OkHttp
                 */
                presenter.sendLoginRequest( email, password);

            }
        });
        buttonForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentSwitch.switchToForgot();
            }
        });
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void saveSection(String email, String password,String userid) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Email", email);
        editor.putString("Password", password);
        editor.putString("UserId", userid);
        editor.commit();
    }

    @Override
    public void switchToUserActivity() {
        activitySwitch.switchUserActivity();
    }
}
