package com.wangjun.app.loginmvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * 当前类注释：
 * Author :LeonWang
 * Created  2016/11/4.18:19
 * Description:
 * E-mail:lijiawangjun@gmail.com
 */

public abstract class BaseActivity<P extends BasePersenter> extends RxBaseActivity {

    protected P mvpPerenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mvpPerenter = creatPerenter();
        super.onCreate(savedInstanceState);
    }

    protected abstract P creatPerenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mvpPerenter != null) {
            mvpPerenter.detachView();
        }
    }

    public void showLoading(){
        showProgressDialog();
    }

    public void hideLoading(){
        dismissProgressDialog();
    }
}
