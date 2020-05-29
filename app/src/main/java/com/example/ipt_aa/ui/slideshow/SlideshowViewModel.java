package com.example.ipt_aa.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ipt_aa.Model.CourseGrade;
import com.example.ipt_aa.Model.SemesterTranscript;

import java.util.ArrayList;
import java.util.List;

public class SlideshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public interface marks {
        void onEvent(boolean is);
    }

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
        listener.onEvent(false);

    }

    static marks listener;

    public static void setOnEventListener(marks li) {
        listener = li;
    }

    public LiveData<SemesterTranscript> getText() {

        return getTranscriptData("k163632");


    }

    public LiveData<SemesterTranscript> getTranscriptData(String id) {
        MutableLiveData<SemesterTranscript> semesterTranscript = new MutableLiveData<>();
        List<CourseGrade> courseGrades = new ArrayList<>();
        SemesterTranscript semesterTranscript1 = new SemesterTranscript("15", "15", "3", "3", courseGrades);

        semesterTranscript.setValue(semesterTranscript1);
        return semesterTranscript;
    }
}