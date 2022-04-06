package com.example.onblx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class chondethi extends AppCompatActivity {
    LinearLayout de1,de2,de3;
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
                startActivity(intent);
            }
        });
        de2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chondethi.this,lamdethi.class);
                intent.putExtra("sode",2);
                startActivity(intent);
            }
        });
        de3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chondethi.this,lamdethi.class);
                intent.putExtra("sode",3);
                startActivity(intent);
            }
        });
    }

    private void anhxa() {
        de1 = findViewById(R.id.de1);
        de2 = findViewById(R.id.de2);
        de3 = findViewById(R.id.de3);
    }
}