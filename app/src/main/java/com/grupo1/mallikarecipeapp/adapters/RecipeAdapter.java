package com.grupo1.mallikarecipeapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.grupo1.mallikarecipeapp.R;
import com.grupo1.mallikarecipeapp.utils.Total;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class RecipeAdapter extends RecyclerView.Adapter <RecipeAdapter.ViewHolder> {

    ArrayList<HashMap<String,String>> arrayList;
    public RecipeAdapter(ArrayList<HashMap<String,String>> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recipes, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.ViewHolder holder, int position) {
        HashMap<String,String> map = arrayList.get(position);
        holder.tv_name.setText(map.get("name"));
        int time = Integer.parseInt(map.get("time"));
        holder.tv_time.setText(map.get(time + " min"));
        holder.tv_difficulty.setText(map.get("difficulty"));
        String root = Total.rootService + "images/" + map.get("picture");
        Picasso.get().load(root).into(holder.iv_picture);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_time, tv_difficulty;
        ImageView iv_picture;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_difficulty = itemView.findViewById(R.id.tv_difficulty);
            iv_picture = itemView.findViewById(R.id.iv_picture);
        }
    }
}
