package com.example.hustcanteen.location;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hustcanteen.R;
import com.example.hustcanteen.model.Hall;

import java.util.List;

public class DinningHallAdapter extends BaseAdapter {
    private Context context;
    private List<Hall> list;

    public DinningHallAdapter(List<Hall> list,  Context context) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            //引入布局
            view = View.inflate(context, R.layout.item_dinning_hall, null);
            //实例化对象
            holder.name = view.findViewById(R.id.hall_name);
            holder.address = view.findViewById(R.id.hall_address);
            holder.pic = view.findViewById(R.id.pic);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        //给控件赋值
        holder.name.setText(list.get(i).name);
        holder.address.setText(list.get(i).address);
        holder.pic.setImageBitmap(list.get(i).picture);
        //时间需要转换一下
        return view;
    }

    class ViewHolder {
        TextView name;
        TextView address;
        ImageView pic;

    }

}
