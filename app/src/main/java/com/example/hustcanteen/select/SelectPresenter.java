package com.example.hustcanteen.select;


import android.os.Handler;

import com.example.hustcanteen.utils.SelectUtil;

class SelectPresenter {
    private SelectUtil selectUtil;
    SelectPresenter(){
        this.selectUtil = new SelectUtil();
    }
    public Boolean judge(int i){
        return selectUtil.judge(i);
    }
    void UpdateDistrict1(int d1, int d2, Handler handler){
        selectUtil.UpdateDistrict1(d1,d2,handler);
    }
    void UpdateDistrict2(int d1,int d2,Handler handler){
        selectUtil.UpdateDistrict2(d1,d2,handler);
    }
}
