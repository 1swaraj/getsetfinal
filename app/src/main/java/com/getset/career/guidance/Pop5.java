package com.getset.career.guidance;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * Created by root on 15/4/18.
 */

public class Pop5 extends Activity{
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
        tv.setText("A = I will do all I can to help you with this issue. If you give me your\n" +
                "account details I will investigate what has happened here.\n" +
                "B = Let me check with the colleague you mentioned about what the\n" +
                "situation is. If you can hold for a couple of minutes I will speak to\n" +
                "them and will be back with you in no time.\n" +
                "C = Sir, I can hear that you are really upset but I need you to calm down\n" +
                "so that I can help you.\n" +
                "D = I am sure there is a logical explanation for this.If you give me your\n" +
                "details I will look into it for you.");
    }
}
