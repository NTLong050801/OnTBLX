package com.example.onblx.Adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onblx.BienBaoModels;
import com.example.onblx.R;

import java.util.List;

public class BienBaoAdapter extends RecyclerView.Adapter<BienBaoAdapter.bienBaoViewHolder>{

    private List<BienBaoModels> mListBienBao;
    public void setData(List<BienBaoModels> list){
        this.mListBienBao = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public bienBaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bienbao, parent, false);

        return new bienBaoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull bienBaoViewHolder holder, int position) {
        BienBaoModels bienbao = mListBienBao.get(position);
        if(bienbao == null){

        }

        Bitmap bitmap = BitmapFactory.decodeByteArray(bienbao.getImgBienbao(), 0, bienbao.getImgBienbao().length);
        holder.imgBienBao.setImageBitmap(bitmap);
        holder.tvMaBienBao.setText(bienbao.getMaBienBao());
        holder.tvTenBienBao.setText(bienbao.getTenBienBao());
        holder.tvYNghiaBienBao.setText(bienbao.getyNghiaBienBao());
    }

    @Override
    public int getItemCount() {
        if(mListBienBao != null){
            return mListBienBao.size();
        }
        return 0;
    }

    public class bienBaoViewHolder extends RecyclerView.ViewHolder{
       private ImageView imgBienBao;
        private TextView tvMaBienBao, tvTenBienBao, tvYNghiaBienBao;
        public bienBaoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMaBienBao = itemView.findViewById(R.id.maBienBao);
            tvTenBienBao = itemView.findViewById(R.id.tenBienBao);
            tvYNghiaBienBao = itemView.findViewById(R.id.yNghiaBienBao);
            imgBienBao = itemView.findViewById(R.id.anhBienBao);
        }


    }
}
