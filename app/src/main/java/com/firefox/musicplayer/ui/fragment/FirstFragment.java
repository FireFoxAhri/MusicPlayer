package com.firefox.musicplayer.ui.fragment;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.firefox.musicplayer.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 俗 on 2017/4/22.
 */
public class FirstFragment extends Fragment {

    @BindView(R.id.bt_songs_menu)
    Button btSongsMenu;
    @BindView(R.id.bt_song_rank)
    Button btSongRank;
    Unbinder unbinder;
    @BindView(R.id.bt_new_songs)
    Button btNewSongs;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        //初始界面
        replacefragment(new FirstFirstFragment());

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.bt_new_songs, R.id.bt_songs_menu, R.id.bt_song_rank})
    public void onViewClicked(View view) {


        Resources resource=getResources();
        ColorStateList csl=(ColorStateList)resource.getColorStateList(R.color.button_text);
        ColorStateList csl2=(ColorStateList)resource.getColorStateList(R.color.button_text2);

        switch (view.getId()) {
            case R.id.bt_new_songs:
                btNewSongs.setTextColor(csl);
                btSongRank.setTextColor(csl2);
                btSongsMenu.setTextColor(csl2);
                replacefragment(new FirstFirstFragment());
                break;
            case R.id.bt_songs_menu:
                btNewSongs.setTextColor(csl2);
                btSongRank.setTextColor(csl2);
                btSongsMenu.setTextColor(csl);
                replacefragment(new FirstSecondFragment());
                break;
            case R.id.bt_song_rank:
                btNewSongs.setTextColor(csl2);
                btSongRank.setTextColor(csl);
                btSongsMenu.setTextColor(csl2);
                replacefragment(new FirstThirdFragment());
                break;
        }
    }

    private void replacefragment(Fragment fragment) {
        FragmentManager fragmentmanger=getFragmentManager();
        FragmentTransaction transaction=fragmentmanger.beginTransaction();

       // transaction.replace(R.id.first_first_fragment,fragment);
        transaction.replace(R.id.first_fragment_container,fragment);
        transaction.commit();
    }
}