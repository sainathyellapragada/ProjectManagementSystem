package com.example.tinku.projectmanagementsystem.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KinhangPoon on 5/3/2018.
 */

public class TaskResponse {
    @SerializedName("view tasks")
    private List<Task> tasksview;

    public TaskResponse(List<Task> tasksview) {
        this.tasksview = tasksview;
    }

    public List<Task> getTasksview() {
        return tasksview;
    }

    public void setTasksview(List<Task> tasksview) {
        this.tasksview = tasksview;
    }
}
