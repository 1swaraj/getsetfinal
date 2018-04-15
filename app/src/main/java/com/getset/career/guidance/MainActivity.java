package com.getset.career.guidance;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.json.JSONObject;
import java.util.Arrays;
public class MainActivity extends AppCompatActivity {
    private static final String EMAIL = "email";
    LoginButton loginButton;
    CallbackManager mcallbackManager;
    DatabaseReference mDatabase;
    ImageView logo;
    Animation uptodown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_main);
        DisplayMetrics display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);
        int screenWidth = display.widthPixels;
        int  screenHeight = display.heightPixels;
        logo=(ImageView)findViewById(R.id.logo);
        loginButton = (LoginButton) findViewById(R.id.next);
        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        logo.setAnimation(uptodown);
        mcallbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(mcallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        final String token = AccessToken.getCurrentAccessToken().getUserId();
                        GraphRequest request = GraphRequest.newMeRequest(
                                AccessToken.getCurrentAccessToken(),
                                new GraphRequest.GraphJSONObjectCallback() {
                                    @Override
                                    public void onCompleted(JSONObject object, GraphResponse response) {
                                        Log.v("LoginActivity", response.toString());
                                        try {
                                            String email = object.getString("email");
                                            String userId = AccessToken.getCurrentAccessToken().getUserId();
                                            mDatabase = FirebaseDatabase.getInstance().getReference();
                                            mDatabase.child(userId).child("name").setValue(object.getString("name"));
                                            mDatabase.child(userId).child("email").setValue(email);
                                            mDatabase.child(userId).child("gender").setValue(object.getString("gender"));
                                            mDatabase.child(userId).child("birthday").setValue(object.getString("birthday"));
                                        } catch (Exception e) {
                                        }
                                    }
                                });


                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "email,name,gender,birthday");
                        request.setParameters(parameters);
                        request.executeAsync();
                        Intent intent = new Intent(MainActivity.this, SJT.class);
                        intent.putExtra("question", "0");
                        startActivity(intent);

                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code

                    }
                });
        boolean loggedIn = !(AccessToken.getCurrentAccessToken() == null);
        if (loggedIn) {
            Intent intent = new Intent(this, SJT.class);
            intent.putExtra("question", "0");
            startActivity(intent);
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mcallbackManager.onActivityResult(requestCode, resultCode, data);
    }
    protected void onPause()
    {
        super.onPause();
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
    }
}
