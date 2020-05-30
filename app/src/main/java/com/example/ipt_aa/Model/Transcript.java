package com.example.ipt_aa.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Transcript {

    @SerializedName("semesterYear")
    @Expose
    private Integer semesterYear;
    @SerializedName("semesterSeason")
    @Expose
    private String semesterSeason;
    @SerializedName("sgpa")
    @Expose
    private Integer sgpa;
    @SerializedName("creditsAttempted")
    @Expose
    private Integer creditsAttempted;
    @SerializedName("creditsEarned")
    @Expose
    private Integer creditsEarned;
    @SerializedName("courses")
    @Expose
    private List<Course> courses = null;

    public Integer getSemesterYear() {
        return semesterYear;
    }

    public void setSemesterYear(Integer semesterYear) {
        this.semesterYear = semesterYear;
    }

    public String getSemesterSeason() {
        return semesterSeason;
    }

    public void setSemesterSeason(String semesterSeason) {
        this.semesterSeason = semesterSeason;
    }

    public Integer getSgpa() {
        return sgpa;
    }

    public void setSgpa(Integer sgpa) {
        this.sgpa = sgpa;
    }

    public Integer getCreditsAttempted() {
        return creditsAttempted;
    }

    public void setCreditsAttempted(Integer creditsAttempted) {
        this.creditsAttempted = creditsAttempted;
    }

    public Integer getCreditsEarned() {
        return creditsEarned;
    }

    public void setCreditsEarned(Integer creditsEarned) {
        this.creditsEarned = creditsEarned;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}