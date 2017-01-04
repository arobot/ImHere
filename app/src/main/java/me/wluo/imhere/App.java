package me.wluo.imhere;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import me.wluo.imhere.db.DaoMaster;
import me.wluo.imhere.db.DaoSession;

/**
 * Created by niwei on 2017/1/4.
 */

public class App extends Application {
    /**
     * A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher.
     */
    public static final boolean ENCRYPTED = false;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "imhere-encrypted" : "imhere");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
