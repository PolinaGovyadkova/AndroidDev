package com.example.lab2_3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2_3.controllers.EditController;

import java.util.ArrayList;
import java.util.Arrays;

public class EditActivity extends AppCompatActivity {
    private EditController controller;
    MyObserver myObserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_train);
        boolean isEditMode = getIntent().getBooleanExtra("isEditingMode", false);
        controller = new EditController(this, isEditMode);
        findViewById(R.id.save_button).setFocusable(true);
        Button btn = findViewById(R.id.save_button);

        getLifecycle().addObserver(new MyObserver());
        btn.setOnClickListener((view -> {

            controller.onSubmit();
        }));

        btn = findViewById(R.id.cancel_button);
        btn.setOnClickListener((view) -> {
            controller.onCancel();
        });

        ArrayList<EditText> texts = new ArrayList<>(Arrays.asList(new EditText[]{
                findViewById(R.id.id_edit),
                findViewById(R.id.number_edit),
                findViewById(R.id.square_edit),
                findViewById(R.id.floor_edit),
                findViewById(R.id.floorCount_edit),
                findViewById(R.id.street_edit),
                findViewById(R.id.type_edit),
                findViewById(R.id.time_edit_)
        }));
        for (EditText text : texts) {
            text.setOnFocusChangeListener(((view, setFocus) ->
            {
                if(!setFocus)
                    controller.onEditLostFocus((EditText) view);
            }));
        }
        myObserver = new MyObserver();
        getLifecycle().addObserver(myObserver);
    }
}