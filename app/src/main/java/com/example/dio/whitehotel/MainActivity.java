package com.example.dio.whitehotel;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText usernameText, passwordText;
    Button loginButton, registerButton;

    private DatabaseReference postRef;

    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("message");

    private void collectID(Map<String, Object> users){
        ArrayList<String> accounts = new ArrayList<>();

        for (Map.Entry<String, Object> entry : users.entrySet()){
            Map singleUser = (Map) entry.getValue();
            accounts.add((String) singleUser.get("user accounts"));
        }

        Toast.makeText(this, accounts.toString(), Toast.LENGTH_SHORT).show();
    }

    public void validator(){
        usernameText = (EditText) findViewById(R.id.usernameText);
        final String username = usernameText.getText().toString();

        passwordText = (EditText) findViewById(R.id.passwordText);
        final String password = passwordText.getText().toString();

        postRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //Toast.makeText(MainActivity.this, "Count " + dataSnapshot.getChildrenCount(), Toast.LENGTH_LONG).show();

                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()){
                    User user = childDataSnapshot.getValue(User.class);
                    //Toast.makeText(MainActivity.this, "Key: " + childDataSnapshot.getKey() +"\nUser: " + childDataSnapshot.getValue(), Toast.LENGTH_SHORT).show();
                    if(username.equals(user.username) && password.equals(user.password)){
                        Intent intent = new Intent(MainActivity.this, Homepage.class);
                        startActivity(intent);
                        break;
                    }

                    else {
                        Toast.makeText(MainActivity.this, "Your username or password is wrong", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void launchLogin (View view){
        validator();
    }

    public void launchRegister (View view){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        postRef = FirebaseDatabase.getInstance().getReference().child("users");
    }
}
