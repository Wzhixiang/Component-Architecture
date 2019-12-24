package com.wzx.executor.add;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.snackbar.Snackbar;
import com.wzx.common.base.BaseActivity;
import com.wzx.data.DataBaseImpl;
import com.wzx.data.entity.Executor;
import com.wzx.executor.R;

import static com.wzx.executor.ExecutorPath.PATH_ADD_EXECUTOR;

/**
 * Description：任务列表
 * FileName：AddExecutorActivity
 * <p>
 * Author：wzx
 * Date：2019/12/23
 *
 * <author> <time> <version> <desc>
 */

@Route(path = PATH_ADD_EXECUTOR)
public class AddExecutorActivity extends BaseActivity {

    private Toolbar mToolbar;
    private EditText mNameView;
    private ImageView mSureView;

    @Override
    protected int getLayoutResID() {
        return R.layout.executor_activity_tasks;
    }

    @Override
    protected void initViews(@Nullable Bundle savedInstanceState) {
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_back_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mNameView = findViewById(R.id.et_name);
        mSureView = findViewById(R.id.iv_sure);

        mSureView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveExecutor(v);
            }
        });
    }

    private void saveExecutor(View v) {
        String name = mNameView.getText().toString();
        if (TextUtils.isEmpty(name)) {
            Snackbar.make(v, "请输入名称", Snackbar.LENGTH_SHORT).show();
            return;
        }
        Executor executer = new Executor();
        executer.setName(name);

        DataBaseImpl.getInstance(this).getExecuterDao().insert(executer);

        Snackbar.make(v, "添加成功", Snackbar.LENGTH_SHORT).show();

        finish();
    }
}
