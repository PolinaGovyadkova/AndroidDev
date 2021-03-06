package com.example.lab2_3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import com.example.lab2_3.controllers.SearchController;

public class SearchActivity extends AppCompatActivity {
    private SearchController controller;
    MyObserver myObserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        controller = new SearchController(this);
        findViewById(R.id.author_switch)
                .setOnClickListener((view -> controller.toggleAuthorSwitch()));
        findViewById(R.id.publisher_switch)
                .setOnClickListener((view -> controller.togglePublisherSwitch()));
        findViewById(R.id.year_switch)
                .setOnClickListener((view -> controller.toggleYearsSwitch()));

        ((AppCompatSpinner) findViewById(R.id.author_spinner))
                .setAdapter(controller.getRooms());
        ((AppCompatSpinner) findViewById(R.id.publisher_spinner))
                .setAdapter(controller.getSquares());
        ((AppCompatSpinner) findViewById(R.id.years_spinner))
                .setAdapter(controller.getFloors());
        ((AppCompatSpinner) findViewById(R.id.years_spinner1))
                .setAdapter(controller.getFloors());

        findViewById(R.id.search_button).setOnClickListener(view->controller.searchClick());

        ((ListView)findViewById(R.id.search_result)).setAdapter(controller.getHouses());
        ((ListView)findViewById(R.id.search_result)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                controller.onItemClicked(i);
            }
        });


        myObserver = new MyObserver();
        getLifecycle().addObserver(myObserver);
    }
}