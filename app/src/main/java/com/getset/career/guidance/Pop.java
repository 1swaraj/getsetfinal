package com.getset.career.guidance;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * Created by root on 15/4/18.
 */

public class Pop extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width=dm.widthPixels;
        int height=dm.heightPixels;
        getWindow().setLayout((int)(width*0.6),(int)(height*0.6));
        TextView tv = findViewById(R.id.textView);
        tv.setText("A - Gather more evidence and catch her red-handed.\n" +
                "B - Confront your colleague and ask her about what you have noticed.\n" +
                "C - Inform your manager that you suspect your colleague is stealing.\n" +
                "D - Don't do anything. If guilty your colleague will be caught.");
    }
}
