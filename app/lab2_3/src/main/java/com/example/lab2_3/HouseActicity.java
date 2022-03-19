package com.example.lab2_3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2_3.controllers.HouseController;
import com.example.lab2_3.models.House;
import com.example.lab2_3.models.HouseStore;

public class HouseActicity extends AppCompatActivity {
    private HouseController controller;
    MyObserver myObserver;
    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_acticity);
        Intent intent = getIntent();
        int pos = intent.getIntExtra("ItemValuePosition", 0);
        HouseStore store = new HouseStore();
        //Book book = store.get(pos);
        House book = intent.getParcelableExtra("ItemValue");
        TextView line = findViewById(R.id.id);
        line.setText(book.getId());
        line = findViewById(R.id.number);
        line.setText(book.getNumber());
        line = findViewById(R.id.square);
        line.setText(String.format("%d", book.getSquare()));
        line = findViewById(R.id.floor);
        line.setText(String.format("%d", book.getFloor()));
        line = findViewById(R.id.floorCount);
        line.setText(String.format("%d", book.getFloorCount()));
        line = findViewById(R.id.street);
        line.setText(book.getStreet());
        line = findViewById(R.id.type);
        line.setText( book.getType());
        line = findViewById(R.id.time);
        line.setText(String.format("%d", book.getTime()));


        controller = new HouseController(this, pos);
        Button btn = findViewById(R.id.delete_button);
        btn.setOnClickListener((view -> {
            controller.onDeleteClick();
        }));
        btn = findViewById(R.id.edit_button);
        btn.setOnClickListener((view)->controller.onEditClick());


        myObserver = new MyObserver();
        getLifecycle().addObserver(myObserver);
    }
}