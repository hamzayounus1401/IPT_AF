package com.example.ipt_aa.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ipt_aa.R;
import com.github.barteksc.pdfviewer.PDFView;


public class SlideshowFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        PDFView pdfView = (PDFView) root.findViewById(R.id.pdfView);
        pdfView.fromAsset("flexstudent.pdf").load();
        return root;
    }

}