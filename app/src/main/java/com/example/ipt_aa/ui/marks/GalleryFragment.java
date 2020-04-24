package com.example.ipt_aa.ui.marks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.ipt_aa.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {
    private GalleryViewModel galleryViewModel;
    ListView listView;
    ArrayAdapter adapter;
    List<String> list = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);


        return root;
    }
}