package com.example.lab2_3.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.time.OffsetTime;
import java.util.ArrayList;

public class House implements Parcelable {
    private String id;
    private String number;
    private int square;
    private int floor;
    private int floorCount;
    private String street;
    private String type;
    private int time;

    protected House(Parcel in) {
        id = in.readString();
        number = in.readString();
        square = in.readInt();
        floor = in.readInt();
        floorCount = in.readInt();
        street = in.readString();
        type = in.readString();
        time = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(number);
        dest.writeInt(square);
        dest.writeInt(floor);
        dest.writeInt(floorCount);
        dest.writeString(street);
        dest.writeString(type);
        dest.writeInt(time);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<House> CREATOR = new Creator<House>() {
        @Override
        public House createFromParcel(Parcel in) {
            return new House(in);
        }

        @Override
        public House[] newArray(int size) {
            return new House[size];
        }
    };

    @NonNull
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id='").append(id).append('\'');
        sb.append(", number='").append(number).append('\'');
        sb.append(", square='").append(square).append('\'');
        sb.append(", floor='").append(floor).append('\'');
        sb.append(", floorCount='").append(floorCount).append('\'');
        sb.append(", street=").append(street).append('\'');
        sb.append(", type=").append(type).append('\'');
        sb.append(", time='").append(time).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int pages) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String price) {
        this.type = type;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public House(String id, String number, int square, int floor, int floorCount, String street, String type, int time) {
        this.id = id;
        this.number = number;
        this.square = square;
        this.floor = floor;
        this.floorCount = floorCount;
        this.street = street;
        this.type = type;
        this.time = time;
    }

}
