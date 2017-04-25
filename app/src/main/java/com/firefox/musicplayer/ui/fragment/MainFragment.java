package com.firefox.musicplayer.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.firefox.musicplayer.R;
import com.firefox.musicplayer.bean.Music;
import com.firefox.musicplayer.database.LocalMusicStore;
import com.firefox.musicplayer.ui.adapter.MainFragmentAdapter;
import com.firefox.musicplayer.ui.adapter.SearchMusicListAdapter;
import com.firefox.musicplayer.ui.base.BaseFragment;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author wm
 *         Created by wm on 2016/3/8.
 *         本地界面主界面
 */
public class MainFragment extends BaseFragment {



    Unbinder unbinder;

    private MainFragmentAdapter mAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);

        ArrayList<Music> musics = LocalMusicStore.getMusicList(getContext());


        ListView a = (ListView) view.findViewById(R.id.lv_localmusicList);
        SearchMusicListAdapter searchMusicListAdapter = new SearchMusicListAdapter(musics, getActivity(), a);
        //searchMusicListAdapter.notifyDataSetChanged();

        a.setAdapter(searchMusicListAdapter);





        //设置没有item动画




        return view;
    }









    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

