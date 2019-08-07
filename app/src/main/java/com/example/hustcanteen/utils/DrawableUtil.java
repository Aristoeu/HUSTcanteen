package com.example.hustcanteen.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.example.hustcanteen.R;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;


public class DrawableUtil {
    private Context context;

    public DrawableUtil(Context context) {
        this.context = context;
    }

    /**
     * 批量获取指定图片 imageResourceId
     *
     * @param imgName 图片名字的部分或全部
     * @return 图片名字中包含有imgName的所有图片 imageResourceId
     * <p>
     * 使用示例： 如有5张图片: image_0 ,image_1 ,image_2 , image_3 ,image_4 ;
     * 调用方法 getImageResourId("image_")  ,则会得到上面的5张图片的imageResourceId
     * 如果传入的imgName为全名则返回的就是一张图片
     */
    public List<Integer> getImageResourId(String imgName) {
        List<Integer> imgList = new ArrayList<>();
        Resources resources = context.getResources();
        Field[] fields = R.drawable.class.getDeclaredFields();
       for (int i = 0;i<126;i++){
           int id = resources.getIdentifier("canteen"+(i+1),"drawable","com.example.hustcanteen");
           imgList.add(id);
       }
        return imgList;
    }


}
