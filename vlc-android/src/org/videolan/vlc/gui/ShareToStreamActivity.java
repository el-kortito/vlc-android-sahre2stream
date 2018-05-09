package org.videolan.vlc.gui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;

import org.videolan.medialibrary.media.MediaWrapper;
import org.videolan.vlc.PlaybackService;
import org.videolan.vlc.VLCApplication;
import org.videolan.vlc.gui.tv.audioplayer.AudioPlayerActivity;
import org.videolan.vlc.gui.video.VideoPlayerActivity;
import org.videolan.vlc.media.MediaUtils;
import org.videolan.vlc.util.Constants;

public class ShareToStreamActivity extends BaseActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        setupStream(url);
        finish();
    }

    private void setupStream (String url){
        final MediaWrapper media = new MediaWrapper(Uri.parse(url));
        Intent intent = VideoPlayerActivity.getIntent(Constants.PLAY_FROM_VIDEOGRID, media, true, -1);
        intent.putExtra("play_as_audio", true);
        startActivity(intent);
    }
}

