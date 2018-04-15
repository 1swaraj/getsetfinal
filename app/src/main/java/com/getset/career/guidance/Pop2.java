package com.getset.career.guidance;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * Created by root on 15/4/18.
 */

public class Pop2 extends Activity{
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
        tv.setText("1. You apologise to the customer, tell them you’ll look into it and hang up. You re-arrange the\n" +
                "delivery and call the customer back with the new delivery date.\n\n" +
                "2. Advise the customer that the company is very busy and that their goods will be with them as soon\n" +
                "as possible.\n\n" +
                "3. Agree with the customer: The service is terrible.\n\n" +
                "4. Advise the customer to stay on the line, whilst you speak to the delivery driver and get a time slot\n" +
                "for delivery.");
    }
}
