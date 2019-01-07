package com.example.dio.whitehotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }

    public void reservation(View v){
        Intent intent = new Intent(this, reservation.class);
        startActivity(intent);
    }

    public void facilities(View v){
        Intent intent = new Intent(this, facilities.class);
        startActivity(intent);
    }

    public void logout(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
