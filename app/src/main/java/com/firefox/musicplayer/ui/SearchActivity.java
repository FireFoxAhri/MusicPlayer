package com.firefox.musicplayer.ui;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.firefox.musicplayer.R;
import com.firefox.musicplayer.bean.Music;
import com.firefox.musicplayer.bean.SearchMusicBean;
import com.firefox.musicplayer.ui.adapter.MusicListMenu_adapter;
import com.firefox.musicplayer.ui.adapter.SearchMusicListAdapter;
import com.firefox.musicplayer.utils.music.SearchUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 俗 on 2017/4/22.
 */

public class SearchActivity extends AppCompatActivity {
    int flag = 0;
    SearchMusicListAdapter searchMusicListAdapter;
    ArrayList<Music> musics = new ArrayList<>();
    @BindView(R.id.iv_search)
    ImageView ivSearch;

    @BindView(R.id.et_search)
    EditText etSearch;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_layout);
        ButterKnife.bind(this);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }


        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            String info;

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                musics.clear();
                if (searchMusicListAdapter != null) {
                    // searchMusicListAdapter.notifyDataSetChanged();
                    searchMusicListAdapter.notifyDataSetInvalidated();
                }


                info = etSearch.getText().toString();
                // Toast.makeText(SearchActivity.this, info, Toast.LENGTH_SHORT).show();

                Call<ResponseBody> call = SearchUtil.SearchMusic(info, 0, 20);

                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Gson gson = new Gson();

                        try {
                            SearchMusicBean result = gson.fromJson(response.body().string(), SearchMusicBean.class);
                            List<SearchMusicBean.ResultBean.SongsBean> songs = result.getResult().getSongs();


                            for (final SearchMusicBean.ResultBean.SongsBean song : songs) {
                               // final SearchMusicBean.ResultBean.SongsBean song = songs.get(1);
                                final int sid;
                                sid = song.getId();
                                //  System.out.println(song.getName() + " " + song.getId() + "  " + song.getAl().getName() + "   " + song.getAl().getPicUrl());
                                Music music = new Music();
                               // music.setAlbumName(songsBean.getAlbum().getName());
                                music.setAlbumName(song.getAl().getName());
                                music.setArtistName(song.getAr().get(0).getName());
                                music.setsAlbumURL(song.getAl().getPicUrl());
                                music.setLocal(false);
                              //  music.setLrcURL(lrcBean1.getLyric());
                                music.setMusicID(String.valueOf(song.getId()));
                                music.setMusicName(song.getName());

                                musics.add(music);

                            }




                            System.out.print("填充Addapter33333333333333333333333333");

                            ListView a = (ListView) findViewById(R.id.lv_SearchList);
                            searchMusicListAdapter = new SearchMusicListAdapter(musics, SearchActivity.this, a);
                            //searchMusicListAdapter.notifyDataSetChanged();

                            a.setAdapter(searchMusicListAdapter);







                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        // Toast.makeText(getContext(), result.getResult().toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }

                });


                return (event.getKeyCode() == KeyEvent.KEYCODE_ENTER);
            }
        });


//        etSearch.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                String info;
//                if (keyCode == KeyEvent.KEYCODE_ENTER&& event.getAction() == KeyEvent.ACTION_UP) {
//                    //System.out.println("手指弹起时执行确认功能");
//                    //此处执行搜索回车事件
//                    info=etSearch.getText().toString();
//                    Toast.makeText(SearchActivity.this, info, Toast.LENGTH_SHORT).show();
//
//
//                    return true;
//                }
//
//                return false;
//            }
//
//        });

    }

    @OnClick(R.id.iv_search)
    public void onViewClicked() {
        finish();
    }


    public void showMenu(View view, final Music music, ListView listView)
    {
        final View contentView = LayoutInflater.from(this).inflate(R.layout.musicplaylist_popupwindow, null);
        final PopupWindow popupWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, 800, true);
        popupWindow.setAnimationStyle(R.style.AnimBottom);
        popupWindow.setTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        ((ListView) contentView.findViewById(R.id.lv_musiclist)).setAdapter(new MusicListMenu_adapter(this, music));

        ((TextView) contentView.findViewById(R.id.mpl_ppw_tv_songnum)).setText("歌曲：" + music.getMusicName());
        contentView.setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View v, MotionEvent event)
            {
                int height = contentView.findViewById(R.id.popupwindow).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    if (y < height)
                    {
                        popupWindow.dismiss();
                    }
                }
                return true;
            }
        });
        popupWindow.showAtLocation(findViewById(R.id.search_main_layout), Gravity.BOTTOM, 0, 0);
        popupWindow.showAsDropDown(view);
    }


}


