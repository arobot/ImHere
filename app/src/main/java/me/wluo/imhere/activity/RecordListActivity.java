package me.wluo.imhere.activity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import me.wluo.imhere.App;
import me.wluo.imhere.R;
import me.wluo.imhere.db.DaoSession;
import me.wluo.imhere.db.SatelliteInfoDao;
import me.wluo.imhere.pojo.SatelliteInfo;

/**
 * Created by niwei on 2016/12/28.
 */

public class RecordListActivity extends BaseActivity {
    //dao
    SatelliteInfoDao satelliteInfoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records_list);
        enableBack();

        //dao
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        satelliteInfoDao = daoSession.getSatelliteInfoDao();

        getRecordList();
    }

    public void getRecordList() {
        List<SatelliteInfo> satelliteInfos = satelliteInfoDao.queryBuilder().build().list();
        Log.i("records_list", "count " + satelliteInfos.size());
    }
}
