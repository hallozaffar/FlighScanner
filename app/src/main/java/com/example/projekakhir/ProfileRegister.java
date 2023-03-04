package com.example.projekakhir;

import android.os.Parcel;
import android.os.Parcelable;

public class ProfileRegister implements Parcelable {

    private String Username;
    private String Country;
    private String Addres;
    private String Email ;
    private String Password;


    public ProfileRegister() {

    }

    protected ProfileRegister(Parcel in) {
        Username = in.readString();
        Country = in.readString();
        Addres = in.readString();
        Email = in.readString();
        Password = in.readString();
    }

    public static final Creator<ProfileRegister> CREATOR = new Creator<ProfileRegister>() {
        @Override
        public ProfileRegister createFromParcel(Parcel in) {
            return new ProfileRegister(in);
        }

        @Override
        public ProfileRegister[] newArray(int size) {
            return new ProfileRegister[size];
        }
    };

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getAddres() {
        return Addres;
    }

    public void setAddres(String addres) {
        Addres = addres;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Username);
        parcel.writeString(Country);
        parcel.writeString(Addres);
        parcel.writeString(Email);
        parcel.writeString(Password);
    }
}
