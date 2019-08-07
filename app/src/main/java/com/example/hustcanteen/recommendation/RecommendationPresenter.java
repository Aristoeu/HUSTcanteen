package com.example.hustcanteen.recommendation;

import android.content.Context;
import android.view.View;

import com.example.hustcanteen.utils.ClassifyUtil;


class RecommendationPresenter {
    private ClassifyUtil util;
    RecommendationPresenter(ClassifyUtil util){
        this.util = util;
    }
    void setClassifiedData(Context context, View view, String item1, String item2) {
        util.setClassifiedData(context,view,item1,item2);
    }
    void setClassifiedData(Context context, View view, String item1) {
        util.setClassifiedData(context,view,item1);
    }
}
