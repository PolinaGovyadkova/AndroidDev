package com.example.lab2_3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class SecondFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

        private EditText edit;
public SecondFragment() {
        // Required empty public constructor
        }

@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
// Use the current time as the default values for the picker

final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
        DateFormat.is24HourFormat(getActivity()));
        }

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        MyObserver myObserver;
        myObserver = new MyObserver();
        getLifecycle().addObserver(myObserver);

        return inflater.inflate(R.layout.fragment, container, false);
        }

public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        edit = (EditText)getActivity().findViewById(R.id.in_time);
        edit.setText(hourOfDay + ":" + minute);
}
}
