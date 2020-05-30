package com.example.ipt_aa.ui.slideshow;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ipt_aa.Model.Course;
import com.example.ipt_aa.Model.Transcript;
import com.example.ipt_aa.R;

import java.util.List;


public class SlideshowFragment extends Fragment {
    ProgressBar progressBar;
    TableLayout mtablelayout;
    SlideshowViewModel slideshowViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel = ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        mtablelayout = root.findViewById(R.id.table1);
        progressBar = root.findViewById(R.id.f_s_p_b);


        mtablelayout.removeAllViewsInLayout();

        slideshowViewModel.getTranscript().observe(this, new Observer<List<Transcript>>() {
            @Override
            public void onChanged(List<Transcript> transcripts) {
                for (Transcript transcript :
                        transcripts) {
                    TableRow tr = new TableRow(getContext());
                    TextView c1 = new TextView(getContext());
                    TextView c2 = new TextView(getContext());
                    TextView c30 = new TextView(getContext());
                    TextView c31 = new TextView(getContext());
                    c1.setTextSize(20);
                    c1.setPadding(20, 20, 20, 20);
                    c2.setPadding(20, 20, 20, 20);
                    c31.setPadding(20, 20, 20, 20);
                    c30.setPadding(20, 20, 20, 20);

                    c1.setText(transcript.getSemesterSeason().toUpperCase());
                    c2.setText(String.valueOf(transcript.getSemesterYear()));
                    c30.setText("");
                    c31.setText("SGPA: " + String.valueOf(transcript.getSgpa()));
                    tr.addView(c1);
                    tr.addView(c2);
                    tr.addView(c30);
                    tr.addView(c31);
                    mtablelayout.addView(tr);

                    TableRow tr2 = new TableRow(getContext());
                    tr2.setPadding(10, 10, 10, 10);
                    TextView c11 = new TextView(getContext());
                    TextView c22 = new TextView(getContext());
                    TextView c3 = new TextView(getContext());
                    TextView c4 = new TextView(getContext());
                    TextView c5 = new TextView(getContext());
                    TextView c6 = new TextView(getContext());
                    TextView c7 = new TextView(getContext());
                    tr2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.dark_slate_blue));

                    c11.setPadding(20, 20, 20, 20);
                    c22.setPadding(20, 20, 20, 20);
                    c3.setPadding(20, 20, 20, 20);
                    c4.setPadding(20, 20, 20, 20);
                    c5.setPadding(20, 20, 20, 20);
                    c6.setPadding(20, 20, 20, 20);
                    c7.setPadding(20, 20, 20, 20);
                    c11.setTextColor(Color.WHITE);
                    c22.setTextColor(Color.WHITE);
                    c3.setTextColor(Color.WHITE);
                    c4.setTextColor(Color.WHITE);
                    c5.setTextColor(Color.WHITE);
                    c6.setTextColor(Color.WHITE);
                    c7.setTextColor(Color.WHITE);
                    c11.setText("Code");
                    c22.setText(String.valueOf("Course Name"));
                    c3.setText(String.valueOf("Crd Hrs"));
                    c4.setText("Grade");
                    c5.setText(String.valueOf("Points"));
                    c6.setText(String.valueOf("Type"));
                    c7.setText("Remarks");

                    tr2.addView(c11);
                    tr2.addView(c22);
                    tr2.addView(c3);
                    tr2.addView(c4);
                    tr2.addView(c5);
                    tr2.addView(c6);
                    tr2.addView(c7);
                    mtablelayout.addView(tr2);


                    for (Course course :
                            transcript.getCourses()) {
                        TableRow tr3 = new TableRow(getContext());
                        tr3.setPadding(10, 10, 10, 10);
                        TextView c111 = new TextView(getContext());
                        TextView c222 = new TextView(getContext());
                        TextView c33 = new TextView(getContext());
                        TextView c44 = new TextView(getContext());
                        TextView c55 = new TextView(getContext());
                        TextView c66 = new TextView(getContext());
                        TextView c77 = new TextView(getContext());

                        c111.setPadding(20, 20, 20, 20);
                        c222.setPadding(20, 20, 20, 20);
                        c33.setPadding(20, 20, 20, 20);
                        c44.setPadding(20, 20, 20, 20);
                        c55.setPadding(20, 20, 20, 20);
                        c66.setPadding(20, 20, 20, 20);
                        c77.setPadding(20, 20, 20, 20);

                        c111.setText(course.getCode().toUpperCase());
                        c222.setText(String.valueOf(course.getName().toUpperCase()));
                        c33.setText(String.valueOf(course.getCreditHours()));
                        c44.setText(String.valueOf(course.getGrade()));
                        c55.setText(String.valueOf(course.getGrade()));
                        c66.setText(course.getType());
                        c77.setText("Remarks");
                        tr3.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.face_light_blue));

                        tr3.addView(c111);
                        tr3.addView(c222);
                        tr3.addView(c33);
                        tr3.addView(c44);
                        tr3.addView(c55);
                        tr3.addView(c66);
                        tr3.addView(c77);
                        mtablelayout.addView(tr3);

                    }
                    TableRow tableRow = new TableRow(getContext());
                    TextView textView = new TextView(getContext());
                    tableRow.addView(textView);
                    mtablelayout.addView(tableRow);
                }
                progressBar.setVisibility(View.GONE);
            }
        });
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void onPause() {
        super.onPause();

    }

}