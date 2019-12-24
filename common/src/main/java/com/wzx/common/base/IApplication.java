package com.wzx.common.base;

import android.app.Application;

/**
 * Description：组件需要在application中初始化具体类的情况下，需要实现该类
 * FileName：IApplication
 * <p>
 * Author：wzx
 * Date：2019/12/20
 *
 * <author> <time> <version> <desc>
 */
public interface IApplication {
    void init(Application application);
}
