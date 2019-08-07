package com.example.hustcanteen.utils;

import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.example.hustcanteen.R;
import com.example.hustcanteen.location.MyLocationListener;
import com.example.hustcanteen.model.Repos;

import static com.example.hustcanteen.location.LocationFragment.mBaiduMap;
import static com.example.hustcanteen.location.LocationFragment.mMapView;

public class LocationUtil {
    public void UpdatePosition(int position) {
        LatLng pointNew = new LatLng(Repos.locationX[position], Repos.locationY[position]);
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.location);
        OverlayOptions option1 = new MarkerOptions()
                .position(pointNew)
                .icon(bitmap);
        mBaiduMap.addOverlay(option1);
        MapStatusUpdate update = MapStatusUpdateFactory.newLatLng(pointNew);
        mBaiduMap.animateMapStatus(update);
        update = MapStatusUpdateFactory.zoomTo(19f);
        mBaiduMap.animateMapStatus(update);
    }
    public void initMap(LocationClient mLocationClient) {
        mBaiduMap = mMapView.getMap();
//普通地图 ,mBaiduMap是地图控制器对象
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        mBaiduMap.setMyLocationEnabled(true);
        //定位初始化

//通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);

//设置locationClientOption
        mLocationClient.setLocOption(option);

//注册LocationListener监听器
        MyLocationListener myLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(myLocationListener);
//开启地图定位图层
        mLocationClient.start();
        mLocationClient.requestLocation();

        LatLng point = new LatLng(30.5126734947,114.4383149653);
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.location);
//构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option1 = new MarkerOptions()
                .position(point)
                .icon(bitmap);
//在地图上添加Marker，并显示
        mBaiduMap.addOverlay(option1);
    }
}
