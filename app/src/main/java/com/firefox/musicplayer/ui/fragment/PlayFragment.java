package com.firefox.musicplayer.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firefox.musicplayer.MainApplication;
import com.firefox.musicplayer.R;
import com.firefox.musicplayer.bean.Music;
import com.firefox.musicplayer.listener.OnLoadInformationListener;
import com.firefox.musicplayer.listener.OnProgressListener;
import com.firefox.musicplayer.service.MusicPlayService;
import com.firefox.musicplayer.ui.main.MainActivity;
import com.firefox.musicplayer.ui.music.Lyric_view;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 俗 on 2017/4/24.
 */

public class PlayFragment extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.ptv_SongName)
    TextView ptvSongName;
    @BindView(R.id.ptv_ArtistName)
    TextView ptvArtistName;
    @BindView(R.id.tv_playtime)
    TextView tvPlaytime;
    @BindView(R.id.seekBar)
    SeekBar seekBar;
    @BindView(R.id.tv_lefttime)
    TextView tvLefttime;
    @BindView(R.id.btnplaymode)
    ImageView btnplaymode;
    @BindView(R.id.btnpre)
    ImageView btnpre;
    @BindView(R.id.btnplay)
    ImageView btnplay;
    @BindView(R.id.btnnext)
    ImageView btnnext;
    @BindView(R.id.btnmenu)
    ImageView btnmenu;
    @BindView(R.id.lyrictemp)
    Lyric_view lyrictemp;
    @BindView(R.id.player)
    LinearLayout player;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.player, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity mainActivity = (MainActivity) getActivity();
        MusicPlayService musicPlayService = mainActivity.getMusicPlayService();
        musicPlayService.setOnLoadInformationListener(new OnLoadInformationListener() {
            @Override
            public void onLoadInformation(Music music, boolean isPlaying, boolean isContinue) {
                ptvSongName.setText(music.getMusicName());
                ptvArtistName.setText(music.getArtistName());
                btnplay.setImageDrawable(isPlaying ? getResources().getDrawable(R.drawable.play_btn_pause) : getResources().getDrawable(R.drawable.play_btn_play));
            }
        });
        musicPlayService.setOnProgressListener(new OnProgressListener() {
            @Override
            public void onProgress(int progress, int duration) {
                tvPlaytime.setText(progress / 60000 + ":" + progress % 60000 / 1000);
                seekBar.setProgress(progress * 10000 / duration);
                lyrictemp.changeCurrent(progress);
                tvLefttime.setText((duration - progress) / 60000 + ":" + (duration - progress) % 60000 / 1000);
            }
        });
        musicPlayService.setInformation();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }


    @OnClick({R.id.btnplaymode, R.id.btnpre, R.id.btnplay, R.id.btnnext, R.id.btnmenu})
    public void onViewClicked(View view) {
        MainActivity mainActivity = (MainActivity) getActivity();
        MusicPlayService musicPlayService = mainActivity.getMusicPlayService();
        switch (view.getId()) {
            case R.id.btnplaymode:
                musicPlayService.setPlayMode((musicPlayService.getPlayMode() + 1) % 3);
                switch (musicPlayService.getPlayMode()) {
                    case 0:
                        btnplaymode.setImageDrawable(getResources().getDrawable(R.drawable.play_icn_loop));
                        Toast.makeText(mainActivity, "列表循环", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        btnplaymode.setImageDrawable(getResources().getDrawable(R.drawable.play_icn_shuffle));
                        Toast.makeText(mainActivity, "随机播放", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        btnplaymode.setImageDrawable(getResources().getDrawable(R.drawable.play_icn_one));
                        Toast.makeText(mainActivity, "单曲循环", Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
            case R.id.btnpre:
                musicPlayService.startPlay(MainApplication.getCurrentIndex() - 1);
                break;
            case R.id.btnplay:
                if (musicPlayService.startOrPause()) {
                    btnplay.setImageDrawable(getResources().getDrawable(R.drawable.play_btn_pause));
                } else {
                    btnplay.setImageDrawable(getResources().getDrawable(R.drawable.play_btn_play));
                }
                break;
            case R.id.btnnext:
                musicPlayService.startPlay(MainApplication.getCurrentIndex() + 1);
                break;
            case R.id.btnmenu:
                mainActivity.showMusicPlayList(mainActivity.findViewById(R.id.player), view);
                break;
        }
    }
}
