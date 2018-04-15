package com.getset.career.guidance;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.facebook.AccessToken;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.URI;

public class SJT extends AppCompatActivity {
    VideoView question;
    int questionno;
    DatabaseReference mDatabase;
    Button option1,option2,option3,option4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sjt);
        question=(VideoView) findViewById(R.id.question);
        option1=(Button)findViewById(R.id.option1);

        option2=(Button)findViewById(R.id.option2);

        option3=(Button)findViewById(R.id.option3);

        option4=(Button)findViewById(R.id.option4);
        Uri uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sjt1);
        question.setVideoURI(uri);
        question.start();
        MediaController mediaController = new MediaController(this);
        question.setMediaController(mediaController);
        question.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(getBaseContext(),"How will you react?",Toast.LENGTH_LONG).show();
            }
        });
        try
        {
            String value="0";
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                value = bundle.getString("question");
            }
            questionno=Integer.parseInt(value);
        }
        catch (Exception e) {
            questionno = 0;
        }
        switch (questionno+1)
        {
            case 1:
                option1.setText("Embarrasment");
                option2.setText("Fear");
                option3.setText("Sadness");
                option4.setText("Surprise");
                uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sjt1);
                question.setVideoURI(uri);
                break;

            case 2:
                option1.setText("Flirtatiousness");
                option2.setText("Interest");
                option3.setText("Happiness");
                option4.setText("Politeness");
                uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sjt2);
                question.setVideoURI(uri);
                break;

            case 3:

                option1.setText("Sadness");
                option2.setText("Pain");
                option3.setText("Anger");
                option4.setText("Disgust");
                uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sjt3);
                question.setVideoURI(uri);
                break;

            case 4:
                option1.setText("Embarrassment");
                option2.setText("Sadness");
                option3.setText("Amusement");
                option4.setText("Shame");
                uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sjt4);
                question.setVideoURI(uri);
                break;

            case 5:
                option1.setText("Pride");
                option2.setText("Contempt");
                option3.setText("Excitement");
                option4.setText("Anger");
                uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sjt5);
                question.setVideoURI(uri);
                break;

            default:
                Intent intent = new Intent(SJT.this,EQTest.class);
                startActivity(intent);
        }
        String token= String.valueOf(AccessToken.getCurrentAccessToken().getUserId());
        mDatabase = FirebaseDatabase.getInstance().getReference(token);
        option1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mDatabase.child(String.valueOf(questionno)).setValue("1");
                Intent intent = new Intent(SJT.this,SJT.class);
                intent.putExtra("question", String.valueOf(questionno +1));
                startActivity(intent);
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mDatabase.child(String.valueOf(questionno)).setValue("2");
                Intent intent = new Intent(SJT.this,SJT.class);
                intent.putExtra("question", String.valueOf(questionno +1));
                startActivity(intent);
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mDatabase.child(String.valueOf(questionno)).setValue("3");
                Intent intent = new Intent(SJT.this,SJT.class);
                intent.putExtra("question", String.valueOf(questionno +1));
                startActivity(intent);
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mDatabase.child(String.valueOf(questionno)).setValue("4");
                Intent intent = new Intent(SJT.this,SJT.class);
                intent.putExtra("question", String.valueOf(questionno +1));
                startActivity(intent);
            }
        });
    }
    protected void onPause()
    {
        super.onPause();
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
    }
}
