package org.videolan.vlc.gui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import org.videolan.medialibrary.media.MediaWrapper;
import org.videolan.vlc.VLCApplication;
import org.videolan.vlc.media.MediaUtils;

public class ShareToStreamActivity extends BaseActivity {
    String videoSwitchPref;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPreferences();
        String url = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        setupStream(url);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        resetPreferences();
    }

    private void setPreferences() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        videoSwitchPref = pref.getString("video_action_switch", null);
        pref.edit().putString("video_action_switch", "1").commit();
    }

    private void resetPreferences() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        pref.edit().putString("video_action_switch", videoSwitchPref).apply();
    }

    private void setupStream (String url){
        final MediaWrapper mw = new MediaWrapper(Uri.parse(url));
        mw.setType(MediaWrapper.TYPE_STREAM);
        MediaUtils.openMedia(VLCApplication.getAppContext(), mw);
    }
}
