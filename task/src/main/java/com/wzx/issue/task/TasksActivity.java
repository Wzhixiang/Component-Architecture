package com.wzx.issue.task;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.wzx.data.DataBaseImpl;
import com.wzx.data.entity.InnerTaskExecutor;
import com.wzx.issue.R;
import com.wzx.common.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import static com.wzx.issue.IssuePath.PATH_ADD_TASKS;
import static com.wzx.issue.IssuePath.PATH_TASKS;

/**
 * Description：
 * FileName：TasksActivity
 * <p>
 * Author：wzx
 * Date：2019/12/23
 *
 * <author> <time> <version> <desc>
 */
@Route(path = PATH_TASKS)
public class TasksActivity extends BaseActivity {

    private Toolbar mToolbar;

    private RecyclerView mRecyclerView;

    private List<InnerTaskExecutor> tasks;
    private TaskAdapter mAdapter;

    private FloatingActionButton mAddTaskView;

    @Override
    protected int getLayoutResID() {
        return R.layout.task_activity_tasks;
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

        mAddTaskView = findViewById(R.id.add_task);
        mAddTaskView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(PATH_ADD_TASKS).navigation();
            }
        });

        mRecyclerView = findViewById(R.id.rv_tasks);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tasks = new ArrayList<>();
        mAdapter = new TaskAdapter(tasks);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        getTasks();
    }

    private void getTasks() {
        List<InnerTaskExecutor> list = DataBaseImpl.getInstance(this).getTaskDao().queryTask();

        tasks.clear();
        tasks.addAll(list);

        mAdapter.notifyDataSetChanged();

    }
}
