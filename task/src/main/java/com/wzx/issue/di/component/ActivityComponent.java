package com.wzx.issue.di.component;

import com.wzx.common.di.component.AppComponent;
import com.wzx.common.di.scope.PerActivity;
import com.wzx.issue.add.AddTaskActivity;
import com.wzx.issue.di.module.ActivityModule;
import com.wzx.issue.selectExecutor.SelectExecutorActivity;
import com.wzx.issue.task.TasksActivity;

import dagger.Component;

/**
 * Description：
 * FileName：ActivityComponent
 * <p>
 * Author：wzx
 * Date：2019/12/20
 *
 * <author> <time> <version> <desc>
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(TasksActivity activity);

    void inject(AddTaskActivity activity);

    void inject(SelectExecutorActivity activity);
}
