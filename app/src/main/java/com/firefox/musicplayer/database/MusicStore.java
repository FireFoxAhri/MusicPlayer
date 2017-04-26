package com.firefox.musicplayer.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.firefox.musicplayer.bean.Music;

import java.util.ArrayList;


/**
 * Created by 凛 on 2016/5/1.
 */
public class MusicStore extends SQLiteOpenHelper {
    private static final String DB_NAME = "MusicStore";
    private static final int version = 1;
    static SQLiteDatabase db;
    private Context context;

    public MusicStore(Context context) {
        super(context, DB_NAME, null, version);
        db = this.getWritableDatabase();
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        String sql = "create table musiclovelist" +
                "(musicid varchar(10) not null," +
                "musicurl varchar(50) not null , " +
                "musicname varchar(20) not null ," +
                "salbumurl varchar(50)," +
                "balbumurl varchar(50)," +
                "lrcurl varchar(50)," +
                "artistname varchar(20)," +
                "islocal boolean not null );";
        db.execSQL(sql);
        sql = "create table musicplaylist" +
                "(musicid varchar(10) not null," +
                "musicurl varchar(50) not null , " +
                "musicname varchar(20) not null ," +
                "salbumurl varchar(50)," +
                "balbumurl varchar(50)," +
                "lrcurl varchar(50)," +
                "artistname varchar(20)," +
                "islocal boolean not6 null );";
        db.execSQL(sql);
    }

    public static ArrayList<Music> getLoveMusicList() {
        ArrayList<Music> temp = new ArrayList<Music>();
        Cursor cursor = db.query("musiclovelist", new String[]{"musicid", "musicurl", "musicname", "salbumurl", "balbumurl", "lrcurl", "artistname", "islocal"}, null, null, null, null, null);
        if (cursor == null) {
        } else if (!cursor.moveToFirst()) {
        } else {
            do {
                Log.i("size", "" + temp.size());
                Music music = new Music();
                music.setMusicID(cursor.getString(0));
                music.setMusicURL(cursor.getString(1));
                music.setMusicName(cursor.getString(2));
                music.setsAlbumURL(cursor.getString(3));
                music.setbAlbumURL(cursor.getString(4));
                music.setLrcURL(cursor.getString(5));
                music.setArtistName(cursor.getString(6));
                music.setLocal(Boolean.parseBoolean(cursor.getString(7)));
                temp.add(music);
            } while (cursor.moveToNext());
        }
        return temp;
    }

    public static ArrayList<Music> getPlayList() {
        ArrayList<Music> temp = new ArrayList<Music>();
        Cursor cursor = db.query("musicplaylist", new String[]{"musicid", "musicurl", "musicname", "salbumurl", "balbumurl", "lrcurl", "artistname", "islocal"}, null, null, null, null, null);
        if (cursor == null) {
        } else if (!cursor.moveToFirst()) {
        } else {
            do {
                Music music = new Music();
                music.setMusicID(cursor.getString(0));
                music.setMusicURL(cursor.getString(1));
                music.setMusicName(cursor.getString(2));
                music.setsAlbumURL(cursor.getString(3));
                music.setbAlbumURL(cursor.getString(4));
                music.setLrcURL(cursor.getString(5));
                music.setArtistName(cursor.getString(6));
                music.setLocal(Boolean.parseBoolean(cursor.getString(7)));
                temp.add(music);
            } while (cursor.moveToNext());
        }
        Log.i("size", "" + temp.size());
        return temp;
    }

    public static boolean isLoved(Music music) {
        Cursor cursor = db.query("musiclovelist", new String[]{"musicurl"}, "musicurl='" + music.getMusicURL() + "'", null, null, null, null);
        if (cursor == null) {
            return false;
        } else if (!cursor.moveToFirst()) {
            return false;
        } else
        {
            return true;
        }
    }

    public static void addORremoveLoveMusic(Music music) {
        if (!isLoved(music))
            addLoveMusic(music);
        else removeLoveMusic(music);
    }

    public static void addLoveMusic(Music music) {
        ContentValues cv = new ContentValues();
        cv.put("musicid", music.getMusicID());
        cv.put("musicurl", music.getMusicURL());
        cv.put("musicname", music.getMusicName());
        cv.put("salbumurl", music.getsAlbumURL());
        cv.put("balbumurl", music.getbAlbumURL());
        cv.put("lrcurl", music.getLrcURL());
        cv.put("artistname", music.getArtistName());
        cv.put("islocal", music.isLocal());
        db.insert("musiclovelist", null, cv);
    }

    public static void removeLoveMusic(Music music) {
        db.execSQL("delete from musiclovelist where musicurl='" + music.getMusicURL() + "'");
    }

    public void updatePlayList(ArrayList<Music> temp) {
        db.execSQL("delete from musicplaylist");
        for (int i = 0; i < temp.size(); i++) {
            ContentValues cv = new ContentValues();
            cv.put("musicid", temp.get(i).getMusicID());
            cv.put("musicurl", temp.get(i).getMusicURL());
            cv.put("musicname", temp.get(i).getMusicName());
            cv.put("salbumurl", temp.get(i).getsAlbumURL());
            cv.put("balbumurl", temp.get(i).getbAlbumURL());
            cv.put("lrcurl", temp.get(i).getLrcURL());
            cv.put("artistname", temp.get(i).getArtistName());
            cv.put("islocal", temp.get(i).isLocal());
            db.insert("musicplaylist", null, cv);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}