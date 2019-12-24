package com.wzx.component;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wzx.common.base.BaseActivity;
import com.wzx.executor.ExecutorPath;
import com.wzx.issue.IssuePath;

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
            case R.id.btn_to_add_executor:
                ARouter.getInstance().build(ExecutorPath.PATH_ADD_EXECUTOR).navigation();
                break;
            case R.id.btn_to_task:
                ARouter.getInstance().build(IssuePath.PATH_TASKS).navigation();
                break;
            default:
                break;
        }
    }
}
