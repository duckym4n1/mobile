package com.example.exam;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ListFavor extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton baseline_add;
    MyDatabaseHelper myDb;
    ArrayList<String> id,name,recipe,calories,suggest;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listfavor);
        recyclerView = findViewById(R.id.recyclerView);
        baseline_add = findViewById(R.id.baseline_add);
        baseline_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListFavor.this, Favor.class);
                startActivity(intent);
            }
        });
        myDb = new MyDatabaseHelper(ListFavor.this);
        id = new ArrayList<>();
        name = new ArrayList<>();
        recipe  = new ArrayList<>();
        calories = new ArrayList<>();
        suggest = new ArrayList<>();

        storeDataInArrays();
        customAdapter = new CustomAdapter(ListFavor.this,this,id,name,recipe,calories,suggest);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListFavor.this));
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 1)
        {
            recreate();
        }
    }
    void storeDataInArrays()
    {
        Cursor cursor = myDb.readAllData();
        if(cursor.getCount()==0)
        {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext())
            {
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                recipe.add(cursor.getString(2));
                calories.add(cursor.getString(3));
                suggest.add(cursor.getString(4));
            }
        }
    }
}
