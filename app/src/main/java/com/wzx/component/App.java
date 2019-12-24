package com.wzx.component;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wzx.common.base.BaseApplication;


/**
 * Description：
 * FileName：App
 * <p>
 * Author：wzx
 * Date：2019/12/20
 *
 * <author> <time> <version> <desc>
 */
public class App extends BaseApplication {

    private static final String[] MODULES = {
            "com.wzx.modulea",
            "com.wzx.moduleb"
    };

    @Override
    protected void init() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    @Override
    protected String[] getModules() {
        return MODULES;
    }
}
