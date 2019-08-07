package com.example.hustcanteen.location;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.baidu.location.LocationClient;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.example.hustcanteen.others.TimeActivity;
import com.example.hustcanteen.base.BaseFragment;
import com.example.hustcanteen.R;
import com.example.hustcanteen.model.Repos;

import java.util.ArrayList;

import static com.example.hustcanteen.model.Repos.ChosenHallList;
import static com.example.hustcanteen.model.Repos.HallList;
import static com.example.hustcanteen.model.Repos.hallName;
import static com.example.hustcanteen.model.Repos.locationString;

public class LocationFragment extends BaseFragment implements  LocationView {
    public static MapView mMapView = null;
    public static BaiduMap mBaiduMap;
    public LocationClient mLocationClient ;
    private ListView listView;
    public static Boolean isFirstLocate = true;
    private EditText editText;
    private ImageView times;
    private DinningHallAdapter adapterTotal;
    private LocationPresenter presenter = new LocationPresenter();
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment2, null);
        mMapView = view.findViewById(R.id.bmapView);
        Spinner spinner = view.findViewById(R.id.spinner);
        listView = view.findViewById(R.id.listview);
        editText = view.findViewById(R.id.edit_text);
        times = view.findViewById(R.id.times);
        ImageView search = view.findViewById(R.id.search);
        ImageView down = view.findViewById(R.id.down);
        adapterTotal = new DinningHallAdapter(Repos.HallList,getContext());
        listView.setAdapter(adapterTotal);
        presenter.initMap(mLocationClient);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                presenter.UpdatePosition(position);
                listView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(ChosenHallList.isEmpty())
                presenter.UpdatePosition(i);
                else presenter.UpdatePosition(ChosenHallList.get(i).index);
                listView.setVisibility(View.INVISIBLE);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateHallViews();
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setVisibility(View.INVISIBLE);
            }
        });
        times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), TimeActivity.class));
            }
        });
        return view;
    }
    @Override
    public void UpdateHallViews() {
        boolean Found = false;
        String s = editText.getText().toString();
        ChosenHallList = new ArrayList<>();
        listView.setVisibility(View.VISIBLE);
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        mLocationClient = new LocationClient(getContext());
    }
    /**
     * 实现定位回调
     */

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
