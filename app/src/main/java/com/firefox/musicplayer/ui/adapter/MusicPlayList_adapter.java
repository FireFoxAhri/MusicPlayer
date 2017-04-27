package com.firefox.musicplayer.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.firefox.musicplayer.MainApplication;
import com.firefox.musicplayer.R;
import com.firefox.musicplayer.service.MusicPlayService;

/**
 * Created by 凛 on 2016/5/16.
 */
public class MusicPlayList_adapter extends BaseAdapter {
    private LayoutInflater inflater;
    private Context context;
    private MainApplication musicPlayList;
    private MusicPlayService musicPlayService;
    PopupWindow popupWindow;

    public MusicPlayList_adapter(Context context, MusicPlayService musicPlayService, PopupWindow popupWindow) {
        this.context = context;
        this.musicPlayList = ((MainApplication) context.getApplicationContext());
        this.inflater = inflater.from(context);
        this.musicPlayService = musicPlayService;
        this.popupWindow = popupWindow;
    }

    @Override
    public int getCount() {
        return musicPlayList.getPlayList().size();
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.musicplaylist_adapter, null);
        }
        if (musicPlayList.getPlayList().size() != 0) {
            ((TextView) convertView.findViewById(R.id.mpl_adapter_tv_songname)).setText(musicPlayList.getPlayList().get(position).getMusicName() + " - " + musicPlayList.getPlayList().get(position).getArtistName());


			((LinearLayout) convertView.findViewById(R.id.mpl_adapter_btn_play)).setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					musicPlayList.setCurrentIndex (position);
					musicPlayService.reset();
					musicPlayService.startPlay(musicPlayList.getCurrentIndex());
					popupWindow.dismiss();
			}
			});
            ((ImageView) convertView.findViewById(R.id.mpl_adapter_btn_delete)).setImageDrawable(context.getResources().getDrawable(R.drawable.play_list_delete));
			convertView.findViewById(R.id.mpl_adapter_btn_delete).setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					if (position > musicPlayList.getCurrentIndex()) ;
					else if (position == musicPlayList.getCurrentIndex())
					{
						if (musicPlayList.getCurrentIndex() >MainApplication.getPlayList().size() - 1)
							musicPlayList.setCurrentIndex(MainApplication.getPlayList().size() - 1);
						musicPlayService.reset();
					} else
						musicPlayList.setCurrentIndex(musicPlayList.getCurrentIndex() - 1);
                    MainApplication.getPlayList().remove(position);
					notifyDataSetChanged();
					((TextView) popupWindow.getContentView().findViewById(R.id.mpl_ppw_tv_songnum)).setText("播放列表(" + MainApplication.getPlayList().size() + ")");
				}
			});
            if (position == musicPlayList.getCurrentIndex())
                ((ImageView) convertView.findViewById(R.id.mpl_adapter_iv_isplaying)).setImageDrawable(context.getResources().getDrawable(R.drawable.play_playlist_icn_playing));
            else
                ((ImageView) convertView.findViewById(R.id.mpl_adapter_iv_isplaying)).setImageDrawable(null);
        }
        return convertView;
    }

}
