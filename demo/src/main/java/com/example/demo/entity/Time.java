package com.example.demo.entity;

import java.sql.Timestamp;

public class Time {
    private long id;
    private String time;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    // public void setTime(Timestamp time) {
    //     this.time = time;
    // }
    //
    // public Timestamp getTime() {
    //     return time;
    // }

    @Override
    public String toString() {
        return "id: " + id + ", "
                + "time: " + time;
    }
}
