package com.example.exam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Favor extends AppCompatActivity {
    EditText name_input,recipe_input,calories_input,suggest_input;
    Button btn_add,btn_favorBack;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favor);

        name_input = findViewById(R.id.name_input2);
        recipe_input = findViewById(R.id.recipe_input2);
        calories_input = findViewById(R.id.calories_input2);
        suggest_input = findViewById(R.id.suggest_input2);
        btn_add = findViewById(R.id.btn_set);
        btn_favorBack = findViewById(R.id.btn_favorBack);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(Favor.this);
                myDB.addFood(name_input.getText().toString().trim(),
                        recipe_input.getText().toString().trim(),
                        Float.valueOf(calories_input.getText().toString().trim()),
                        suggest_input.getText().toString().trim());
            }
        });
        btn_favorBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Favor.this, ListFavor.class);
                startActivity(intent);
            }
        });
    }
}
