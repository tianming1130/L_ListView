package com.sun.l_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

/**
 * Created by sun on 2017/10/30.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String,Object>> dataList;
    public MyAdapter(Context context,List<Map<String,Object>> dataList){
        this.context=context;
        this.dataList=dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.list_item,null);
            viewHolder.ivMenu=(ImageView) convertView.findViewById(R.id.img_menu);
            viewHolder.tvTitle=(TextView)convertView.findViewById(R.id.tv_title);
            viewHolder.tvMajorMaterial=(TextView) convertView.findViewById(R.id.tv_major_material);
            viewHolder.tvMinorMaterial=(TextView)convertView.findViewById(R.id.tv_minor_material);
            viewHolder.tvPrice=(TextView)convertView.findViewById(R.id.tv_price);
            viewHolder.cbPick=(CheckBox)convertView.findViewById(R.id.cb_pick);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }

        viewHolder.ivMenu.setImageResource((int)dataList.get(position).get("img"));
        viewHolder.tvTitle.setText((String)dataList.get(position).get("title"));
        viewHolder.tvMajorMaterial.setText((String)dataList.get(position).get("major_material"));
        viewHolder.tvMinorMaterial.setText((String)dataList.get(position).get("minor_material"));
        viewHolder.tvPrice.setText((String)dataList.get(position).get("price"));
        viewHolder.cbPick.setChecked((boolean)dataList.get(position).get("pick"));

        viewHolder.cbPick.setOnCheckedChangeListener(new MyOnCheckedChangeListener(position));
        return convertView;
    }
    private class ViewHolder{
        ImageView ivMenu;
        TextView tvTitle;
        TextView tvMajorMaterial;
        TextView tvMinorMaterial;
        TextView tvPrice;
        CheckBox cbPick;
    }

    private class MyOnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {
        private int postion;

        public MyOnCheckedChangeListener(int postion){
            this.postion=postion;
        }
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Toast.makeText(context,"信息："+postion+":"+isChecked,Toast.LENGTH_SHORT).show();
        }
    }
}