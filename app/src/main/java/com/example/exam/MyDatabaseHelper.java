package com.example.exam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

 class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Foodfavor.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE = "my_list";
    private static final String COLUMN_ID= "_id";
    private static final String COLUMN_FOODNAME="food_name";
    private static final String COLUMN_RECIPE="food_recipe";
    private static final String COLUMN_CALORIES="food_calories";
    private static final String COLUMN_SUGGESTION="food_suggest";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="CREATE TABLE "+ TABLE +"("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ COLUMN_FOODNAME+" TEXT," +
                ""+COLUMN_RECIPE +" TEXT," + COLUMN_CALORIES +" FLOAT,"+ COLUMN_SUGGESTION +" TEXT);";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    void addFood(String foodName, String recipe, Float calories, String suggest){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_FOODNAME, foodName);
        cv.put(COLUMN_RECIPE, recipe);
        cv.put(COLUMN_CALORIES,calories);
        cv.put(COLUMN_SUGGESTION,suggest);
        long result = db.insert(TABLE,null,cv);
        if(result==-1)
        {
            Toast.makeText(context, "Failed ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }
    Cursor readAllData()
    {
        String query = "SELECT * FROM " + TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db!=null)
        {
            db.rawQuery(query, null);
        }
        return  cursor;
    }

    void updateData(String row_id,String name, String recipe, String calories, String suggest)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_FOODNAME, name);
        cv.put(COLUMN_RECIPE, recipe);
        cv.put(COLUMN_CALORIES, calories);
        cv.put(COLUMN_SUGGESTION, suggest);

        long result = db.update(TABLE, cv,"_id = ?", new String[] {row_id});
        if (result == -1)
        {
            Toast.makeText(context, "Failed to update", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }
    void deleteOneRow(String row_id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE,"_id=?", new String[]{row_id});
        if (result == -1)
        {
            Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }
}
