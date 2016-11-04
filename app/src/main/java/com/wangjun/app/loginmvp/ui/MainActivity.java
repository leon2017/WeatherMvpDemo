package com.wangjun.app.loginmvp.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wangjun.app.loginmvp.R;
import com.wangjun.app.loginmvp.base.BaseActivity;
import com.wangjun.app.loginmvp.module.model.MainModel;
import com.wangjun.app.loginmvp.module.presenter.MainpPersenter;
import com.wangjun.app.loginmvp.module.view.MainView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<MainpPersenter> implements MainView, View.OnClickListener {

    @Bind(R.id.button)
    Button mButton;
    @Bind(R.id.textView)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        initToolBar("MVP+Retrofit+Rxjava");
        mButton.setOnClickListener(this);
    }

    @Override
    protected MainpPersenter creatPerenter() {
        return new MainpPersenter(this);
    }

    @Override
    public void getDataSuccess(MainModel model) {
        dataScuesss(model);
    }

    @Override
    public void getDataFail(String msg) {
        toastShow("网络加载失败");
    }

    @Override
    public void onClick(View v) {
        mvpPerenter.getWeatherData("101310222");
    }

    private void dataScuesss(MainModel model) {
        MainModel.WeatherinfoBean weatherinfo = model.getWeatherinfo();
        String showData = getResources().getString(R.string.city) + weatherinfo.getCity()
                + getResources().getString(R.string.wd) + weatherinfo.getWD()
                + getResources().getString(R.string.ws) + weatherinfo.getWS()
                + getResources().getString(R.string.time) + weatherinfo.getTime();
        mTextView.setText(showData);
    }
}
