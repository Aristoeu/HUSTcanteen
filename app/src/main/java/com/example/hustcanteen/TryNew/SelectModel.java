package com.example.hustcanteen.TryNew;

import static com.example.hustcanteen.TryNew.SelectData.fcts;
import static com.example.hustcanteen.TryNew.SelectData.gaodian;
import static com.example.hustcanteen.TryNew.SelectData.huicai;
import static com.example.hustcanteen.TryNew.SelectData.huncai;
import static com.example.hustcanteen.TryNew.SelectData.hunduo;
import static com.example.hustcanteen.TryNew.SelectData.mala;
import static com.example.hustcanteen.TryNew.SelectData.mianshi;
import static com.example.hustcanteen.TryNew.SelectData.p10_20;
import static com.example.hustcanteen.TryNew.SelectData.p21_30;
import static com.example.hustcanteen.TryNew.SelectData.p30_;
import static com.example.hustcanteen.TryNew.SelectData.p_10;
import static com.example.hustcanteen.TryNew.SelectData.qingdan;
import static com.example.hustcanteen.TryNew.SelectData.sucai;
import static com.example.hustcanteen.TryNew.SelectData.suduo;
import static com.example.hustcanteen.TryNew.SelectData.tangduo;
import static com.example.hustcanteen.TryNew.SelectData.tangshao;
import static com.example.hustcanteen.TryNew.SelectData.tian;
import static com.example.hustcanteen.TryNew.SelectData.wusuowei;
import static com.example.hustcanteen.TryNew.SelectData.zhongkou;
import static com.example.hustcanteen.TryNew.SelectData.zhongyou;
import static com.example.hustcanteen.recommendation.RecommendationData.DishList;

public class SelectModel {
    public Boolean judge(int i){
        float price = DishList.get(i).price;
        String kind = DishList.get(i).kind;
        String taste1 = DishList.get(i).taste1;
        String taste2 = DishList.get(i).taste2;
        return  (((p_10&&price<10)||(p10_20&&price>=10&&price<=20)||(p21_30&&price>20&&price<=30)||(p30_&&price>30))&&
               // ((fcts&&(kind.equals("汤水")||kind.equals("套饭")||kind.equals("大餐")))||(sucai&&kind.equals("素菜"))||(huncai&&kind.equals("荤菜"))||(huicai&&kind.equals("回菜"))||(gaodian&&kind.equals("糕点"))||(mianshi&&kind.equals("面类")))&&
                ((zhongkou&&taste1.equals("重口"))||(qingdan&&taste1.equals("清淡"))||(tian&&taste1.equals("甜"))||wusuowei)&&
                ((mala&&taste2.equals("麻辣"))||(zhongyou&&taste2.equals("重油"))||(hunduo&&taste2.equals("荤多"))||(suduo&&taste2.equals("素多"))||(tangduo&&taste2.equals("汤多"))||(tangshao&&taste2.equals("汤少"))));
    }
}
