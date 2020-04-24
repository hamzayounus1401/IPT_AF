package com.example.ipt_aa;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubjectMarks extends AppCompatActivity {


    private TableLayout mTableLayout;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_marks);


        TableLayout t1 = (TableLayout) findViewById(R.id.main_table);
        t1.setStretchAllColumns(true);
        int row;
        t1.removeAllViews();

        for (int i = -1; i > 3; i++) {

            if (i > -1)
                row = 3;
            else {
            }


            final TextView tv = new TextView(this);
            tv.setLayoutParams(new
                    TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tv.setGravity(Gravity.LEFT);
            tv.setPadding(5, 15, 0, 15);
            if (i == -1) {
                tv.setText("Inv.#");
                tv.setBackgroundColor(Color.parseColor("#f0f0f0"));
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX);
            }

        }
    }
}


