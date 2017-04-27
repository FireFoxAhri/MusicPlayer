package com.firefox.musicplayer.ui.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.firefox.musicplayer.R;
import com.firefox.musicplayer.bean.Music;

import java.util.List;

/**
 * Created by 俗 on 2017/4/27.
 */

public class MyLovedMusicListAdapter extends RecyclerView.Adapter<MyLovedMusicListAdapter.ViewHolder> {



    private List<Music> musics;

    public MyLovedMusicListAdapter(List<Music> m) {
        this.musics =m ;
        System.out.println("构造函数");

        for(Music song:musics)
        {
            System.out.println(song.getMusicName()+"   "+song.getMusicURL());
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View adapterview;
        SimpleDraweeView newsongimage;
        TextView tv_new_songs_name;

        public ViewHolder(View v) {
            super(v);
            adapterview=v;
            tv_new_songs_name = (TextView) v.findViewById(R.id.tv_new_songs_name);
            newsongimage = (SimpleDraweeView) v.findViewById(R.id.my_image_view);
        }
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items_new_songs,parent,false);
        final ViewHolder holder=new ViewHolder(view);

        //条目点击事件
        holder.adapterview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Music music=musics.get(position);

                Toast.makeText(v.getContext(), music.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        //图片点击事件
        holder.newsongimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "图片被点击", Toast.LENGTH_SHORT).show();
                int position=holder.getAdapterPosition();
//                NewSongsInfo newsongs=newSongsInfos.get(position);
//                Intent intent=new Intent(v.getContext(), PlayMusicService.class);
//                intent.putExtra("sourceuri",newsongs.getSourceurl());
//                v.getContext().startService(intent);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Music music=musics.get(position);
        holder.tv_new_songs_name.setText(music.getMusicName()+"  "+music.getArtistName());

        String url=music.getsAlbumURL();

        Uri uri = Uri.parse(url);
        holder.newsongimage.setImageURI(uri);

    }



    @Override
    public int getItemCount() {
        return musics.size();
    }
}
