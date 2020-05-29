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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.ipt_aa.R;
import com.example.ipt_aa.Room.Models.Account;

import java.util.ArrayList;
import java.util.List;

import me.ithebk.barchart.BarChart;
import me.ithebk.barchart.BarChartModel;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private TableLayout mTableLayout;
    private TextView tv_rollNo, tv_campus, tv_current_address, tv_phone, tv_status, tv_batch, tv_section, tv_degree, tv_name, tv_email, tv_dob, tv_cnic, tv_nationality, tv_gender, tv_bloodgroup;
    private SwipeRefreshLayout pullToRefresh;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TextView tv;
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        pullToRefresh = root.findViewById(R.id.f_h_s_r_l);
        tv_rollNo = root.findViewById(R.id.u_d_roll_no);
        tv_campus = root.findViewById(R.id.u_d_campus);
        tv_section = root.findViewById(R.id.u_d_section);
        tv_status = root.findViewById(R.id.u_d_status);
        tv_batch = root.findViewById(R.id.u_d_batch);
        tv_degree = root.findViewById(R.id.u_d_degree);
        tv_name = root.findViewById(R.id.p_i_name);
        tv_cnic = root.findViewById(R.id.p_i_cnic);
        tv_email = root.findViewById(R.id.p_i_email);
        tv_dob = root.findViewById(R.id.p_i_dob);
        tv_gender = root.findViewById(R.id.p_i_gender);
        tv_nationality = root.findViewById(R.id.p_i_nationality);
        tv_bloodgroup = root.findViewById(R.id.p_i_bloodgroup);
        tv_current_address = root.findViewById(R.id.c_i_address);
        tv_phone = root.findViewById(R.id.c_i_phone);
        pullToRefresh.setOnRefreshListener(listenerSwipeRefresh);

        homeViewModel.getAccount().observe(this, new Observer<Account>() {
            @Override
            public void onChanged(Account account) {
                if (account != null) {
                    //University Details
                    tv_rollNo.setText(account.id);
                    tv_status.setText(account.status);
                    tv_section.setText("Nan");
                    tv_campus.setText("Nan");
                    tv_batch.setText("Nan");
                    tv_degree.setText("Nan");
                    //Personel Details/
                    tv_name.setText(account.fullName);
                    tv_email.setText(account.email);
                    tv_dob.setText(account.dob);
                    tv_cnic.setText(account.cnic);
                    tv_gender.setText("");
                    tv_nationality.setText("");
                    tv_bloodgroup.setText("");
                    //Contact Information
                    tv_phone.setText(account.phone);
                    tv_current_address.setText(account.address);

                }
            }
        });


        BarChart barChart = (BarChart) root.findViewById(R.id.bar_chart_vertical);
        tv = root.findViewById(R.id.u_d_roll_no);

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

    SwipeRefreshLayout.OnRefreshListener listenerSwipeRefresh
            = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            homeViewModel.RefreshPage();
            pullToRefresh.setRefreshing(false);

        }
    };

    @Override
    public void onStart() {
        super.onStart();
        homeViewModel.RefreshPage();
    }
}