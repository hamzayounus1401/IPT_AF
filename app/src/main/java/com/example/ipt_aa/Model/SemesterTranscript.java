package com.example.ipt_aa.Model;

import java.util.List;

public class SemesterTranscript {
    String crAtt;
    String crEar;
    String cgpa;
    String sgpa;
    List<CourseGrade> courseGrades;

    public String getCrAtt() {
        return crAtt;
    }

    public void setCrAtt(String crAtt) {
        this.crAtt = crAtt;
    }

    public String getCrEar() {
        return crEar;
    }

    public void setCrEar(String crEar) {
        this.crEar = crEar;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getSgpa() {
        return sgpa;
    }

    public void setSgpa(String sgpa) {
        this.sgpa = sgpa;
    }

    public List<CourseGrade> getCourseGrades() {
        return courseGrades;
    }

    public void setCourseGrades(List<CourseGrade> courseGrades) {
        this.courseGrades = courseGrades;
    }

    public SemesterTranscript(String crAtt, String crEar, String cgpa, String sgpa, List<CourseGrade> courseGrades) {
        this.crAtt = crAtt;
        this.crEar = crEar;
        this.cgpa = cgpa;
        this.sgpa = sgpa;
        this.courseGrades = courseGrades;
    }

    public SemesterTranscript() {
    }
}
