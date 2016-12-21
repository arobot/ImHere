package me.wluo.imhere.pojo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by niwei on 2016/12/19.
 */

public class CompassInfo extends BaseObservable {
    /**
     * 罗盘的方向
     */
    public String direction;
    /**
     * 方位角度
     */
    public String degree;

    @Bindable
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
        notifyPropertyChanged(BR.direction);
    }

    @Bindable
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
        notifyPropertyChanged(BR.degree);
    }
}
