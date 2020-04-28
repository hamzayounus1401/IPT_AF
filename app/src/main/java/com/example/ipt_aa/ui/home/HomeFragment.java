package com.example.ipt_aa.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.ipt_aa.R;

import java.util.ArrayList;
import java.util.List;

import me.ithebk.barchart.BarChart;
import me.ithebk.barchart.BarChartModel;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    TableLayout mTableLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TextView tv;
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        BarChart barChart = (BarChart) root.findViewById(R.id.bar_chart_vertical);

        barChart.setBarMaxValue(4);
        BarChartModel barChartModel = new BarChartModel();
        barChartModel.setBarValue(3);
        barChartModel.setBarColor(Color.parseColor("#9C27B0"));
        barChartModel.setBarTag("Code"); //You can set your own tag to bar model
        barChartModel.setBarText("3");
        barChart.setHovered(true);


        List<BarChartModel> barChartModelList = new ArrayList<>();
        barChartModelList.add(barChartModel);
        barChartModelList.add(barChartModel);
        barChartModelList.add(barChartModel);
        barChartModelList.add(barChartModel);
        barChartModelList.add(barChartModel);
        barChartModelList.add(barChartModel);
        barChartModelList.add(barChartModel);
        barChartModelList.add(barChartModel);


//populate bar array list and add to barchart as a list.
        barChart.addBar(barChartModelList);
        barChart.animate().setDuration(400);

        return root;
    }

}