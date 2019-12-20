package com.wzx.modulea;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wzx.common.IApplication;

/**
 * Description：
 * FileName：AApplication
 * <p>
 * Author：wzx
 * Date：2019/12/20
 *
 * <author> <time> <version> <desc>
 */
public class AApplication implements IApplication {

    @Override
    public void init(Application application) {
        ARouter.init(application);
    }
}
