package com.firefox.musicplayer.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.firefox.musicplayer.R;
import com.firefox.musicplayer.bean.Music;
import com.firefox.musicplayer.database.MusicStore;

/**
 * Created by 凛 on 2016/5/29.
 */
public class MusicListMenu_adapter extends BaseAdapter
{
	private LayoutInflater inflater;
	private Context context;
	private Music music;

	public MusicListMenu_adapter(Context context, Music music)
	{
		this.context = context;
		this.inflater = inflater.from(context);
		this.music = music;
	}

	@Override
	public int getCount()
	{
		return 4;
	}

	@Override
	public Object getItem(int position)
	{
		return null;
	}

	@Override
	public long getItemId(int position)
	{
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		convertView = inflater.inflate(R.layout.musicplaylist_adapter, null);

		switch (position)
		{
			case 0:
				((TextView) convertView.findViewById(R.id.mpl_adapter_tv_songname)).setText("下一首播放");
				((ImageView) convertView.findViewById(R.id.mpl_adapter_iv_isplaying)).setImageDrawable(context.getResources().getDrawable(R.drawable.playbar_btn_play));
				break;
			case 1:

				if (MusicStore.isLoved(music))
				{
					((TextView) convertView.findViewById(R.id.mpl_adapter_tv_songname)).setText("取消收藏");
					((ImageView) convertView.findViewById(R.id.mpl_adapter_iv_isplaying)).setImageDrawable(context.getResources().getDrawable(R.drawable.rcd_icn_loved));
				} else
				{
					((TextView) convertView.findViewById(R.id.mpl_adapter_tv_songname)).setText("收藏到歌单");
					((ImageView)convertView.findViewById(R.id.mpl_adapter_iv_isplaying)).setImageDrawable(context.getResources().getDrawable(R.drawable.list_icn_fav_red));
				}
				convertView.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
						MusicStore.addORremoveLoveMusic(music);
					notifyDataSetChanged();
					}
				});

				break;
			case 2:
				((TextView) convertView.findViewById(R.id.mpl_adapter_tv_songname)).setText("歌手：" + music.getArtistName());
				((ImageView) convertView.findViewById(R.id.mpl_adapter_iv_isplaying)).setImageDrawable(context.getResources().getDrawable(R.drawable.lay_icn_artist));
				break;
			case 3:
				((TextView) convertView.findViewById(R.id.mpl_adapter_tv_songname)).setText("专辑：" + music.getAlbumName());
				((ImageView) convertView.findViewById(R.id.mpl_adapter_iv_isplaying)).setImageDrawable(context.getResources().getDrawable(R.drawable.lay_icn_quality));
				break;

		}
		return convertView;
	}
}
