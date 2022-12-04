package com.group11.myecopet;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.group11.myecopet.databinding.ActivityFeedsBinding;

public class Feeds extends AppCompatActivity {

    ActivityFeedsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_feeds);
        binding = ActivityFeedsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();

        VideoView videoView = findViewById(R.id.feed_video);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.kitten_so_cute;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }

    private void addEvents() {
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Feeds.this, MyVideos.class);
                startActivity(intent);
            }
        });
    }
}