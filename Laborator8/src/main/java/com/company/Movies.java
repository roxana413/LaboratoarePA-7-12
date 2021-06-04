package com.company;

import java.sql.Date;

public class Movies {

    private Integer id ;
    private String title;
    private Date   relase_date;
    private Float  duration;
    private Float  score;


    public Movies(Integer id, String title, Date relase_date, Float duration, Float score) {
        this.id = id;
        this.title = title;
        this.relase_date = relase_date;
        this.duration = duration;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRelase_date() {
        return relase_date;
    }

    public void setRelase_date(Date relase_date) {
        this.relase_date = relase_date;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
