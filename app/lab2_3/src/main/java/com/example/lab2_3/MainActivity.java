package com.example.lab2_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

import android.widget.ScrollView;
import com.example.lab2_3.controllers.MainActivityController;


public class MainActivity extends AppCompatActivity{
    MyObserver myObserver;
    Button firstFragment, secondFragment;
    private MainActivityController controller;
    EditText txtDate, txtTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final androidx.fragment.app.Fragment second = new SecondFragment();
        ScrollView scrollView = new ScrollView(this);
        controller = new MainActivityController(this);
        setContentView(R.layout.activity_main);
        Button search = (Button) findViewById(R.id.search_button);
        Button add = (Button) findViewById(R.id.add_button);

        search.setOnClickListener((view)->{
            controller.searchClick(view);
        });
        add.setOnClickListener((view)->{
            controller.addClick(view);
        });

        ListView list = (ListView) findViewById(R.id.train_list);
        list.setAdapter(controller.getAdapter());

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                controller.onItemClicked(i);
            }
        });
        findViewById(R.id.btn_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment  = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "DIALOG_TIME");

                //newFragment.show(getChildFragmentManager(), DIALOG_TIME);
            }
        });
        findViewById(R.id.btn_time).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment newFragment  = new SecondFragment();
                newFragment.show(getSupportFragmentManager(), "DIALOG_TIME");
                //txtTime.setText(newFragment.onSet());
            }
        });
    }

}