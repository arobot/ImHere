package me.wluo.imhere.pojo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;


/**
 * Created by niwei on 2016/12/16.
 */
@Entity(nameInDb = "location")
public class SatelliteInfo extends BaseObservable {
    @Id
    private long id;
    @Transient
    private String satelliteCount;
    /**
     * 纬度
     */
    @Transient
    private String latitude;
    /**
     * 经度
     */
    @Transient
    private String longitude;
    @Transient
    private String country;

    private String province;
    private String city;
    /**
     * 城区信息
     */
    private String district;
    private String street;
    private String streetNum;
    private String cityCode;
    @Transient
    private String adCode;
    @Property(nameInDb = "poi")
    private String poiName;
    /**
     * 精度
     */
    private String accuracy;
    /**
     * 海拔
     */
    private String altitude;
    @Transient
    private String speed;
    @Property(nameInDb = "time")
    private String addTime;

    @Generated(hash = 448019116)
    public SatelliteInfo(long id, String province, String city, String district,
            String street, String streetNum, String cityCode, String poiName, String accuracy,
            String altitude, String addTime) {
        this.id = id;
        this.province = province;
        this.city = city;
        this.district = district;
        this.street = street;
        this.streetNum = streetNum;
        this.cityCode = cityCode;
        this.poiName = poiName;
        this.accuracy = accuracy;
        this.altitude = altitude;
        this.addTime = addTime;
    }

    @Generated(hash = 1460895732)
    public SatelliteInfo() {
    }

    @Bindable
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getSatelliteCount() {
        return this.satelliteCount;
    }

    public void setSatelliteCount(String satelliteCount) {
        this.satelliteCount = satelliteCount;
        notifyPropertyChanged(BR.satelliteCount);
    }

    @Bindable
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
        notifyPropertyChanged(BR.latitude);
    }

    @Bindable
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
        notifyPropertyChanged(BR.longitude);
    }

    @Bindable
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
        notifyPropertyChanged(BR.country);
    }

    @Bindable
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
        notifyPropertyChanged(BR.province);
    }

    @Bindable
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        notifyPropertyChanged(BR.city);
    }

    @Bindable
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
        notifyPropertyChanged(BR.district);
    }


    @Bindable
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
        notifyPropertyChanged(BR.street);
    }

    @Bindable
    public String getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
        notifyPropertyChanged(BR.streetNum);
    }

    @Bindable
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
        notifyPropertyChanged(BR.cityCode);
    }

    @Bindable
    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
        notifyPropertyChanged(BR.adCode);
    }


    @Bindable
    public String getPoiName() {
        return poiName;
    }

    public void setPoiName(String poiName) {
        this.poiName = poiName;
        notifyPropertyChanged(BR.poiName);
    }

    @Bindable
    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
        notifyPropertyChanged(BR.accuracy);
    }

    @Bindable
    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
        notifyPropertyChanged(BR.altitude);
    }

    @Bindable
    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
        notifyPropertyChanged(BR.speed);
    }

    @Bindable
    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
        notifyPropertyChanged(BR.addTime);
    }
}
