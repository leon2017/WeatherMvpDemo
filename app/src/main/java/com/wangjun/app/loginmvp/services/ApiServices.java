package com.wangjun.app.loginmvp.services;

import com.wangjun.app.loginmvp.module.model.MainModel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 当前类注释：
 * Author :LeonWang
 * Created  2016/11/4.17:38
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public interface ApiServices {

    //baseUrl
    String API_SERVER_URL = "http://www.weather.com.cn/";

    //加载天气
    @GET("adat/sk/{cityId}.html")
    Observable<MainModel> getWeatherApi(@Path("cityId") String cityId);
}
