package me.wluo.imhere.activity;


import android.app.Activity;
import android.view.MenuItem;

/**
 * Created by niwei on 2016/12/28.
 */

public class BaseActivity extends Activity {
    public void enableBack() {
        this.getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
