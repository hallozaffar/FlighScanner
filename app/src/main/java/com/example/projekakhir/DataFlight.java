package com.example.projekakhir;

import android.os.Parcel;
import android.os.Parcelable;

public class DataFlight implements Parcelable {
    private String Country;
    private String Type;
    private int FlImg;
    private String FlName;
    private  String FlPrc;
    private int Price;
    private  int DetailImg;
    private String FlDescription;
    private int harga;

    public DataFlight() {

    }

    protected DataFlight(Parcel in) {
        Country = in.readString();
        Type = in.readString();
        FlImg = in.readInt();
        FlName = in.readString();
        FlPrc = in.readString();
        Price = in.readInt();
        DetailImg = in.readInt();
        FlDescription = in.readString();
        harga = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Country);
        dest.writeString(Type);
        dest.writeInt(FlImg);
        dest.writeString(FlName);
        dest.writeString(FlPrc);
        dest.writeInt(Price);
        dest.writeInt(DetailImg);
        dest.writeString(FlDescription);
        dest.writeInt(harga);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DataFlight> CREATOR = new Creator<DataFlight>() {
        @Override
        public DataFlight createFromParcel(Parcel in) {
            return new DataFlight(in);
        }

        @Override
        public DataFlight[] newArray(int size) {
            return new DataFlight[size];
        }
    };

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getFlImg() {
        return FlImg;
    }

    public void setFlImg(int flImg) {
        FlImg = flImg;
    }

    public String getFlName() {
        return FlName;
    }

    public void setFlName(String flName) {
        FlName = flName;
    }

    public String getFlPrc() {
        return FlPrc;
    }

    public void setFlPrc(String flPrc) {
        FlPrc = flPrc;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getFlDescription() {
        return FlDescription;
    }

    public void setFlDescription(String flDescription) {
        FlDescription = flDescription;
    }

    public int getDetailImg() {
        return DetailImg;
    }

    public void setDetailImg(int detailImg) {
        DetailImg = detailImg;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
