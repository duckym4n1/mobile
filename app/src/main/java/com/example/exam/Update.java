package com.example.exam;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Update extends AppCompatActivity {
    EditText name_input2,recipe_input2,calories_input2,suggest_input2;
    Button btn_set,btn_del;
    String id,name,recipe,calories,suggest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name_input2 = findViewById(R.id.name_input2);
        recipe_input2 = findViewById(R.id.recipe_input2);
        calories_input2 = findViewById(R.id.calories_input2);
        suggest_input2 = findViewById(R.id.suggest_input2);
        btn_set = findViewById(R.id.btn_set);
        btn_del = findViewById(R.id.btn_del);

        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();
        if(ab!=null)
        {
            ab.setTitle(name);
        }


        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDb = new MyDatabaseHelper(Update.this);
                myDb.updateData(id,name,recipe,calories,suggest);
            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });
    }

    void getAndSetIntentData()
    {
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") && getIntent().hasExtra("recipe")&&
            getIntent().hasExtra("calories")&&getIntent().hasExtra("suggest"))
        {
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            recipe = getIntent().getStringExtra("recipe");
            calories = getIntent().getStringExtra("calories");
            suggest = getIntent().getStringExtra("suggest");

            //Setting Intent Data
            name_input2.setText(name);
            recipe_input2.setText(recipe);
            calories_input2.setText(calories);
            suggest_input2.setText(suggest);
        }else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete"+ name + "?");
        builder.setMessage("Are you sure???");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MyDatabaseHelper myDb = new MyDatabaseHelper(Update.this);
                myDb.deleteOneRow(id);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
    }
}
