package me.wluo.imhere.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import me.wluo.imhere.pojo.SatelliteInfo;

/**
 * Created by niwei on 2016/12/22.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    /**
     * 数据库版本，需要升级数据库的时候加1即可
     */
    private static final int DATABASE_VERSION = 1;
    /**
     * 数据库名称
     */
    private static final String DATABASE_NAME = "ImHere.db";

    private static final String TABLE_LOCATION_RECORD = "location";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * 该方法只在数据库创建的时候调用一次
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " +
                TABLE_LOCATION_RECORD +
                " ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "province VARCHAR(16)," +
                "city VARCHAR(16)," +
                "district VARCHAR(16)," +
                "street VARCHAR(24)," +
                "streetNum VARCHAR(8)," +
                "poi VARCHAR(56)," +
                "cityCode VARCHAR(4)," +
                "time DATETIME" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * 插入一条定位数据
     *
     * @param s
     */
    public void insertRecord(SatelliteInfo s) {
        //打开一个可读可写的数据库供插入数据
        SQLiteDatabase database = getWritableDatabase();
        //向location表中插入一条数据
        database.execSQL("insert into " +
                        TABLE_LOCATION_RECORD +
                        "(province, " +
                        "city, " +
                        "district, " +
                        "street, " +
                        "streetNum, " +
                        "poi, " +
                        "cityCode, " +
                        "time) " +
                        "values(?,?,?,?,?,?,?,?)",
                new Object[]
                        {s.getProvince(), s.getCity(), s.getDistrict(), s.getStreet(), s.getStreetNum(), s.getPoiName(), s.getCityCode(), s.getAddTime()});
    }

    /**
     * 删除数据库一条数据
     *
     * @param id
     */
    public void deleteARecord(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from " +
                        TABLE_LOCATION_RECORD +
                        " where " +
                        "id=?",
                new Object[]{id});
    }

    /**
     * 获取所有的记录信息
     *
     * @return {@link SatelliteInfo} 列表信息
     */
    public List<SatelliteInfo> readAllRecords() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_LOCATION_RECORD, new String[]{});
        List<SatelliteInfo> satelliteInfos = new ArrayList<>();
        while (cursor.moveToNext()) {
            SatelliteInfo satelliteInfo = new SatelliteInfo();
            satelliteInfo.setId(cursor.getInt(cursor.getColumnIndex("id")));
            satelliteInfo.setProvince(cursor.getString(cursor.getColumnIndex("province")));
            satelliteInfo.setCity(cursor.getString(cursor.getColumnIndex("city")));
            satelliteInfo.setDistrict((cursor.getString(cursor.getColumnIndex("district"))));
            satelliteInfo.setStreet(cursor.getString(cursor.getColumnIndex("street")));
            satelliteInfo.setStreetNum(cursor.getString(cursor.getColumnIndex("streetNum")));
            satelliteInfo.setPoiName(cursor.getString(cursor.getColumnIndex("poi")));
            satelliteInfo.setCityCode(cursor.getString(cursor.getColumnIndex("cityCode")));
            satelliteInfo.setAddTime(cursor.getString(cursor.getColumnIndex("time")));
            satelliteInfos.add(satelliteInfo);
        }
        cursor.close();
        return satelliteInfos;
    }
}
