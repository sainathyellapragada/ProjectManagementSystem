package com.example.tinku.projectmanagementsystem.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by KinhangPoon on 5/3/2018.
 */

public interface UserService {
    @GET("pms_login.php")
    public Call<UserInfo> getUserInforDetail(@Query("email") String email, @Query("password") String password);

    @GET("pms_forgot_pass.php")
    public Call<ForgotResponse> getPassword(@Query("email") String email);

    @GET("pms_view_task.php")
    public Call<TaskResponse> getTaskList(@Query("user_id") String user_id);

    @GET("pms_view_task_deatil.php")
    public Call<DetailResponse> getTaskDetail(@Query("taskid") String taskid,@Query("project_id") String productid);
}