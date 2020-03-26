package com.example.ipt_aa.ui.marks;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ipt_aa.R;
import com.example.ipt_aa.SubjectMarks;

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
        listView = root.findViewById(R.id.marks_list_view);
        list.add("Subjects");
        adapter = new ArrayAdapter<String>(getContext(), R.layout.listview_item_marks, list);
        listView.setAdapter(adapter);
        galleryViewModel.getList().observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                list.clear();
                for (String s :
                        strings) {
                    list.add(s);
                }
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), SubjectMarks.class);
                startActivity(intent);

            }
        });

        return root;
    }
}