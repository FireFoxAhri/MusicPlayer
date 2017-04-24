package com.firefox.musicplayer.ui.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.firefox.musicplayer.R;
import com.firefox.musicplayer.utils.InfoClass.NewSongsInfo;

import java.util.List;

/**
 * Created by 俗 on 2017/4/23.
 */

public class NewSongsAdapter extends RecyclerView.Adapter<NewSongsAdapter.ViewHolder> {



    private List<NewSongsInfo> newSongsInfos;

    public NewSongsAdapter(List<NewSongsInfo> newSongsInfos) {
        this.newSongsInfos = newSongsInfos;
        System.out.println("构造函数");

        for(NewSongsInfo song:newSongsInfos)
        {
            System.out.println(song.getName()+"   "+song.getSourceurl());


        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView newsongimage;
        TextView tv_new_songs_name;

        public ViewHolder(View v) {
            super(v);

            tv_new_songs_name = (TextView) v.findViewById(R.id.tv_new_songs_name);
            newsongimage = (SimpleDraweeView) v.findViewById(R.id.my_image_view);
        }
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items_new_songs,parent,false);
        ViewHolder holder=new ViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewSongsInfo newSongsInfo=newSongsInfos.get(position);
        holder.tv_new_songs_name.setText(newSongsInfo.getName());

        String url=newSongsInfo.getSourceurl();

        Uri uri = Uri.parse(url);
        holder.newsongimage.setImageURI(uri);

    }



    @Override
    public int getItemCount() {
        return newSongsInfos.size();
    }
}



