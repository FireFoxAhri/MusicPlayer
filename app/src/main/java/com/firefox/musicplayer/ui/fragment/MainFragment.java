package com.firefox.musicplayer.ui.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firefox.musicplayer.R;
import com.firefox.musicplayer.ui.adapter.MainFragmentAdapter;
import com.firefox.musicplayer.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author wm
 *         Created by wm on 2016/3/8.
 *         本地界面主界面
 */
public class MainFragment extends BaseFragment {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.swiperefresh)
    SwipeRefreshLayout swipeRefresh;
    Unbinder unbinder;

    private MainFragmentAdapter mAdapter;
    private List<MainFragmentItem> mList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);


        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                reloadAdapter();
            }
        });
        mAdapter = new MainFragmentAdapter(mContext);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        //设置没有item动画
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        reloadAdapter();
        loadCount(true);
        mContext.getWindow().setBackgroundDrawableResource(R.color.background_material_light_1);
        return view;
    }


    public void reloadAdapter() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(final Void... unused) {
                loadCount(true);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                if (mContext == null)
                    return;
                mAdapter.notifyDataSetChanged();
                swipeRefresh.setRefreshing(false);
            }
        }.execute();
    }

    //为info设置数据，并放入mlistInfo
    private void setInfo(String title, int count, int id, int i) {
        MainFragmentItem information = new MainFragmentItem();
        information.title = title;
        information.count = count;
        information.avatar = id;
        if (mList.size() < 4) {
            mList.add(new MainFragmentItem());
        }
        mList.set(i, information); //将新的info对象加入到信息列表中
    }

    private void loadCount(boolean has) {
        int localMusicCount = 0, recentMusicCount = 0, downLoadCount = 0, artistsCount = 0;

        setInfo(mContext.getResources().getString(R.string.local_music), localMusicCount, R.drawable.music_icn_local, 0);
        setInfo(mContext.getResources().getString(R.string.recent_play), recentMusicCount, R.drawable.music_icn_recent, 1);
        setInfo(mContext.getResources().getString(R.string.local_manage), downLoadCount, R.drawable.music_icn_dld, 2);
        setInfo(mContext.getResources().getString(R.string.my_artist), artistsCount, R.drawable.music_icn_artist, 3);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

class MainFragmentItem {
    public String title;   //信息标题
    public int count;
    public int avatar; //图片ID
    public boolean countChanged = true;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
