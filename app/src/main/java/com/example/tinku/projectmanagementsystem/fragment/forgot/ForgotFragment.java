package com.example.tinku.projectmanagementsystem.fragment.forgot;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.model.ForgotResponse;
import com.example.tinku.projectmanagementsystem.network.RetrofitInstance;
import com.example.tinku.projectmanagementsystem.network.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by KinhangPoon on 3/3/2018.
 */

public class ForgotFragment extends Fragment implements ForgotFragmentView{
    /**
     * declaration
     */
    EditText editTextEmail;
    Button buttonGetPassword;
    ForgotPresenterImpl presenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter = new ForgotPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forgot_fragment,container,false);

        presenter.onViewCreated(view);

        return view;
    }

    @Override
    public void updateView(View view) {
        /**
         * initialization
         */
        editTextEmail = view.findViewById(R.id.editText_forgot_email);
        buttonGetPassword = view.findViewById(R.id.button_get_password);

        buttonGetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                /**
                 * use retrofit authenticate and interacte with APIs and sending network requests with OkHttp
                 */
                sendForgotRequest(email);
            }
        });
    }
    public void sendForgotRequest(String email){
        UserService service = RetrofitInstance.getRetrofitInstance().create(UserService.class);
        Call<ForgotResponse> call = service.getPassword(email);
        call.enqueue(new Callback<ForgotResponse>() {
            @Override
            public void onResponse(Call<ForgotResponse> call, Response<ForgotResponse> response) {

                Log.i("forgot", response.body().getUserpassword());
                Toast.makeText(getContext(), response.body().getUserpassword(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ForgotResponse> call, Throwable t) {
                Log.i("forgot",t.getMessage());
                Toast.makeText(getContext(),"Wrong Email",Toast.LENGTH_LONG).show();
            }
        });
    }
}
