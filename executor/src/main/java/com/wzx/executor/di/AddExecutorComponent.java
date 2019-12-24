package com.wzx.executor.di;

import com.wzx.common.di.component.AppComponent;
import com.wzx.common.di.scope.PerActivity;
import com.wzx.executor.add.AddExecutorActivity;

import dagger.Component;

/**
 * Description：
 * FileName：AddExecutorComponent
 * <p>
 * Author：wzx
 * Date：2019/12/24
 *
 * <author> <time> <version> <desc>
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = AddExecutorModule.class)
public interface AddExecutorComponent {

    void inject(AddExecutorActivity activity);
}
