package com.wangjun.app.loginmvp.module.view;

import com.wangjun.app.loginmvp.base.BaseView;
import com.wangjun.app.loginmvp.module.model.MainModel;

/**
 * 当前类注释：
 * Author :LeonWang
 * Created  2016/11/4.17:42
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public interface MainView extends BaseView {

    void getDataSuccess(MainModel model);

    void getDataFail(String msg);
}
