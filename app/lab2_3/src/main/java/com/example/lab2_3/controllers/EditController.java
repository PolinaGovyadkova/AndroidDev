package com.example.lab2_3.controllers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2_3.MainActivity;
import com.example.lab2_3.R;
import com.example.lab2_3.models.House;
import com.example.lab2_3.models.HouseStore;
import com.example.lab2_3.models.House;
import com.example.lab2_3.models.HouseStore;

public class EditController {
    private final HouseStore store;
    private final Context context;
    private final AppCompatActivity activity;
    private final House house;
    private final boolean isEditMode;
    private int position = 0;

    @SuppressLint("DefaultLocale")
    public EditController(AppCompatActivity context, boolean isEditMode) {
        this.isEditMode = isEditMode;
        this.store = new HouseStore();
        this.context = context;
        this.activity = context;
        if (isEditMode) {
            position = activity.getIntent().getIntExtra("EditPosition", 0);
            house = store.get(position);
            ((EditText) activity.findViewById(R.id.id_edit)).setText(house.getId());
            ((EditText) activity.findViewById(R.id.number_edit)).setText(house.getNumber());
            ((EditText) activity.findViewById(R.id.square_edit)).setText(String.format("%d", house.getSquare()));
            ((EditText) activity.findViewById(R.id.floor_edit)).setText(String.format("%d", house.getFloor()));
            ((EditText) activity.findViewById(R.id.floorCount_edit)).setText(String.format("%d", house.getFloorCount()));
            ((EditText) activity.findViewById(R.id.street_edit)).setText(house.getStreet());
            ((EditText) activity.findViewById(R.id.type_edit)).setText(house.getType());
            ((EditText) activity.findViewById(R.id.time_edit_)).setText(String.format("%d", house.getTime()));
        }
        else
            house = new House("","",0,0,0,"","",0);
    }

    public void onSubmit() {
        if (isEditMode){
            store.replace(position, house);
            Toast.makeText(context, "edited", Toast.LENGTH_LONG).show();
        }
        else {
            store.add(house);
            Toast.makeText(context, "added", Toast.LENGTH_LONG).show();
        }
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public void onCancel() {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }


    public void onEditLostFocus(@NonNull EditText view) {
        int id = view.getId();
        try {
            switch (id) {
                case R.id.id_edit:
                    house.setId(view.getText().toString());
                    break;
                case R.id.number_edit:
                    house.setNumber(view.getText().toString());
                    break;
                case R.id.square_edit:
                    house.setSquare(Integer.parseInt(view.getText().toString()));
                    break;
                case R.id.floor_edit:
                    house.setFloor(Integer.parseInt(view.getText().toString()));
                    break;
                case R.id.floorCount_edit:
                    house.setFloorCount(Integer.parseInt(view.getText().toString()));
                    break;
                case R.id.street_edit:
                    house.setStreet(view.getText().toString());
                    break;
                case R.id.type_edit:
                    house.setType(view.getText().toString());
                    break;
                case R.id.time_edit_:
                    house.setTime(Integer.parseInt(view.getText().toString()));
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            Toast.makeText(context, ex.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
