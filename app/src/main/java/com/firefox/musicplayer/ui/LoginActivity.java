package com.firefox.musicplayer.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firefox.musicplayer.R;
import com.firefox.musicplayer.bean.UserBean;
import com.firefox.musicplayer.ui.base.BaseActivity;
import com.firefox.musicplayer.utils.user.UserUtil;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        Call<ResponseBody> call = UserUtil.Login(etAccount.getText().toString(), etPassword.getText().toString());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Gson gson = new Gson();
                try {
                    UserBean user = gson.fromJson(response.body().string(), UserBean.class);
                    Log.v("2333....", String.valueOf(user.getCode()));
                    if (user.getCode() == 200) {
                        Toast.makeText(getApplicationContext(), "登录成功！", Toast.LENGTH_SHORT).show();
                    } else if (user.getCode() == 502) {
                        Toast.makeText(getApplicationContext(), "密码错误！", Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "登录失败！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);
        ButterKnife.bind(this);


    }


}
