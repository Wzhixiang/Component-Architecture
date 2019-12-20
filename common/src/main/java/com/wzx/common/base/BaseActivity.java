package com.wzx.common.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Description：
 * FileName：BaseActivity
 * <p>
 * Author：wzx
 * Date：2019/12/20
 *
 * <author> <time> <version> <desc>
 */
public abstract class BaseActivity extends AppCompatActivity {

    @LayoutRes
    protected abstract int getLayoutResID();

    protected abstract void initViews(@Nullable Bundle savedInstanceState);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutResID());

        initViews(savedInstanceState);
    }
}
