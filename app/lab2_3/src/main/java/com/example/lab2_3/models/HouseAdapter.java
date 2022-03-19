package com.example.lab2_3.models;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lab2_3.R;

import java.util.List;

public class HouseAdapter extends ArrayAdapter<House> {
    private List<House> books;
    private int layout;
    private LayoutInflater inflater;

    public HouseAdapter(@NonNull Context context, int resource, @NonNull List<House> objects) {
        super(context, resource, objects);
        books = objects;
        layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @SuppressLint("DefaultLocale")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            @SuppressLint("ViewHolder") View view = inflater.inflate(this.layout, parent, false);

            TextView nameView = (TextView) view.findViewById(R.id.item_title);
            TextView capitalView = (TextView) view.findViewById(R.id.item_description);

            House state = books.get(position);

            nameView.setText(String.format("%s", state.getNumber()));
            capitalView.setText(String.format("%s; %s ", state.getStreet(),
                    state.getType()));

            return view;
        }
    }
