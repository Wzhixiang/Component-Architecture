package com.wzx.modulea;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.wzx.common.App;
import com.wzx.common.base.BaseActivity;
import com.wzx.common.route.Path;
import com.wzx.modulea.di.component.DaggerActivityComponent;
import com.wzx.modulea.entity.Task;

import javax.inject.Inject;

@Route(path = Path.MODULEA_ACTIVITY)
public class ModuleAActivity extends BaseActivity {

    @Inject
    Gson gson;

    @Override
    protected int getLayoutResID() {
        return R.layout.modulea_activity_main;
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        DaggerActivityComponent.builder().appComponent(((App) getApplication()).getAppComponent()).build().inject(this);
    }

    public void onClick(View view) {
        Task task = new Task();
        task.setName("前往五金店购买扳手");
        task.setLevel(1);
        String jsonTask = gson.toJson(task);

        Log.i("ModuleAActivity", jsonTask);

        ARouter.getInstance().build(Path.MODULEB_ACTIVITY).navigation();
    }

}
