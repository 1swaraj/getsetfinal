package com.getset.career.guidance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Ptest extends AppCompatActivity {
    ImageView question;
    Button option1,option2;
    DatabaseReference mDatabase;
    int questionno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptest);
        question=(ImageView) findViewById(R.id.question);
        option1=(Button)findViewById(R.id.option1);
        option2=(Button)findViewById(R.id.option2);
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
                question.setImageResource(R.drawable.pq1);
                break;

            case 2:
                question.setImageResource(R.drawable.pq2);
                break;

            case 3:
                question.setImageResource(R.drawable.pq3);
                break;

            case 4:
                question.setImageResource(R.drawable.pq4);
                break;

            case 5:
                question.setImageResource(R.drawable.pq5);
                break;

            case 6:
                question.setImageResource(R.drawable.pq6);
                break;

            case 7:
                question.setImageResource(R.drawable.pq7);

                break;

            case 8:
                question.setImageResource(R.drawable.pq8);

                break;

            case 9:
                question.setImageResource(R.drawable.pq9);

                break;

            case 10:
                question.setImageResource(R.drawable.pq10);
                break;


            case 11:
                question.setImageResource(R.drawable.pq11);
                break;

            case 12:
                question.setImageResource(R.drawable.pq12);
                break;

            case 13:
                question.setImageResource(R.drawable.pq13);
                break;

            case 14:
                question.setImageResource(R.drawable.pq14);
                break;

            case 15:
                question.setImageResource(R.drawable.pq15);
                break;

            case 16:
                question.setImageResource(R.drawable.pq16);
                break;

            case 17:
                question.setImageResource(R.drawable.pq17);

                break;

            case 18:
                question.setImageResource(R.drawable.pq18);

                break;

            default:
                Intent intent = new Intent(Ptest.this,Result.class);
                startActivity(intent);
        }

        String token= String.valueOf(AccessToken.getCurrentAccessToken().getUserId());
        mDatabase = FirebaseDatabase.getInstance().getReference(token);
        option1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mDatabase.child(String.valueOf("p"+questionno)).setValue("1");
                Intent intent = new Intent(Ptest.this,Ptest.class);
                intent.putExtra("question", String.valueOf(questionno +1));
                startActivity(intent);
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mDatabase.child(String.valueOf("p"+questionno)).setValue("2");
                Intent intent = new Intent(Ptest.this,Ptest.class);
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
