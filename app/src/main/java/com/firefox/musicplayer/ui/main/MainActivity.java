package com.firefox.musicplayer.ui.main;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.firefox.musicplayer.ui.base.BaseActivity;
import com.firefox.musicplayer.utils.user.UserUtil;

/**
 * Created by FireFox on 2017/4/7.
 */

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                UserUtil.Login("13163388532","zjs19941118");
                return null;
            }
        }.execute();
    }
}
