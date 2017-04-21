package com.firefox.musicplayer.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;

import com.firefox.musicplayer.R;
import com.firefox.musicplayer.ui.base.BaseActivity;
import com.firefox.musicplayer.utils.user.UserLoginService;
import com.firefox.musicplayer.utils.user.UserUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 俗 on 2017/4/20.
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    @OnClick(R.id.btnLogin)
    public void onViewClicked() {
        UserUtil.Login(etAccount.getText().toString(), etPassword.getText().toString());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);
        ButterKnife.bind(this);


    }


}
