package com.wzx.moduleb;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wzx.common.base.BaseActivity;
import com.wzx.common.route.Path;

@Route(path = Path.MODULEB_ACTIVITY)
public class ModuleBActivity extends BaseActivity {

    @Override
    protected int getLayoutResID() {
        return R.layout.moduleb_activity_main;
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {

    }

    public void onClick(View view){
        ARouter.getInstance().build(Path.MODULEA_ACTIVITY).navigation();
    }
}
