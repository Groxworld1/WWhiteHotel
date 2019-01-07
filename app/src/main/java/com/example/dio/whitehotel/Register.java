package com.example.dio.whitehotel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class Register extends AppCompatActivity {

    Button loginButton, registerButton;
    EditText userText, passText;

    DatabaseReference userRef;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userText = (EditText) findViewById(R.id.userText);
        passText = (EditText) findViewById(R.id.passText);
        registerButton = (Button) findViewById(R.id.registerButton);

        userRef = FirebaseDatabase.getInstance().getReference("users");

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerAccount();
            }
        });
    }

    public void returnLogin(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /*
    private void keygen(){
        String userID = userRef.push().getKey();
        return userID;
    }
    */


    private void registerAccount(){
        String uname = userText.getText().toString();
        String pword = passText.getText().toString();

        if(!uname.isEmpty() && !pword.isEmpty()){

            String uID = userRef.push().getKey();

            User user = new User(uname, pword, uID);

            userRef.child(uID).setValue(user);

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

            Toast.makeText(this, "Register success!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Please fill the form", Toast.LENGTH_SHORT).show();
        }

    }
}
