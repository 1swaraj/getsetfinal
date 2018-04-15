package com.getset.career.guidance;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * Created by root on 15/4/18.
 */

public class Pop4 extends Activity{
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
        tv.setText("1.When your colleague is no longer speaking, send her an instant\n" +
                "message explaining that she may benefit from slowing down a little\n" +
                "as there are a few people who are finding it difficult to understand\n" +
                "her in the room where you are.\n" +
                "2.After the call, acknowledge your concerns to the others in the room\n" +
                "and suggest that you all compare notes to make sure you have a\n" +
                "shared understanding of what she was actually saying.\n" +
                "3.Mention your concerns to the project lead after the call, offering to\n" +
                "speak to your colleague\n" +
                "4.Call your colleague afterwards to ask how she is finding the project\n" +
                "and tactfully mention that at times you found it difficult to understand\n" +
                "what she was saying, politely suggesting that just slowing down a\n" +
                "little would help.");
    }
}
