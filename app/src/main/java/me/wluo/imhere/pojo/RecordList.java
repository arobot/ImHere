package me.wluo.imhere.pojo;

import java.util.List;

/**
 * Created by niwei on 2016/12/28.
 */

public class RecordList {
    private String time;
    private List<SatelliteInfo> satelliteInfos;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<SatelliteInfo> getSatelliteInfos() {
        return satelliteInfos;
    }

    public void setSatelliteInfos(List<SatelliteInfo> satelliteInfos) {
        this.satelliteInfos = satelliteInfos;
    }
}
