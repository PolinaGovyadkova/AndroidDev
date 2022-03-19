package com.example.lab2_3.controllers;

import android.content.Context;
import android.content.Intent;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import com.example.lab2_3.HouseActicity;
import com.example.lab2_3.R;
import com.example.lab2_3.models.House;
import com.example.lab2_3.models.HouseAdapter;
import com.example.lab2_3.models.HouseStore;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SearchController {
    private final HouseStore store;
    private final Context context;
    private boolean authorSwitch = false;
    private boolean publisherSwitch = false;
    private boolean yearsSwitch = false;
    AppCompatSpinner authorSpinner;
    AppCompatSpinner publisherSpinner;
    AppCompatSpinner yearSpinner;
    AppCompatSpinner yearSpinner1;




    private ArrayAdapter<Integer> rooms;
    private ArrayAdapter<Integer> floors;
    private ArrayAdapter<Integer> square;
    private HouseAdapter books;

    public SearchController(AppCompatActivity activity){
        this.context = (Context) activity;

        store = new HouseStore();
        rooms = new ArrayAdapter<Integer>(activity, R.layout.support_simple_spinner_dropdown_item, store
                .getHouse()
                .stream()
                .map(House::getFloorCount)
                .distinct()
                .collect(Collectors.toList()));
        floors = new ArrayAdapter<Integer>(activity, R.layout.support_simple_spinner_dropdown_item, store
                .getHouse()
                .stream()
                .map(House::getFloor)
                .distinct()
                .collect(Collectors.toList()));
        square = new ArrayAdapter<Integer>(activity, R.layout.support_simple_spinner_dropdown_item, store
                .getHouse()
                .stream()
                .map(House::getSquare)
                .distinct()
                .collect(Collectors.toList()));
        books = new HouseAdapter(activity, R.layout.main_list_item, new ArrayList<House>());
        authorSpinner = activity.findViewById(R.id.author_spinner);
        publisherSpinner = activity.findViewById(R.id.publisher_spinner);
        yearSpinner = activity.findViewById(R.id.years_spinner);
        yearSpinner1 = activity.findViewById(R.id.years_spinner1);

    }

    public void searchClick(){
        int selectedAuthor = Integer.parseInt(authorSpinner.getSelectedItem().toString());
        int selectedPublisher = Integer.parseInt(publisherSpinner.getSelectedItem().toString());
        int selectedYear = Integer.parseInt(yearSpinner.getSelectedItem().toString());
        int selectedYear1 = Integer.parseInt(yearSpinner1.getSelectedItem().toString());
        ArrayList<House> searchResult = (ArrayList<House>) store.getHouse().stream().filter(e -> {
            boolean result = (!authorSwitch || e.getFloorCount() >= selectedAuthor);
            result &= (!publisherSwitch || e.getSquare() >= selectedPublisher);
            result &= (!yearsSwitch || e.getFloor() >= selectedYear && e.getFloor() <= selectedYear1);
            return result;
        }).collect(Collectors.toList());
        books.clear();
        books.addAll(searchResult);
        books.notifyDataSetChanged();
//        books.notifyAll();

    }

    public void onItemClicked(int position){
        Intent intent = new Intent(context, HouseActicity.class);
        intent.putExtra("ItemValuePosition", position);
        intent.putExtra("ItemValue", books.getItem(position));
        context.startActivity(intent);

    }

    public void toggleAuthorSwitch() {
         authorSwitch = !authorSwitch;
    }

    public void togglePublisherSwitch() {
        publisherSwitch = !publisherSwitch;
    }

    public void toggleYearsSwitch() {
        yearsSwitch = !yearsSwitch;
    }

    public ArrayAdapter<Integer> getRooms() {
        return rooms;
    }

    public ArrayAdapter<Integer> getFloors() {
        return floors;
    }

    public ArrayAdapter<Integer> getSquares() {
        return square;
    }

    public HouseAdapter getHouses() {
        return books;
    }
}
