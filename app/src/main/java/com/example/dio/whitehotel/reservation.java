package com.example.dio.whitehotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class reservation extends AppCompatActivity {

    EditText dateText, hostText, quantityText;
    DatabaseReference userRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        dateText = (EditText) findViewById(R.id.dateText);
        hostText = (EditText) findViewById(R.id.hostText);
        quantityText = (EditText) findViewById(R.id.quantityText);

        userRef = FirebaseDatabase.getInstance().getReference("users");
    }

    public void book(View v){
        String date = dateText.getText().toString();
        String host = hostText.getText().toString();
        String quantity = quantityText.getText().toString();

        if(date.length() == 0 || host.length() == 0 || quantity.length() == 0){
            Toast.makeText(this, "Please fill everything", Toast.LENGTH_SHORT).show();
        }

        else{
            ReservationDB res = new ReservationDB(host, date, quantity);

            String id = userRef.push().getKey();

            userRef.child(id).setValue(res);

            Toast.makeText(this, "Your request has been booked", Toast.LENGTH_SHORT).show();
        }
    }

    public void returnHome(View v){
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }
}
