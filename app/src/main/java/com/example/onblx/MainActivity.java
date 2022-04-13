package com.example.onblx;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import database.DataBase;

public class MainActivity extends AppCompatActivity {
    ListView lvCauhoi;
    ViewFlipper viewFlipper;
    LinearLayout OntapCauhoi,Dengaunhien,Thitheobode,bienBaoGiaoThong,CacCauSai,CauDiemLiet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBase db = new DataBase(this);

        db.QueryData("Create table if not exists LoaiCauHoi(IDLoaiCauHoi Integer primary key autoincrement,TenLoaiCauHoi varchar)");

        //thêm dữ liệu
       // db.QueryData("INSERT INTO LoaiCauHoi Values(null,'Lý thuyết')");
        //lấy dữ liệu
        Anhxa();
        ActionViewFlipper();
        OntapCauhoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(MainActivity.this, ontapcauhoi.class);
                startActivity(x);
            }
        });
        Dengaunhien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(MainActivity.this, dengaunhien.class);
                startActivity(x);
            }
        });
        Thitheobode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent x = new Intent(MainActivity.this, chondethi.class);
                startActivity(x);
            }
        });
        bienBaoGiaoThong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, bienBao.class);
                startActivity(intent);
                //Toast.makeText(MainActivity.this, "ok1321", Toast.LENGTH_SHORT).show();
            }
        });
        CacCauSai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, xemcausai.class);
                startActivity(intent);            }
        });

        CauDiemLiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, caudiemliet.class);
                startActivity(intent);
            }
        });

    }
    //Tạo Flipper quảng cáo
    private void ActionViewFlipper() {
        //Mảng chứa các tấm hình
        ArrayList<String> mangquangcao = new ArrayList<>();
        //Thêm hình

        mangquangcao.add("https://trungtamthanhdat.vn/wp-content/uploads/2021/02/de-thi-thu-lai-xe-hang-a.jpg");
        mangquangcao.add("https://hoclaixeoto.vn/image/sach-200-cau-hoi-thi-bang-lai-xe-may-a1.jpg");
        mangquangcao.add("https://cdn-ckjik.nitrocdn.com/VxWxsWJBaGjnitzpSNiGhGcwITZdouXI/assets/static/optimized/wp-content/uploads/2021/05/c377ed4bac81b21502102074a53e8418.thi-bang-lai-xe-b2-online-300x150.png");

        //Gán link ảnh vào imageView, rồi gán gán image ra app
        for(int i =0; i <mangquangcao.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            //Hàm thư viện của picasso. lấy ảnh từ internet về cho vào imageview
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
            //phương thức căn chỉnh tấm hình vừa với khung quảng cáo
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            //Thêm ảnh từ imageview vào ViewFlipper
            viewFlipper.addView(imageView);

        }

        //Thiết lập tự chạy cho viewFlipper chạy trong 5 giây
        viewFlipper.setFlipInterval(5000);
        //viewFlipper run
        viewFlipper.setAutoStart(true);
        //Gọi animation cho in và out . Animation giúp cho nó biến dổi giữa các giao diện hình ảnh
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        //Gọi animation vào ViewFlippẻ
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }

    private void Anhxa() {
        OntapCauhoi = (LinearLayout) findViewById(R.id.layout4);
        Dengaunhien = (LinearLayout) findViewById(R.id.layout11);
        Thitheobode = (LinearLayout) findViewById(R.id.layout2);
        bienBaoGiaoThong = (LinearLayout) findViewById(R.id.layout5);
        CacCauSai = findViewById(R.id.layout3);
        CauDiemLiet = findViewById(R.id.layout6);
        viewFlipper = findViewById(R.id.viewflipper);


    }
}