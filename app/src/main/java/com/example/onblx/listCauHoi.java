package com.example.onblx;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class listCauHoi extends AppCompatActivity {
    TextView tv_cauhoi;
    ImageView img_hinhAnh;
    RadioButton rb_dapAnA, rb_dapAnB, rb_dapAnC, rb_dapAnD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cau_hoi);
        AnhXa();
        Model model = new Model(this);
        CauHoi cauhois = model.getData().get(0);

    }

    private void AnhXa(){
        tv_cauhoi = findViewById(R.id.cau_hoi);
        img_hinhAnh = findViewById(R.id.hinh_anh);
        rb_dapAnA = findViewById(R.id.rbDapAnA);
        rb_dapAnB = findViewById(R.id.rbDapAnB);
        rb_dapAnC = findViewById(R.id.rbDapAnC);
        rb_dapAnD = findViewById(R.id.rbDapAnD);
    }
}