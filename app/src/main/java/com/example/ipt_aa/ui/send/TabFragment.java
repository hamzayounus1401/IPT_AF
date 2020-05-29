package com.example.ipt_aa.ui.send;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.alespero.expandablecardview.ExpandableCardView;
import com.example.ipt_aa.R;

public class TabFragment extends Fragment {
    String sub_code;
    TableLayout mtablelayout, mtablelayout2;

    public TabFragment(String code) {
        this.sub_code = code;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.tab_fragment, viewGroup, false);
        ExpandableCardView cardView = root.findViewById(R.id.t_f_p);


        mtablelayout = root.findViewById(R.id.t_f_table_layout);
        mtablelayout2 = root.findViewById(R.id.t_f_table_layout2);
        if (sub_code.equals("0"))
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

                tr.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.dark_slate_blue));

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


                } else if (i == 4) {

                    c1.setText("Grand Total/3");
                    c2.setText(String.valueOf("3"));
                    c3.setText(String.valueOf("6"));
                    c4.setText("8");
                    c5.setText(String.valueOf("12"));
                    c6.setText(String.valueOf("10"));
                    c7.setText("2");
                    c8.setText(String.valueOf("1"));

                    tr.setBackground(new ColorDrawable(Color.WHITE));
                } else {

                    c1.setText("Quiz/3");
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

        if (sub_code.equals("0"))
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

                tr.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.dark_slate_blue));

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


                } else if (i == 4) {

                    c1.setText("Grand Total/3");
                    c2.setText(String.valueOf("3"));
                    c3.setText(String.valueOf("6"));
                    c4.setText("8");
                    c5.setText(String.valueOf("12"));
                    c6.setText(String.valueOf("10"));
                    c7.setText("2");
                    c8.setText(String.valueOf("1"));

                    tr.setBackground(new ColorDrawable(Color.WHITE));
                } else {

                    c1.setText("Quiz/3");
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
                mtablelayout2.addView(tr);
            }


        return root;
    }
}
