package com.wzx.executor;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wzx.common.base.IApplication;

/**
 * Description：
 * FileName：IApplicationImpl
 * <p>
 * Author：wzx
 * Date：2019/12/23
 *
 * <author> <time> <version> <desc>
 */
public class IApplicationImpl implements IApplication {

    public static IApplicationImpl create(){
        return new IApplicationImpl();
    }

    @Override
    public void init(Application application) {
        ARouter.init(application);
    }
}
