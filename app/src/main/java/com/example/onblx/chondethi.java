package com.example.onblx;

import static com.example.onblx.R.drawable.dethidung_custom;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class chondethi extends AppCompatActivity {
    public static final int code1 = 1,code2=2,code3=3,code4=4;
    LinearLayout de1,de2,de3;
    TextView caudungde1,caudungde2,caudungde3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chondethi);
        anhxa();
        de1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chondethi.this,lamdethi.class);
                intent.putExtra("sode",1);
                startActivityForResult(intent, code1);
            }
        });

        de2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chondethi.this,lamdethi.class);
                intent.putExtra("sode",2);
                startActivityForResult(intent, code2);
            }
        });
        de3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chondethi.this,lamdethi.class);
                intent.putExtra("sode",3);
                startActivityForResult(intent, code3);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //requestCode mã gửi đi
        //resultCode mã gửi về
        //Intent data  thông qua đó để trả kết quả về
        if(requestCode == code1 & resultCode == 11){
            int kq = data.getIntExtra("socaudung",0);
            caudungde1.setVisibility(View.VISIBLE);
            caudungde1.setText(kq+"/10");
            if(kq >= 8){
                caudungde1.setTextColor(Color.GREEN);
            }else {
                caudungde1.setTextColor(Color.RED);
            }
        }
        if(requestCode == code2 & resultCode == 11){
            int kq = data.getIntExtra("socaudung",0);
            caudungde2.setVisibility(View.VISIBLE);
            caudungde2.setText(kq+"/10");
        }
        if(requestCode == code3 & resultCode == 11){
            int kq = data.getIntExtra("socaudung",0);
            caudungde3.setVisibility(View.VISIBLE);
            caudungde3.setText(kq+"/10");
        }
//        if(resultCode == 111){
//            int kq = data.getIntExtra("xemcausai",0);
//            Intent viewCauSai = new Intent(this,xemcausai.class);
//            startActivity(viewCauSai);
//        }

    }

    private void anhxa() {
        de1 = findViewById(R.id.de1);
        de2 = findViewById(R.id.de2);
        de3 = findViewById(R.id.de3);
        caudungde1 = findViewById(R.id.caudungde1);
        caudungde2 = findViewById(R.id.caudungde2);
        caudungde3 = findViewById(R.id.caudungde3);
    }
}