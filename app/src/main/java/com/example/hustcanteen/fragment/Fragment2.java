package com.example.hustcanteen.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.example.hustcanteen.BottomDrawerLayout;
import com.example.hustcanteen.DinningHallAdapter;
import com.example.hustcanteen.Hall;
import com.example.hustcanteen.R;
import com.example.hustcanteen.location.LocationData;

import java.util.ArrayList;
import java.util.List;

import static com.example.hustcanteen.location.LocationData.ChosenHallList;
import static com.example.hustcanteen.location.LocationData.HallList;
import static com.example.hustcanteen.location.LocationData.hallName;
import static com.example.hustcanteen.location.LocationData.locationString;
import static com.example.hustcanteen.location.LocationData.locationX;
import static com.example.hustcanteen.location.LocationData.locationY;
import static com.example.hustcanteen.location.LocationData.picitures;

public class Fragment2 extends BaseFragment {
    private MapView mMapView = null;
    private BaiduMap mBaiduMap;
    private LocationClient mLocationClient;
    private Spinner spinner;
    private ListView listView;
    private Boolean isFirstLocate = true;
    private EditText editText;
    private ImageView search;
    private BottomDrawerLayout bottomDrawerLayout;
    private DinningHallAdapter adapterTotal;
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment2, null);
        mMapView = view.findViewById(R.id.bmapView);
        spinner = view.findViewById(R.id.spinner);
        listView = view.findViewById(R.id.listview);
        editText = view.findViewById(R.id.edit_text);
        search = view.findViewById(R.id.search);
        bottomDrawerLayout = view.findViewById(R.id.bottom_drawer_layout);
        adapterTotal = new DinningHallAdapter(LocationData.HallList,getContext());
        listView.setAdapter(adapterTotal);
        mBaiduMap = mMapView.getMap();
//普通地图 ,mBaiduMap是地图控制器对象
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        mBaiduMap.setMyLocationEnabled(true);
        //定位初始化
        mLocationClient = new LocationClient(getContext());

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
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                UpdatePosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                bottomDrawerLayout.minimize();
                if(ChosenHallList.isEmpty())
                UpdatePosition(i);
                else UpdatePosition(ChosenHallList.get(i).index);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean Found = false;
                String s = editText.getText().toString();
                ChosenHallList = new ArrayList<>();
                if (s.equals("")) {
                    Toast.makeText(getContext(), "请在输入框里输入内容哦", Toast.LENGTH_SHORT).show();
                    listView.setAdapter(adapterTotal);
                }
                else {
                    for (int i = 0; i < locationString.length; i++) {
                        if (hallName[i].contains(s)) {
                            ChosenHallList.add(HallList.get(i));
                            Found = true;
                        }
                    }
                if (Found) {
                        DinningHallAdapter adapter = new DinningHallAdapter(ChosenHallList, getContext());
                        listView.setAdapter(adapter);
                    } else {
                    Toast.makeText(getContext(), "没找到哦，换个词试试", Toast.LENGTH_SHORT).show();
                    //ChosenHallList = new ArrayList<>();
                    listView.setAdapter(adapterTotal);
                }
                }
            }
        });
        return view;
    }

    private void UpdatePosition(int position) {
        LatLng pointNew = new LatLng(locationX[position],locationY[position]);
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();

    }
    /**
     * 实现定位回调
     */
    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //mapView 销毁后不在处理新接收的位置
            if (location == null || mMapView == null){
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);
            if (isFirstLocate) {
                LatLng ll = new LatLng(location.getLatitude(), location.getLongitude());
                MapStatusUpdate update = MapStatusUpdateFactory.newLatLng(ll);
                mBaiduMap.animateMapStatus(update);
                update = MapStatusUpdateFactory.zoomTo(19f);
                mBaiduMap.animateMapStatus(update);
                isFirstLocate = false;
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
    @Override
    public void onDestroy() {
        mLocationClient.stop();
        mBaiduMap.setMyLocationEnabled(false);
        mMapView.onDestroy();
        mMapView = null;
        super.onDestroy();
    }
}
