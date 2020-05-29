package com.example.ipt_aa;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    private ViewPager2 viewPager2;
    private Context context;

    //   private int[] colorArray = new int[]{android.R.color.black, android.R.color.holo_blue_dark, android.R.color.holo_green_dark, android.R.color.holo_red_dark};

    public ViewPagerAdapter(Context context, List<String> data, ViewPager2 viewPager2) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = data;
        this.viewPager2 = viewPager2;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_viewpager, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String animal = mData.get(position);

        holder.myTextView.setText("Hamza");
        holder.t2.setText("Hamza");
        holder.t3.setText("Haris");


        for (int i = 0; i < 5; i++) {

            TableRow tr = new TableRow(context);
            tr.setPadding(10, 10, 10, 10);
            TextView c1 = new TextView(context);
            TextView c2 = new TextView(context);
            TextView c3 = new TextView(context);
            TextView c4 = new TextView(context);
            TextView c5 = new TextView(context);
            TextView c6 = new TextView(context);
            TextView c7 = new TextView(context);
            TextView c8 = new TextView(context);
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
            holder.mtablelayout.addView(tr);
        }


        //     holder.relativeLayout.setBackgroundResource(colorArray[position]);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView, t2, t3, t4, t5, t6;
        RelativeLayout relativeLayout;
        Button button;
        TableLayout mtablelayout;

        ViewHolder(final View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.we1);
            t2 = itemView.findViewById(R.id.we2);
            t3 = itemView.findViewById(R.id.we3);
            relativeLayout = itemView.findViewById(R.id.container);
            mtablelayout = itemView.findViewById(R.id.table);

            myTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager2.setCurrentItem(4);

                }
            });
        }
    }

}
