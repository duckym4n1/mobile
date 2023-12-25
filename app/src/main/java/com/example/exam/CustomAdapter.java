package com.example.exam;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private Context context;
    Activity activity;
    ArrayList id,name,recipe,calories,suggest;
    public CustomAdapter(Activity activity,Context context, ArrayList id, ArrayList name, ArrayList recipe, ArrayList calories, ArrayList suggest) {
        this.activity= activity;
        this.context = context;
        this.id = id;
        this.name = name;
        this.recipe = recipe;
        this.calories = calories;
        this.suggest = suggest;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.food_id_txt.setText(String.valueOf(id.get(position)));
        holder.food_name_txt.setText(String.valueOf(name.get(position)));
        holder.food_recipe_txt.setText(String.valueOf(recipe.get(position)));
        holder.food_calories_txt.setText(String.valueOf(calories.get(position)));
        holder.food_suggest_txt.setText(String.valueOf(suggest.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Update.class);
                intent.putExtra("id",String.valueOf(id.get(position)));
                intent.putExtra("name",String.valueOf(name.get(position)));
                intent.putExtra("recipe",String.valueOf(recipe.get(position)));
                intent.putExtra("calories",String.valueOf(calories.get(position)));
                intent.putExtra("suggest",String.valueOf(suggest.get(position)));
                activity.startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView food_id_txt, food_name_txt, food_recipe_txt, food_calories_txt, food_suggest_txt;
        LinearLayout mainLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            food_id_txt = itemView.findViewById(R.id.food_id_txt);
            food_name_txt = itemView.findViewById(R.id.food_name_txt);
            food_recipe_txt = itemView.findViewById(R.id.food_recipe_txt);
            food_calories_txt = itemView.findViewById(R.id.food_calories_txt);
            food_suggest_txt = itemView.findViewById(R.id.food_suggest_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
