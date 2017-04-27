package com.firefox.musicplayer.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firefox.musicplayer.R;
import com.firefox.musicplayer.service.MusicPlayService;
import com.firefox.musicplayer.ui.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 俗 on 2017/4/24.
 */

public class PlayFragment extends Fragment {

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
    Unbinder unbinder;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.player, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;

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
                switch (musicPlayService.getPlayMode())
                {
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
                break;
            case R.id.btnplay:
                break;
            case R.id.btnnext:
                break;
            case R.id.btnmenu:
                //Toast.makeText(musicPlayService, "btnMenu被点击", Toast.LENGTH_SHORT).show();
                mainActivity.showMusicPlayList(mainActivity.findViewById(R.id.player), view);



                break;
        }
    }
}
