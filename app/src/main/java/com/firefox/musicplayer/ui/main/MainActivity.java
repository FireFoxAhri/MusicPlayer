package com.firefox.musicplayer.ui.main;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.firefox.musicplayer.R;
import com.firefox.musicplayer.service.MusicPlayService;
import com.firefox.musicplayer.ui.SearchActivity;
import com.firefox.musicplayer.ui.base.BaseActivity;
import com.firefox.musicplayer.ui.fragment.FirstFragment;
import com.firefox.musicplayer.ui.fragment.MainFragment;
import com.firefox.musicplayer.ui.fragment.PlayFragment;
import com.firefox.musicplayer.widget.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by FireFox on 2017/4/7.
 */

public class MainActivity extends BaseActivity {
    protected MusicPlayService musicPlayService;
    private boolean isBound = false;
    @BindView(R.id.bar_net)
    ImageView barNet;
    @BindView(R.id.bar_music)
    ImageView barMusic;

    @BindView(R.id.main_viewpager)
    CustomViewPager mainViewpager;
    @BindView(R.id.bar_search)
    ImageView barSearch;
    @BindView(R.id.bar_paly)
    ImageView barPaly;

    @OnClick(R.id.bar_search)
    public void onViewClicked() {
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);
    }


    private ArrayList<ImageView> tabs = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ButterKnife.bind(this);


        setToolBar();
        setViewPager();

        bindPlayService();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unbindPlayService();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void setToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ab.setTitle("");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void setViewPager() {
        tabs.add(barNet);
        tabs.add(barMusic);
        tabs.add(barPaly);
        final FirstFragment firstFragment = new FirstFragment();
        final MainFragment mainFragment = new MainFragment();
        final PlayFragment playFragment = new PlayFragment();
        CustomViewPagerAdapter customViewPagerAdapter = new CustomViewPagerAdapter(getSupportFragmentManager());
        customViewPagerAdapter.addFragment(firstFragment);
        customViewPagerAdapter.addFragment(mainFragment);
        customViewPagerAdapter.addFragment(playFragment);
//        System.out.println(customViewPagerAdapter.getCount());
        mainViewpager.setAdapter(customViewPagerAdapter);
        mainViewpager.setCurrentItem(0);
        //barMusic.setSelected(true);
    }


    static class CustomViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();

        public CustomViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment) {
            mFragments.add(fragment);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }


        @Override
        public int getCount() {
            return mFragments.size();
        }
    }


    private ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            musicPlayService = ((MusicPlayService.PlayBinder) service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    public void bindPlayService() {
        if (!isBound) {
            Intent intent = new Intent(this, MusicPlayService.class);
            bindService(intent, conn, Context.BIND_AUTO_CREATE);
            isBound = true;
        }
    }

    public void unbindPlayService() {
        if (isBound) {
            unbindService(conn);
            isBound = false;
        }
    }
}




