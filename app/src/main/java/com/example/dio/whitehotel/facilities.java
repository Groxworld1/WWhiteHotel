package com.example.dio.whitehotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class facilities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities);
    }

    public void rent(View v){
        Toast.makeText(this, "Now you may take a bike, damages or even losses will be fined", Toast.LENGTH_SHORT).show();
    }

    public void breakfast(View v){
        Toast.makeText(this, "Breakfast will be served starting from 8 AM to 10 AM", Toast.LENGTH_SHORT).show();
    }

    public void back(View v){
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }
}
