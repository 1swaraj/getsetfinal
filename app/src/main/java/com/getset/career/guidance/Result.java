package com.getset.career.guidance;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareButton;

import net.alhazmy13.wordcloud.ColorTemplate;
import net.alhazmy13.wordcloud.WordCloud;
import net.alhazmy13.wordcloud.WordCloudView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Result extends AppCompatActivity {
    List<WordCloud> list ;
    String text="Focused Intelligent Smart Creative Hardworking Optimistic Opportunistic Enthusiast Achiever Sincere Trustworthy Dependable Skeptical Self-Satisfied Materialistic Eccentric  Anxious Dissatisfied Cheerful Good-Humored  Friendly Mature";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        generateRandomText();
        WordCloudView wordCloud = (WordCloudView) findViewById(R.id.wordCloud);
        wordCloud.setDataSet(list);
        wordCloud.setSize(500,400);
        wordCloud.setColors(ColorTemplate.MATERIAL_COLORS);
        String results="Maid";
        ShareButton fbShareButton = (ShareButton) findViewById(R.id.share_btn);
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("https://play.google.com/store/apps/details?id=com.swaraj.edupassion"))
                .setQuote("I am "+results+" find out what you can be.")
                .build();
        fbShareButton.setShareContent(content);
        wordCloud.notifyDataSetChanged();
    }
    private void generateRandomText() {
        String[] data = text.split(" ");
        list = new ArrayList<>();
        Random random = new Random();
        for (String s : data)
        {
            list.add(new WordCloud(s,random.nextInt(50)));
        }
    }
}


