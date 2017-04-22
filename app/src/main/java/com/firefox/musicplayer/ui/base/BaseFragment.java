package com.firefox.musicplayer.ui.base;


import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by FireFox on 2017/4/22.
 */

public class BaseFragment extends Fragment {
    public Activity mContext;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mContext = activity;
    }

}
