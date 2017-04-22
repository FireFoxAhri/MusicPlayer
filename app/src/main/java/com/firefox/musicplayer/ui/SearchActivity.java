package com.firefox.musicplayer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.firefox.musicplayer.R;
import com.firefox.musicplayer.ui.main.MainActivity;

/**
 * Created by 俗 on 2017/4/22.
 */

public class SearchActivity extends AppCompatActivity {

    ImageView iv_back;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_layout);

        iv_back= (ImageView) findViewById(R.id.iv_search);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });




        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)
        {
            actionBar.hide();
        }

    }
}
