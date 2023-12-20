package com.example.progettodatabinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class User extends BaseObservable {

    private String firstName;
    private String lastName;

    private String contatore;

    public User(String firstName, String lastName, String contatore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contatore = contatore;
    }

    @Bindable
    public String getFirstName(){return firstName;}
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    @Bindable
    public String getLastName(){ return lastName;}
    public void setLastName(String lastName){
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public String getContatore(){return contatore;}
    public void setContatore(String contatore) {
        this.contatore = contatore;
        notifyPropertyChanged(BR.contatore);
    }

}
