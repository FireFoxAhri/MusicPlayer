package com.firefox.musicplayer.database;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import com.firefox.musicplayer.bean.Music;

import java.util.ArrayList;


/**
 * Created by 凛 on 2016/5/10.
 */
public class LocalMusicStore
{
	private static ContentResolver contentResolver;
	private static Uri contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

	public static ArrayList<Music> getMusicList(Context context)
	{
		ArrayList<Music> musicList = new ArrayList<Music>();
		contentResolver = context.getContentResolver();
		Cursor cursor = contentResolver.query(contentUri, new String[]{
				MediaStore.Audio.Media.TITLE,
				MediaStore.Audio.Media.ARTIST,
				MediaStore.Audio.Media.ALBUM,
				MediaStore.Audio.Media.DATA,
		}, null, null, null);
		if (cursor == null)
		{
		} else if (!cursor.moveToFirst())
		{
		} else
		{
			do
			{
				final Music music = new Music();
				music.setMusicID("local");
				music.setMusicName(cursor.getString(0));
				music.setArtistName(cursor.getString(1));
				music.setAlbumName(cursor.getString(2));
				music.setLocal(true);
				music.setMusicURL(cursor.getString(3));
				musicList.add(music);
			} while (cursor.moveToNext());
		}
		return musicList;
	}
}