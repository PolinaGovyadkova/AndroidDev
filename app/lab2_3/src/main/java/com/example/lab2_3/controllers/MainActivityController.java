package com.example.lab2_3.controllers;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.lab2_3.EditActivity;
import com.example.lab2_3.R;
import com.example.lab2_3.SearchActivity;
import com.example.lab2_3.HouseActicity;
import com.example.lab2_3.models.HouseAdapter;
import com.example.lab2_3.models.HouseStore;

public class MainActivityController {
    private final HouseStore store;
    private final HouseAdapter adapter;
    private final Context context;

    public MainActivityController(Context context){
        store = new HouseStore();
        adapter = new HouseAdapter(context, R.layout.main_list_item, store.getHouse());
        this.context = context;
    }

    public void searchClick(View view){
        Intent intent = new Intent(context, SearchActivity.class);


        context.startActivity(intent);
    }

    public void addClick(View view){
        Intent intent = new Intent(context, EditActivity.class);
        intent.putExtra("isEditingMode", false);
        context.startActivity(intent);
    }

    public void onItemClicked(int position){
        Intent intent = new Intent(context, HouseActicity.class);
        intent.putExtra("ItemValuePosition", position);
        intent.putExtra("ItemValue", store.get(position));
        context.startActivity(intent);

    }


    public HouseAdapter getAdapter() {
        return adapter;
    }
}
