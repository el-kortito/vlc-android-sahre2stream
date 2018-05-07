package org.videolan.vlc.gui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import org.videolan.medialibrary.media.MediaWrapper;
import org.videolan.vlc.VLCApplication;
import org.videolan.vlc.media.MediaUtils;

public class ShareToStreamActivity extends BaseActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String url = intent.getStringExtra(Intent.EXTRA_TEXT);
        setupStream(url);
        finish();
    }

    private void setupStream(String url) {
        final MediaWrapper mw = new MediaWrapper(Uri.parse(url));
        mw.setType(MediaWrapper.TYPE_STREAM);
        MediaUtils.openMedia(VLCApplication.getAppContext(), mw);
    }
}

