package com.wzx.component;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wzx.common.base.BaseActivity;
import com.wzx.common.route.Path;
public class MainActivity extends BaseActivity {


    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {

    }

    public void onViewsClick(View view) {
        switch (view.getId()) {
            case R.id.btn_to_module_a:
                ARouter.getInstance().build(Path.MODULEA_ACTIVITY).navigation();
                break;
            case R.id.btn_to_module_b:
                ARouter.getInstance().build(Path.MODULEB_ACTIVITY).navigation();
                break;
            default:
                break;
        }
    }
}
