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
import com.firefox.musicplayer.bean.RecommendMusicBean;
import com.firefox.musicplayer.bean.SerchMyMusicListBean;
import com.firefox.musicplayer.ui.adapter.NewSongsAdapter;
import com.firefox.musicplayer.utils.InfoClass.NewSongsInfo;
import com.firefox.musicplayer.utils.music.SearchUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 俗 on 2017/4/23.
 */

public class FirstSecondFragment extends Fragment {

    RecyclerView myLovedSongsRecycleview;
    private List<NewSongsInfo> newSongsInfos = new ArrayList<>();
    NewSongsAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //初始化Fresco类
        Fresco.initialize(getContext());
        View view=inflater.inflate(R.layout.first_second_fragment,container,false);

        myLovedSongsRecycleview = (RecyclerView) view.findViewById(R.id.my_loved_recycleview);


         setRecyclerView();



        return view;
    }

    private void setRecyclerView() {



        //  Call<ResponseBody> call = SearchUtil.SearchMusic("光辉岁月", 0, 20);
        Call<ResponseBody> call = SearchUtil.SearchUserPlaylist(85920218);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Gson gson = new Gson();
                try {
                    SerchMyMusicListBean serchMyMusicListBean=gson.fromJson(response.body().string(), SerchMyMusicListBean .class);
                    int id=serchMyMusicListBean.getPlaylist().get(0).getId();

                    Toast.makeText(getContext(), id+"", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
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


    private void setRecyclerView1() {



        //  Call<ResponseBody> call = SearchUtil.SearchMusic("光辉岁月", 0, 20);
        Call<ResponseBody> call = SearchUtil.SearchHotMusic();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Gson gson = new Gson();
                try {
                    RecommendMusicBean recommendMusicBean =  gson.fromJson(response.body().string(), RecommendMusicBean .class);
                    List<RecommendMusicBean.ResultBean> result =recommendMusicBean.getResult();
                    //RecommendMusicBean.ResultBean.SongBean s = songs.get(1);

                    for (RecommendMusicBean.ResultBean r: result) {
                        System.out.println(r.getSong().getName() + "   " + r.getSong().getAlbum().getPicUrl()+" "+r.getSong().getMp3Url());
                        NewSongsInfo newSongsInfo = new NewSongsInfo(r.getSong().getName(), r.getSong().getAlbum().getPicUrl(),r.getSong().getMp3Url());
                        newSongsInfos.add(newSongsInfo);
                    }
                    adapter = new NewSongsAdapter(newSongsInfos);


                    StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);

                    myLovedSongsRecycleview.setLayoutManager(layoutManager);

                    myLovedSongsRecycleview.setAdapter(adapter);

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
}
