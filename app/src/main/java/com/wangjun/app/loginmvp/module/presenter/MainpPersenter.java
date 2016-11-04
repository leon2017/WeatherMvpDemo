package com.wangjun.app.loginmvp.module.presenter;

import com.wangjun.app.loginmvp.base.BasePersenter;
import com.wangjun.app.loginmvp.module.model.MainModel;
import com.wangjun.app.loginmvp.module.view.MainView;
import com.wangjun.app.loginmvp.services.ApiCallback;
import com.wangjun.app.loginmvp.services.ApiServices;
import com.wangjun.app.loginmvp.services.AppClient;

/**
 * 当前类注释：
 * Author :LeonWang
 * Created  2016/11/4.18:09
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public class MainpPersenter extends BasePersenter<MainView> {

    private ApiServices mApiServices;

    public MainpPersenter(MainView view) {
        attachView(view);
        mApiServices = AppClient.retrofit().create(ApiServices.class);
    }

    public void getWeatherData(String cityId) {
        mvpView.showLoading();
        addSubscription(mApiServices.getWeatherApi(cityId),
                new ApiCallback<MainModel>() {
                    @Override
                    public void onSuccess(MainModel model) {
                        mvpView.getDataSuccess(model);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.getDataFail(msg);
                    }

                    @Override
                    public void onFinish() {
                        mvpView.hideLoading();
                    }
                });
    }

}
