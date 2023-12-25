package com.example.exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {
    Button btn_nutri,btn_favor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btn_nutri = findViewById(R.id.btn_nutri);
        btn_favor = findViewById(R.id.btn_favor);
        btn_nutri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, ListFavor.class);
                startActivity(intent);
            }
        });
        btn_favor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this,ListFavor.class);
                startActivity(intent);
            }
        });
    }
}
