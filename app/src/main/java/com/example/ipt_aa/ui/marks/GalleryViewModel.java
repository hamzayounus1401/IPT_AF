package com.example.ipt_aa.ui.marks;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<List<String>> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        List<String> strings = new ArrayList<>();
        strings.add("   Ipt");
        strings.add("   ds");
        strings.add("   wp");
        strings.add("   project I");
        strings.add("   Rm");


        mText.setValue(strings);

    }

    public LiveData<List<String>> getList() {
        return mText;
    }
}