package com.wzx.modulea;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wzx.common.base.BaseActivity;
import com.wzx.common.route.Path;

@Route(path = Path.MODULEA_ACTIVITY)
public class ModuleAActivity extends BaseActivity {

    @Override
    protected int getLayoutResID() {
        return R.layout.modulea_activity_main;
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {

    }

    public void onClick(View view) {
        ARouter.getInstance().build(Path.MODULEB_ACTIVITY).navigation();
    }

}
