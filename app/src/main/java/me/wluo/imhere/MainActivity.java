package me.wluo.imhere;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationListener;
import com.idescout.sql.SqlScoutServer;

import java.text.SimpleDateFormat;
import java.util.Date;

import me.wluo.imhere.databinding.ActivityMainBinding;
import me.wluo.imhere.db.DatabaseHelper;
import me.wluo.imhere.pojo.CompassInfo;
import me.wluo.imhere.pojo.SatelliteInfo;

public class MainActivity extends Activity implements SensorEventListener, AMapLocationListener {
    //sensor
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private Sensor mMagneticField;
    //sensor data
    float[] r = new float[9];
    float[] values = new float[3];
    float[] accelerometerValues = new float[3];
    float[] magneticFieldValues = new float[3];
    //function data
    public CompassInfo compassInfo = new CompassInfo();
    public SatelliteInfo satelliteInfo = new SatelliteInfo();
    public float oldDegree;
    //animation
    public RotateAnimation rotateAnimation;
    //view
    private ImageView ivCompass;

    //Amap location object
    public AMapLocationClient mLocationClient = null;
    public AMapLocationClientOption mLocationOption = null;
    //function
    private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setSatellite(satelliteInfo);
        binding.setCompassInfo(compassInfo);
        //sensor
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mMagneticField = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        //view
        ivCompass = (ImageView) findViewById(R.id.iv_compass);
        doAmap();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mMagneticField, SensorManager.SENSOR_DELAY_NORMAL);
        mLocationClient.startLocation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
        mLocationClient.stopLocation();
    }

    public void doAmap() {
        mLocationClient = new AMapLocationClient(this);
        mLocationClient.setLocationListener(this);
        mLocationOption = new AMapLocationClientOption();
        mLocationOption.setLocationMode(AMapLocationMode.Hight_Accuracy);
        mLocationOption.setNeedAddress(true);
        mLocationOption.setMockEnable(true);
        mLocationOption.setWifiScan(true);
        mLocationClient.setLocationOption(mLocationOption);
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {    //加速计
            accelerometerValues = sensorEvent.values;
        }
        if (sensorEvent.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {   //磁场计
            magneticFieldValues = sensorEvent.values;
        }
        SensorManager.getRotationMatrix(r, null, accelerometerValues, magneticFieldValues);
        SensorManager.getOrientation(r, values);
        values[0] = (float) Math.toDegrees(values[0]);
        compassInfo.setDegree(String.format("%s°", degreeFormatter(values[0])));
        compassInfo.setDirection(getDirection(values[0]));
        rotateObject(ivCompass, values[0]);
//        System.out.println("degree=" + Math.toDegrees(values[0]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void rotateObject(View view, float degree) {
        rotateAnimation = new RotateAnimation(-oldDegree, -degree, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        oldDegree = degree;
        rotateAnimation.setFillAfter(true);
        view.startAnimation(rotateAnimation);
    }

    public String degreeFormatter(float degree) {
        float d = accuracyFormatter(degree);
        d = d > 0 ? d : d + 360;
        return String.valueOf(d);
    }

    public float accuracyFormatter(float data) {
        return (float) (Math.round(data * 10)) / 10;
    }

    public String getDirection(float degree) {
        int d = Math.round(degree);
        d = d > 0 ? d : d + 360;
        if (337 <= d || d < 23)
            return "北";
        else if (23 <= d && d < 67)
            return "东北";
        else if (67 <= d && d < 112)
            return "东";
        else if (112 <= d && d < 157)
            return "东南";
        else if (157 <= d && d < 202)
            return "南";
        else if (202 <= d && d < 247)
            return "西南";
        else if (247 <= d && d < 292)
            return "西";
        else if (292 <= d && d < 337)
            return "西北";
        else return "北";
    }

    public String getGpsDegree(boolean isLongitude, double location) {
        String name;
        if (isLongitude)
            name = location > 0 ? "东经" : "西经";
        else
            name = location > 0 ? "北纬" : "南纬";
        location = Math.abs(location);
        int du = (int) location / 1;
        int fen = (int) (location % 1 * 60) / 1;
        int miao = (int) (location % 1 * 60 % 1 * 60 / 1);
        return String.format("%s %d°%d'%d\"", name, du, fen, miao);
    }


    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {
                //可在其中解析amapLocation获取相应内容。
                String longitude = getGpsDegree(true, aMapLocation.getLongitude());
                satelliteInfo.setLongitude(longitude);
                String latitude = getGpsDegree(false, aMapLocation.getLatitude());
                satelliteInfo.setLatitude(latitude);
                satelliteInfo.setProvince(aMapLocation.getProvince());
                satelliteInfo.setCity(aMapLocation.getCity());
                satelliteInfo.setPoiName(aMapLocation.getPoiName());
                satelliteInfo.setDistrict(aMapLocation.getDistrict());
                satelliteInfo.setAdCode(aMapLocation.getAdCode());
                satelliteInfo.setCityCode(aMapLocation.getCityCode());
                satelliteInfo.setStreet(aMapLocation.getStreet());
                satelliteInfo.setStreetNum(aMapLocation.getStreetNum());
                satelliteInfo.setAccuracy(String.format("精度 %s m", accuracyFormatter(aMapLocation.getAccuracy())));
                satelliteInfo.setAltitude(String.format("海拔 %s m", accuracyFormatter((float) aMapLocation.getAltitude())));
                String speed = String.format("%05.1f", accuracyFormatter(aMapLocation.getSpeed()));
                satelliteInfo.setSpeed(String.format("V %s m/s", speed));
                Date date = new Date(aMapLocation.getTime());
                satelliteInfo.setAddTime(df.format(date));
            } else {
                //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                Log.e("AmapError", "location Error, ErrCode:"
                        + aMapLocation.getErrorCode() + ", errInfo:"
                        + aMapLocation.getErrorInfo());
            }
        }
    }

    /**
     * OnClick method
     * 添加记录按钮监听器
     *
     * @param view
     */
    public void insertRecord(View view) {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        dbHelper.insertRecord(satelliteInfo);
        System.out.println("db items count:" + dbHelper.readAllRecords().size());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationClient.onDestroy();
    }
}
