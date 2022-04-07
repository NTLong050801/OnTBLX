package com.example.onblx.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onblx.BienBaoModels;
import com.example.onblx.R;

import java.util.List;

public class BienBaooAdapter extends BaseAdapter {
    private TextView maBienBao;
    private TextView tenBienBao;
    private TextView yNghiaBienBao;
    private ImageView imgBienBao;
    Context myContext;
    int myLayout;
    List<BienBaoModels> arrayBienBao;

    public BienBaooAdapter(Context context, int layout, List<BienBaoModels> listBienBao){
        myContext = context;
        myLayout = layout;
        arrayBienBao = listBienBao;
    }

    @Override
    public int getCount() {
        return arrayBienBao.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(myLayout, null);

        //Ánh xạ và gán giá trị
        imgBienBao = (ImageView) convertView.findViewById(R.id.anhBienBao);
        maBienBao = (TextView) convertView.findViewById(R.id.maBienBao);
        tenBienBao = (TextView) convertView.findViewById(R.id.tenBienBao);
        yNghiaBienBao = (TextView) convertView.findViewById(R.id.yNghiaBienBao);

        Bitmap bitmap = BitmapFactory.decodeByteArray(arrayBienBao.get(position).getImgBienbao(), 0,arrayBienBao.get(position).getImgBienbao().length );
        imgBienBao.setImageBitmap(bitmap);
        maBienBao.setText(arrayBienBao.get(position).maBienBao);
        tenBienBao.setText(arrayBienBao.get(position).tenBienBao);
        yNghiaBienBao.setText(arrayBienBao.get(position).yNghiaBienBao);
        return convertView;
    }
}
