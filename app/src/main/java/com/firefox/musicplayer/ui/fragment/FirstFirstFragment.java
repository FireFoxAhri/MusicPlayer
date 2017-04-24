package com.firefox.musicplayer.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.firefox.musicplayer.R;
import com.firefox.musicplayer.bean.SearchMusicBean;
import com.firefox.musicplayer.ui.adapter.NewSongsAdapter;
import com.firefox.musicplayer.utils.InfoClass.NewSongsInfo;
import com.firefox.musicplayer.utils.music.SearchUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 俗 on 2017/4/23.
 */

public class FirstFirstFragment extends Fragment {

    @BindView(R.id.new_songs_recycleview)
    RecyclerView newSongsRecycleview;
    Unbinder unbinder;

    private List<NewSongsInfo> newSongsInfos = new ArrayList<>();
    NewSongsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //初始化Fresco类
        Fresco.initialize(getContext());

        View view = inflater.inflate(R.layout.first_first_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        newSongsRecycleview = (RecyclerView) view.findViewById(R.id.new_songs_recycleview);


        setRecyclerView();


        return view;
    }

    private void setRecyclerView() {

        initNewSongsInfo();
        Call<ResponseBody> call = SearchUtil.SearchMusic("十年", 0, 20);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Gson gson = new Gson();


                try {
                    SearchMusicBean result = gson.fromJson(response.body().string(), SearchMusicBean.class);
                    List<SearchMusicBean.ResultBean.SongsBean> songs = result.getResult().getSongs();
                    SearchMusicBean.ResultBean.SongsBean s = songs.get(1);

                    for (SearchMusicBean.ResultBean.SongsBean song : songs) {
                        System.out.println(song.getName() + "   " + song.getAl().getPicUrl());
                        NewSongsInfo newSongsInfo = new NewSongsInfo(song.getName(), song.getAl().getPicUrl());
                        newSongsInfos.add(newSongsInfo);
                    }
                    adapter = new NewSongsAdapter(newSongsInfos);


                    StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);

                    newSongsRecycleview.setLayoutManager(layoutManager);

                    newSongsRecycleview.setAdapter(adapter);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                // Toast.makeText(getContext(), result.getResult().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
//        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());


    }

    private void initNewSongsInfo() {


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.new_songs_recycleview)
    public void onViewClicked() {

        Toast.makeText(getContext(), "afdasfasdfasdfasfadsfsdf", Toast.LENGTH_SHORT).show();
    }


}



