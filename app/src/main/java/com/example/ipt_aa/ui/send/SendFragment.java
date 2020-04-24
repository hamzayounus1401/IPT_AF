package com.example.ipt_aa.ui.send;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager2.widget.ViewPager2;

import com.example.ipt_aa.R;
import com.example.ipt_aa.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SendFragment extends Fragment {

    private SendViewModel sendViewModel;
    public ViewPager2 viewPager2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendViewModel =
                ViewModelProviders.of(this).get(SendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_send, container, false);
        viewPager2 = root.findViewById(R.id.viewPager2);

        List<String> list = new ArrayList<>();
        list.add("First Screen");
        list.add("Second Screen");
        list.add("Third Screen");
        list.add("Fourth Screen");

        viewPager2.setAdapter(new ViewPagerAdapter(getContext(), list, viewPager2));

        return root;
    }
}