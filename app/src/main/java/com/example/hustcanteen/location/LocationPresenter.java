package com.example.hustcanteen.location;

import com.baidu.location.LocationClient;
import com.example.hustcanteen.utils.LocationUtil;

public class LocationPresenter {
    private LocationUtil util;
    LocationPresenter(){
        this.util = new LocationUtil();
    }
    void UpdatePosition(int position){
        util.UpdatePosition(position);
    }
    void initMap(LocationClient mLocationClient){
        util.initMap(mLocationClient);
    }
}
