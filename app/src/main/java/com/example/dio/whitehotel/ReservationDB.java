package com.example.dio.whitehotel;

public class ReservationDB {

    public String date, host, quantity;

    public ReservationDB(){

    }

    public ReservationDB(String host, String date, String quantity){
        this.host = host;
        this.date = date;
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
