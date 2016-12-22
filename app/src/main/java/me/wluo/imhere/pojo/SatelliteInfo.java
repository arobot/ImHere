package me.wluo.imhere.pojo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;

import com.android.databinding.library.baseAdapters.BR;


/**
 * Created by niwei on 2016/12/16.
 */

public class SatelliteInfo extends BaseObservable {
    private int id;

    public String satelliteCount;
    /**
     * 纬度
     */
    public String latitude;
    /**
     * 经度
     */
    public String longitude;
    public String country;
    public String province;
    public String city;
    /**
     * 城区信息
     */
    public String district;
    public String street;
    public String streetNum;
    public String cityCode;
    public String adCode;
    public String poiName;
    /**
     * 精度
     */
    public String accuracy;
    /**
     * 海拔
     */
    public String altitude;

    public String speed;

    public String addTime;

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
