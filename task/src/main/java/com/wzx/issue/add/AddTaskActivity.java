package com.wzx.issue.add;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.snackbar.Snackbar;
import com.wzx.common.base.BaseApplication;
import com.wzx.data.dao.TaskDao;
import com.wzx.issue.R;
import com.wzx.common.base.BaseActivity;
import com.wzx.data.entity.Executor;
import com.wzx.data.entity.Task;
import com.wzx.issue.di.component.DaggerActivityComponent;
import com.wzx.issue.di.module.ActivityModule;


import javax.inject.Inject;

import static com.wzx.issue.IssuePath.PATH_ADD_TASKS;
import static com.wzx.issue.IssuePath.PATH_SELECT_EXECUTOR;

/**
 * Description：发布任务
 * FileName：AddTaskActivity
 * <p>
 * Author：wzx
 * Date：2019/12/23
 *
 * <author> <time> <version> <desc>
 */

@Route(path = PATH_ADD_TASKS)
public class AddTaskActivity extends BaseActivity {

    private static final int REQUEST_CODE_SELECT_EXECUTOR = 100;

    @Inject
    TaskDao taskDao;

    private Toolbar mToolbar;

    private EditText mNameView;

    private TextView mExecutorView;

    private ImageView mSureView, mSelectExecutorView;

    private volatile Executor selectedExecutor;

    @Override
    protected int getLayoutResID() {
        return R.layout.task_activity_add_task;
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        DaggerActivityComponent.builder()
                .activityModule(new ActivityModule())
                .appComponent(((BaseApplication) getApplication()).getAppComponent())
                .build()
                .inject(this);

        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_back_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mSureView = findViewById(R.id.iv_sure);
        mSureView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTask(v);
            }
        });

        mNameView = findViewById(R.id.et_task_name);

        mExecutorView = findViewById(R.id.tv_select_executor);

        mSelectExecutorView = findViewById(R.id.iv_select_executor);
        mSelectExecutorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectExecutor();
            }
        });
    }

    private void saveTask(View view) {
        String name = mNameView.getText().toString();

        if (TextUtils.isEmpty(name)) {
            Snackbar.make(view, "请输入任务名称", Snackbar.LENGTH_SHORT).show();
            return;
        }

        Task task = new Task();
        task.setTitle(name);
        if (selectedExecutor != null) {
            task.setExecutorID(selectedExecutor.getId());
        }
        taskDao.insert(task);

        Snackbar.make(view, "保存成功", Snackbar.LENGTH_SHORT).show();

        finish();
    }

    private void selectExecutor() {
        ARouter.getInstance().build(PATH_SELECT_EXECUTOR).navigation(this, REQUEST_CODE_SELECT_EXECUTOR);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_SELECT_EXECUTOR) {
            selectedExecutor = data.getParcelableExtra("executor");
            if (selectedExecutor != null) {
                mExecutorView.setText(selectedExecutor.getName());
            }
        }
    }
}
