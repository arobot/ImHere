package me.wluo.imhere.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import me.wluo.imhere.R;

/**
 * Created by niwei on 2016/12/28.
 */

public class AboutActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        enableBack();
    }
}
