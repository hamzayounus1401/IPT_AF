package com.example.ipt_aa.ui.slideshow;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ipt_aa.R;


public class SlideshowFragment extends Fragment {

    TableLayout mtablelayout;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        mtablelayout = root.findViewById(R.id.table1);

        for (int i = 0; i < 5; i++) {

            TableRow tr = new TableRow(getContext());
            tr.setPadding(10, 10, 10, 10);
            TextView c1 = new TextView(getContext());
            TextView c2 = new TextView(getContext());
            TextView c3 = new TextView(getContext());
            TextView c4 = new TextView(getContext());
            TextView c5 = new TextView(getContext());
            TextView c6 = new TextView(getContext());
            TextView c7 = new TextView(getContext());
            TextView c8 = new TextView(getContext());
            tr.setBackground(new ColorDrawable(Color.BLUE));

            if (i == 0) {

                c1.setText("Type/#");
                c2.setText(String.valueOf("Total"));
                c3.setText(String.valueOf("Obtain"));
                c4.setText("Wtg");
                c5.setText(String.valueOf("Avg"));
                c6.setText(String.valueOf("Std"));
                c7.setText("Min");
                c8.setText(String.valueOf("Max"));

                c1.setTextColor(Color.WHITE);
                c2.setTextColor(Color.WHITE);
                c3.setTextColor(Color.WHITE);
                c4.setTextColor(Color.WHITE);
                c5.setTextColor(Color.WHITE);
                c6.setTextColor(Color.WHITE);
                c7.setTextColor(Color.WHITE);
                c8.setTextColor(Color.WHITE);


            } else {

                c1.setText("QUIZ/3");
                c2.setText(String.valueOf("3"));
                c3.setText(String.valueOf("3"));
                c4.setText("4");
                c5.setText(String.valueOf("5"));
                c6.setText(String.valueOf("5"));
                c7.setText("2");
                c8.setText(String.valueOf("1"));

                tr.setBackground(new ColorDrawable(Color.WHITE));
            }


            c1.setPadding(20, 20, 20, 20);
            c2.setPadding(20, 20, 20, 20);
            c3.setPadding(20, 20, 20, 20);
            c4.setPadding(20, 20, 20, 20);
            c5.setPadding(20, 20, 20, 20);
            c6.setPadding(20, 20, 20, 20);
            c7.setPadding(20, 20, 20, 20);
            c8.setPadding(20, 20, 20, 20);

            tr.addView(c1);
            tr.addView(c2);
            tr.addView(c3);
            tr.addView(c4);
            tr.addView(c5);
            tr.addView(c6);
            tr.addView(c7);
            tr.addView(c8);

            tr.setHorizontalScrollBarEnabled(true);
            mtablelayout.addView(tr);
        }
        return root;
    }

}