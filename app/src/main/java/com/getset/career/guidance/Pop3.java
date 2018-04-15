package com.getset.career.guidance;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * Created by root on 15/4/18.
 */

public class Pop3 extends Activity{
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
        tv.setText("A = Explain your situation and ask the person calling from head office\n" +
                "how they would like you to priorities your day.\n" +
                "B= Take up to an hour to try to re-plan your\n" +
                "day and call them back with your response.\n" +
                "C = Offer to call round a number of other local clubs to try and find\n" +
                "another manager who might be able to support\n" +
                "D = Agree to spend half a day at the other club and simply take the\n" +
                "paperwork with you.");
    }
}
