package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        VideoView vv1=(VideoView) findViewById(R.id.videoView);
        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(vv1);

        Uri uri;
//      uri=Uri.parse("https://media.w3.org/2010/05/sintel/trailer.mp4");
        uri=Uri.parse("android.resource://"+getPackageName()+"/raw/test_video");
        vv1.setMediaController(mediaController);
        vv1.setVideoURI(uri);
        vv1.start();
    }
}