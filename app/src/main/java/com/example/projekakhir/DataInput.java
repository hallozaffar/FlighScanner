package com.example.projekakhir;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class DataInput implements Parcelable {

    private String Name;
    private String Date;
    private String Cabin;
    private String Price;
    private String From;
    private String To;

    protected DataInput(Parcel in) {
        Name = in.readString();
        Date = in.readString();
        Cabin = in.readString();
        Price = in.readString();
        From = in.readString();
        To = in.readString();
    }

    public DataInput() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Date);
        dest.writeString(Cabin);
        dest.writeString(Price);
        dest.writeString(From);
        dest.writeString(To);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DataInput> CREATOR = new Creator<DataInput>() {
        @Override
        public DataInput createFromParcel(Parcel in) {
            return new DataInput(in);
        }

        @Override
        public DataInput[] newArray(int size) {
            return new DataInput[size];
        }
    };

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCabin() {
        return Cabin;
    }

    public void setCabin(String cabin) {
        Cabin = cabin;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }
}



