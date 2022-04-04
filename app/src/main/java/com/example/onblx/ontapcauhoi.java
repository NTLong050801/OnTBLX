package com.example.onblx;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ontapcauhoi extends AppCompatActivity {
    ListView listCauhoi;
    ArrayList<GroupCauHoi> cauHoiArrayList;
    GrCauHoiAdapter grCauHoiAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ontapcauhoi);
        Anhxa();
        grCauHoiAdapter = new GrCauHoiAdapter(this,R.layout.itemcauhoi,cauHoiArrayList);
        listCauhoi.setAdapter(grCauHoiAdapter);
    }

    private void Anhxa() {
        listCauhoi = (ListView) findViewById(R.id.lvCauHoi);
        cauHoiArrayList = new ArrayList<>();
        cauHoiArrayList.add(new GroupCauHoi("Toàn bộ câu hỏi trong đề thi","Toàn bộ 25 câu hỏi","25","0"));
        cauHoiArrayList.add(new GroupCauHoi("Toàn bộ câu hỏi lý thuyết","Toàn bộ 15 câu lý thuyết","15","0"));
        cauHoiArrayList.add(new GroupCauHoi("Toàn bộ câu hỏi biển báo","Toàn bộ 5 câu hỏi biển báo","5","0"));
        cauHoiArrayList.add(new GroupCauHoi("Toàn bộ câu hỏi sa hình","Toàn bộ 5 câu hỏi sa hình","5","0"));

    }
}
