package com.wzx.common.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Description：
 * FileName：PerActivity
 * <p>
 * Author：wzx
 * Date：2019/12/20
 *
 * <author> <time> <version> <desc>
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface PerActivity {
}
