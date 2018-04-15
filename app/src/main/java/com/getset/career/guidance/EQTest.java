package com.getset.career.guidance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.AccessToken;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class EQTest extends AppCompatActivity {
    ImageView question;
    int questionno;
    DatabaseReference mDatabase;
    Button option1,option2,option3,option4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eqtest);
        question=(ImageView) findViewById(R.id.question);
        option1=(Button)findViewById(R.id.option1);

        option2=(Button)findViewById(R.id.option2);

        option3=(Button)findViewById(R.id.option3);

        option4=(Button)findViewById(R.id.option4);
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
                question.setImageResource(R.drawable.q1);
                break;

            case 2:
                option1.setText("Flirtatiousness");
                option2.setText("Interest");
                option3.setText("Happiness");
                option4.setText("Politeness");

                question.setImageResource(R.drawable.q2);
                break;

            case 3:

                option1.setText("Sadness");
                option2.setText("Pain");
                option3.setText("Anger");
                option4.setText("Disgust");
                question.setImageResource(R.drawable.q3);
                break;

            case 4:
                option1.setText("Embarrassment");
                option2.setText("Sadness");
                option3.setText("Amusement");
                option4.setText("Shame");
                question.setImageResource(R.drawable.q4);
                break;

            case 5:
                option1.setText("Pride");
                option2.setText("Contempt");
                option3.setText("Excitement");
                option4.setText("Anger");
                question.setImageResource(R.drawable.q5);
                break;

            case 6:
                option1.setText("Fear");
                option2.setText("Interest");
                option3.setText("Surprise");
                option4.setText("Compassion");
                question.setImageResource(R.drawable.q6);
                break;

            case 7:
                option1.setText("Sadness");
                option2.setText("Shame");
                option3.setText("Disgust");
                option4.setText("Contempt");
                question.setImageResource(R.drawable.q7);

                break;

            case 8:
                option1.setText("Anger");
                option2.setText("Pain");
                option3.setText("Disgust");
                option4.setText("Sadness");
                question.setImageResource(R.drawable.q8);

                break;

            case 9:
                option1.setText("Desire");
                option2.setText("Embarrassment");
                option3.setText("Flirtatiousness");
                option4.setText("Love");
                question.setImageResource(R.drawable.q9);

                break;

            case 10:
                option1.setText("Shame");
                option2.setText("Anger");
                option3.setText("Sadness");
                option2.setText("Pain");
                question.setImageResource(R.drawable.q10);

                break;

            default:
                Intent intent = new Intent(EQTest.this,IQTest.class);
                startActivity(intent);
        }
        String token= String.valueOf(AccessToken.getCurrentAccessToken().getUserId());
        mDatabase = FirebaseDatabase.getInstance().getReference(token);
        option1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mDatabase.child(String.valueOf(questionno)).setValue("1");
                Intent intent = new Intent(EQTest.this,EQTest.class);
                intent.putExtra("question", String.valueOf(questionno +1));
                startActivity(intent);
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mDatabase.child(String.valueOf(questionno)).setValue("2");
                Intent intent = new Intent(EQTest.this,EQTest.class);
                intent.putExtra("question", String.valueOf(questionno +1));
                startActivity(intent);
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mDatabase.child(String.valueOf(questionno)).setValue("3");
                Intent intent = new Intent(EQTest.this,EQTest.class);
                intent.putExtra("question", String.valueOf(questionno +1));
                startActivity(intent);
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mDatabase.child(String.valueOf(questionno)).setValue("4");
                Intent intent = new Intent(EQTest.this,EQTest.class);
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
