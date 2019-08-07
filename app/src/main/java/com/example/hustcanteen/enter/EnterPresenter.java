package com.example.hustcanteen.enter;

import android.content.Context;

import com.example.hustcanteen.utils.ReadHallsUtil;

class EnterPresenter {
    private ReadHallsUtil readHallsUtil;
    EnterPresenter(ReadHallsUtil readHallsUtil){
        this.readHallsUtil = readHallsUtil;
    }
    void LoadDatas(Context context){
        readHallsUtil.loadDatas(context);
    }
}
