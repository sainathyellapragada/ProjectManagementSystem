package com.example.tinku.projectmanagementsystem.model;

/**
 * Created by KinhangPoon on 5/3/2018.
 */

public class Task {
    String projectid,taskid,subtaskid;

    public Task(String projectid, String taskid, String subtaskid) {
        this.projectid = projectid;
        this.taskid = taskid;
        this.subtaskid = subtaskid;
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getSubtaskid() {
        return subtaskid;
    }

    public void setSubtaskid(String subtaskid) {
        this.subtaskid = subtaskid;
    }
}
