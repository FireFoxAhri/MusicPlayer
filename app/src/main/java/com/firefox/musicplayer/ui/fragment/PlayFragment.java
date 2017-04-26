package com.firefox.musicplayer.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.firefox.musicplayer.R;

import butterknife.OnClick;

/**
 * Created by 俗 on 2017/4/24.
 */

public class PlayFragment extends Fragment {

    ImageView playingPlay;



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.player, container, false);

        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @OnClick(R.id.playing_play)
    public void onViewClicked() {





    }
}
