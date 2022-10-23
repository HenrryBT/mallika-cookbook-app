package com.grupo1.mallikarecipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.grupo1.mallikarecipeapp.adapters.RecipeAdapter;
import com.grupo1.mallikarecipeapp.databinding.ActivityRecycleViewBinding;
import com.grupo1.mallikarecipeapp.utils.Total;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

public class RecycleViewActivity extends AppCompatActivity {
    private ActivityRecycleViewBinding binding;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecycleViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        readData();
    }

    private void readData() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = Total.rootService + "search.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("DATA",response);
                        writeList(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("DATAERROR", error.getMessage());
            }
        });
        queue.add(stringRequest);
    }

    private void writeList(String response) {
        ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(response);
            for( int i = 0; i< jsonArray.length(); i++){
                String name = jsonArray.getJSONObject(i).getString("name");
                String time = jsonArray.getJSONObject(i).getString("time");
                String difficulty = jsonArray.getJSONObject(i).getString("difficulty");
                String picture = jsonArray.getJSONObject(i).getString("picture");
                HashMap<String,String> map = new HashMap<>();
                map.put("name",name);
                map.put("time",time);
                map.put("difficulty",difficulty);
                map.put("picture",picture);
                arrayList.add(map);
            }

            RecipeAdapter recipeAdapter = new RecipeAdapter(arrayList);
            binding.rvRecipe.setAdapter(recipeAdapter);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                    this, LinearLayoutManager.VERTICAL, false);
            binding.rvRecipe.setLayoutManager(linearLayoutManager);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}