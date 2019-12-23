package com.wzx.modulea.di.component;

import android.app.Application;

import com.wzx.common.di.component.AppComponent;
import com.wzx.common.di.scope.PerActivity;
import com.wzx.modulea.ModuleAActivity;
import com.wzx.modulea.di.module.ActivityModule;

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
    void inject(ModuleAActivity aActivity);
}
