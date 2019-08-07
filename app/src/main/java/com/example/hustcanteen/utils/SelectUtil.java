package com.example.hustcanteen.utils;

import android.os.Handler;
import android.os.Message;

import com.example.hustcanteen.model.Repos;

import static com.example.hustcanteen.model.Repos.DishList;

public class SelectUtil {
    public Boolean judge(int i){
        float price = DishList.get(i).price;
        String kind = DishList.get(i).kind;
        String taste1 = DishList.get(i).taste1;
        String taste2 = DishList.get(i).taste2;
        return  (((Repos.p_10&&price<10)||(Repos.p10_20&&price>=10&&price<=20)||(Repos.p21_30&&price>20&&price<=30)||(Repos.p30_&&price>30))&&
                // ((fcts&&(kind.equals("汤水")||kind.equals("套饭")||kind.equals("大餐")))||(sucai&&kind.equals("素菜"))||(huncai&&kind.equals("荤菜"))||(huicai&&kind.equals("回菜"))||(gaodian&&kind.equals("糕点"))||(mianshi&&kind.equals("面类")))&&
                ((Repos.zhongkou&&taste1.equals("重口"))||(Repos.qingdan&&taste1.equals("清淡"))||(Repos.tian&&taste1.equals("甜"))|| Repos.wusuowei)&&
                ((Repos.mala&&taste2.equals("麻辣"))||(Repos.zhongyou&&taste2.equals("重油"))||(Repos.hunduo&&taste2.equals("荤多"))||(Repos.suduo&&taste2.equals("素多"))||(Repos.tangduo&&taste2.equals("汤多"))||(Repos.tangshao&&taste2.equals("汤少"))));
    }
    public void UpdateDistrict2(int d1, int d2, Handler mHandler) {
        if (d1 == 2&&d2 == 3){
            Message message = new Message();
            message.what = 3;
            mHandler.sendMessage(message);
            Message message1 = new Message();
            message1.what = 7;
            mHandler.sendMessage(message1);
        }
        if (d1 == 3&&d2 == 1){
            Message message = new Message();
            message.what = 1;
            mHandler.sendMessage(message);
            Message message1 = new Message();
            message1.what = 8;
            mHandler.sendMessage(message1);
        }
        if (d1 == 1&&d2 == 3){
            Message message = new Message();
            message.what = 3;
            mHandler.sendMessage(message);
            Message message1 = new Message();
            message1.what = 8;
            mHandler.sendMessage(message1);
        }
        if (d1 == 2&&d2 == 1){
            Message message = new Message();
            message.what = 1;
            mHandler.sendMessage(message);
            Message message1 = new Message();
            message1.what = 9;
            mHandler.sendMessage(message1);
        }
        if (d1 == 3&&d2 == 2){
            Message message = new Message();
            message.what = 2;
            mHandler.sendMessage(message);
            Message message1 = new Message();
            message1.what = 7;
            mHandler.sendMessage(message1);
        }
        if (d1 == 1&&d2 == 2){
            Message message = new Message();
            message.what = 2;
            mHandler.sendMessage(message);
            Message message1 = new Message();
            message1.what = 9;
            mHandler.sendMessage(message1);
        }
    }
    public void UpdateDistrict1(int d1, int d2, Handler mHandler) {
        if (d1 == 2&&d2 == 3){
            Message message = new Message();
            message.what = 2;
            mHandler.sendMessage(message);
            Message message1 = new Message();
            message1.what = 4;
            mHandler.sendMessage(message1);
        }
        if (d1 == 1&&d2 == 3){
            Message message = new Message();
            message.what = 1;
            mHandler.sendMessage(message);
            Message message1 = new Message();
            message1.what = 5;
            mHandler.sendMessage(message1);
        }
        if (d1 == 3&&d2 == 1){
            Message message = new Message();
            message.what = 3;
            mHandler.sendMessage(message);
            Message message1 = new Message();
            message1.what = 5;
            mHandler.sendMessage(message1);
        }
        if (d1 == 2&&d2 == 1){
            Message message = new Message();
            message.what = 2;
            mHandler.sendMessage(message);
            Message message1 = new Message();
            message1.what = 6;
            mHandler.sendMessage(message1);
        }
        if (d1 == 3&&d2 == 2){
            Message message = new Message();
            message.what = 3;
            mHandler.sendMessage(message);
            Message message1 = new Message();
            message1.what = 4;
            mHandler.sendMessage(message1);
        }
        if (d1 == 1&&d2 == 2){
            Message message = new Message();
            message.what = 1;
            mHandler.sendMessage(message);
            Message message1 = new Message();
            message1.what = 6;
            mHandler.sendMessage(message1);
        }
    }
}
