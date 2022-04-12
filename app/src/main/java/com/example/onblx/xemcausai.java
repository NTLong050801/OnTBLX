package com.example.onblx;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import adapter.CauSaiAdapter;
import adapter.GrCauHoiAdapter;
import database.DataBase;

public class xemcausai extends AppCompatActivity {
    TextView tvCacCausai;
    ListView lvCauSai;
    Model model  ;
    CauSaiAdapter cauSaiAdapter;
    Button btnDeleteAlL;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xemcausai);
        anhxa();
        model = new Model(this);

        int SoCauSai = model.TongCauSai();
        if(SoCauSai <= 0){
            tvCacCausai.setText("Chưa có câu sai nào !");
            btnDeleteAlL.setVisibility(View.GONE);
        }else {
            btnDeleteAlL.setVisibility(View.VISIBLE);
            tvCacCausai.setText("Các câu sai");
           cauSaiAdapter = new CauSaiAdapter(this,R.layout.item_lvcausai,model.get_cauHoiSai());
           lvCauSai.setAdapter(cauSaiAdapter);
            //Toast.makeText(this, ""+model.get_cauHoiSai(), Toast.LENGTH_SHORT).show();

        }
        btnDeleteAlL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(xemcausai.this);
                dialog.setTitle("Thông báo");
                dialog.setMessage("Xóa tất cả ?");
                dialog.setIcon(R.drawable.img);
                dialog.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        model.delete_all();
                        cauSaiAdapter = new CauSaiAdapter(xemcausai.this,R.layout.item_lvcausai,model.get_cauHoiSai());
                        lvCauSai.setAdapter(cauSaiAdapter);
                        tvCacCausai.setText("Chưa có câu sai nào !");
                        btnDeleteAlL.setVisibility(View.GONE);
                        Toast.makeText(xemcausai.this, "Xóa thành công!", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();

            }
        });
        lvCauSai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(xemcausai.this,item_xemcausai.class);
                intent.putExtra("poss",i);
                startActivityForResult(intent, 123);
            }
        });

        lvCauSai.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder dialog1 = new AlertDialog.Builder(xemcausai.this);
                dialog1.setTitle("Thông báo");
                dialog1.setMessage("Xóa câu hỏi này ?");
                dialog1.setIcon(R.drawable.img);
                dialog1.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int a) {

                        CauHoi cauHoi = model.get_cauHoiSai().get(i);
                        model.delete_item(cauHoi.getMaCauHoi());
                        cauSaiAdapter = new CauSaiAdapter(xemcausai.this,R.layout.item_lvcausai,model.get_cauHoiSai());
                        //cauSaiAdapter.notifyDataSetChanged();
                        lvCauSai.setAdapter(cauSaiAdapter);
                        if(model.TongCauSai() == 0){
                            tvCacCausai.setText("Chưa có câu sai nào !");
                            btnDeleteAlL.setVisibility(View.GONE);
                        }

                    }
                });
                dialog1.show();

                return true;

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 123 & resultCode == 11){
            cauSaiAdapter = new CauSaiAdapter(this,R.layout.item_lvcausai,model.get_cauHoiSai());
            lvCauSai.setAdapter(cauSaiAdapter);
            if(model.TongCauSai() == 0){
                tvCacCausai.setText("Chưa có câu sai nào !");
                btnDeleteAlL.setVisibility(View.GONE);
            }
        }
    }

    private void anhxa() {
        tvCacCausai = findViewById(R.id.tvCacCauSai);
        lvCauSai = findViewById(R.id.lvCauSai);
        btnDeleteAlL = findViewById(R.id.btnDeleteAll);
    }
}
