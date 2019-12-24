package com.wzx.issue.selectExecutor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wzx.common.base.BaseApplication;
import com.wzx.data.dao.ExecutorDao;
import com.wzx.data.entity.Executor;
import com.wzx.issue.R;
import com.wzx.common.base.BaseActivity;
import com.wzx.issue.di.component.DaggerActivityComponent;
import com.wzx.issue.di.module.ActivityModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.wzx.issue.IssuePath.PATH_SELECT_EXECUTOR;

/**
 * Description：
 * FileName：SelectExecutorActivity
 * <p>
 * Author：wzx
 * Date：2019/12/23
 *
 * <author> <time> <version> <desc>
 */

@Route(path = PATH_SELECT_EXECUTOR)
public class SelectExecutorActivity extends BaseActivity {

    @Inject
    ExecutorDao executorDao;

    private Toolbar mToolbar;

    private List<Executor> mExecutors;
    private SelectExecutorAdapter mAdapter;
    private RecyclerView mExecutorView;

    @Override
    protected int getLayoutResID() {
        return R.layout.task_activity_select_executor;
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

        mExecutorView = findViewById(R.id.rv_executor);
        mExecutorView.setLayoutManager(new LinearLayoutManager(this));
        mExecutors = new ArrayList<>();
        mAdapter = new SelectExecutorAdapter(mExecutors);
        mAdapter.setOnItemClickListener(new SelectExecutorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Executor executor) {
                Intent intent = new Intent();
                intent.putExtra("executor", executor);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        mExecutorView.setAdapter(mAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        requestExecutor();
    }

    private void requestExecutor() {
        List<Executor> lsit = executorDao.queryAll();

        mExecutors.clear();
        mExecutors.addAll(lsit);

        mAdapter.notifyDataSetChanged();
    }
}
