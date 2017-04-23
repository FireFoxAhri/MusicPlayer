package com.firefox.musicplayer.ui.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.firefox.musicplayer.R;


import java.util.ArrayList;

/**
 * Created by wm on 2016/3/10.
 */
public class MainFragmentAdapter extends RecyclerView.Adapter<MainFragmentAdapter.ItemHolder> {

    //private ArrayList<Playlist> playlists, netplaylists = new ArrayList<>();
    private boolean createdExpanded = true;
    private boolean collectExpanded = true;
    private Context mContext;
    private ArrayList itemResults = new ArrayList();
    private boolean isLoveList = true;


    public MainFragmentAdapter(Context context) {
        this.mContext = context;
    }
    public void updateResults(ArrayList itemResults) {
        isLoveList = true;
        this.itemResults = itemResults;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case 0:
                View v0 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_main_item, viewGroup, false);
                ItemHolder ml0 = new ItemHolder(v0);
                return ml0;
            case 1:
                if (isLoveList) {
                    View v1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_main_playlist_first_item, viewGroup, false);
                    ItemHolder ml1 = new ItemHolder(v1);
                    return ml1;
                }
                View v1 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_main_playlist_item, viewGroup, false);
                ItemHolder ml1 = new ItemHolder(v1);
                return ml1;
            case 2:
                View v2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.expandable_item, viewGroup, false);
                ItemHolder ml2 = new ItemHolder(v2);
                return ml2;
            case 3:
                View v3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.expandable_item, viewGroup, false);
                ItemHolder ml3 = new ItemHolder(v3);
                return ml3;

        }
        return null;
    }

    @Override
    public void onBindViewHolder(final ItemHolder itemHolder, int i) {

    }

    @Override
    public void onViewRecycled(ItemHolder itemHolder) {

    }

    @Override
    public int getItemCount() {
        return itemResults.size();
    }




    @Override
    public int getItemViewType(int position) {
        if (getItemCount() == 0) {
            return -1;
        }
        if (itemResults.get(position) instanceof MainFragmentItem)
            return 0;
        if (itemResults.get(position) instanceof String) {
            if (((String) itemResults.get(position)).equals("收藏的歌单"))
                return 3;
        }
        return 2;
    }


    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView itemtitle, title, count, songcount, sectionItem;
        protected ImageView menu, sectionImg, sectionMenu;
        SimpleDraweeView albumArt;
        protected ImageView image;

        public ItemHolder(View view) {
            super(view);
            this.image = (ImageView) view.findViewById(R.id.fragment_main_item_img);
            this.itemtitle = (TextView) view.findViewById(R.id.fragment_main_item_title);
            this.count = (TextView) view.findViewById(R.id.fragment_main_item_count);

            this.title = (TextView) view.findViewById(R.id.fragment_main_playlist_item_title);
            this.songcount = (TextView) view.findViewById(R.id.fragment_main_playlist_item_count);
            this.albumArt = (SimpleDraweeView) view.findViewById(R.id.fragment_main_playlist_item_img);
            this.menu = (ImageView) view.findViewById(R.id.fragment_main_playlist_item_menu);

            this.sectionItem = (TextView) view.findViewById(R.id.expand_title);
            this.sectionImg = (ImageView) view.findViewById(R.id.expand_img);
            this.sectionMenu = (ImageView) view.findViewById(R.id.expand_menu);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            ObjectAnimator anim = null;
            anim = ObjectAnimator.ofFloat(sectionImg, "rotation", 90, 0);
            anim.setDuration(100);
            anim.setRepeatCount(0);
            anim.setInterpolator(new LinearInterpolator());
            switch (getItemViewType()) {
                case 2:
                    break;
                case 3:
                    break;
            }
        }

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

    //标题
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

    //图片
    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}