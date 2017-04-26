package com.firefox.musicplayer.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firefox.musicplayer.R;
import com.firefox.musicplayer.bean.Music;
import com.firefox.musicplayer.ui.SearchActivity;
import com.firefox.musicplayer.ui.main.MainActivity;

import java.util.ArrayList;



/**
 * Created by 俗 on 2017/4/25.
 */

public class SearchMusicListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<Music> musics;
    private ListView listView;



    private Context context;

    @Override
    public int getCount() {
        return musics.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null)
        {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.musiclist_adapter, null);
            viewHolder.SongName = (TextView) convertView.findViewById(R.id.ml_adapter_tv_songname);
            viewHolder.Singer = (TextView) convertView.findViewById(R.id.ml_adapter_tv_singer);
            viewHolder.spic = (ImageView) convertView.findViewById(R.id.ml_adapter_iv_album);
            viewHolder.Menu = (ImageView) convertView.findViewById(R.id.ml_adapter_btn_menu);
            viewHolder.Play = (RelativeLayout) convertView.findViewById(R.id.ml_adapter_btn_play);
            convertView.setTag(viewHolder);
        } else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.Menu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(context.toString().contains("MainActivity"))
                ((MainActivity) context).showMenu(v, musics.get(position), listView);
                else if(context.toString().contains("SearchActivity"))
                {
                    ((SearchActivity) context).showMenu(v, musics.get(position), listView);
                }

            }
        });
//        viewHolder.Play.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                new AsyncTask<Music, Void, Music>()
//                {
//                    @Override
//                    protected Music doInBackground(Music... params)
//                    {
//                        Music music = new Music();
//                        if (params[0].isLocal())
//                        {
//                            music = GetInformation.getExtraInformation(params[0]);
//                        } else
//                        {
//                            music = GetInformation.getAllInformation(params[0]);
//                        }
//                        return music;
//                    }

//                    @Override
//                    protected void onPostExecute(Music music)
//                    {
//                        super.onPostExecute(music);
//
//                        MusicPlayList musicPlayList = (MusicPlayList) context.getApplicationContext();
//                        musicPlayList.insertMusic(musics.get(position));
//                        Intent broadcast = new Intent();
//                        broadcast.setAction("start");
//                        context.sendBroadcast(broadcast);
//                    }
//                }.execute(musics.get(position));
//            }
//        });
        viewHolder.SongName.setText(musics.get(position).getMusicName());
        viewHolder.Singer.setText(musics.get(position).getArtistName() + " - " + musics.get(position).getAlbumName());


        if (musics.get(position).getsAlbumURL() != null) {
            String url = musics.get(position).getsAlbumURL();
            Uri uri = Uri.parse(url);
            viewHolder.spic.setImageURI(uri);

        }






       // ImageUtils.disPlay(musics.get(position).getsAlbumURL(), viewHolder.spic, R.drawable.music_default);
        return convertView;
    }

    public SearchMusicListAdapter(ArrayList<Music> musics, Context context, ListView listView) {
        this.musics = musics;
        this.context = context;
        this.listView = listView;
        this.inflater = LayoutInflater.from(context);
    }



    private static class ViewHolder
    {
        TextView SongName;
        TextView Singer;
        ImageView spic;
        ImageView Menu;
        RelativeLayout Play;
    }


}
