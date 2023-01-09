package com.example.student;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    //pass data to LoginActivity, AndroidManifest --android:parentActivityName=".MainActivity"-- in the handle activity
    public static final String EXTRA_TEXT = "com.example.LoginActivity.EXTRA_TEXT";

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users").child("username");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView error_message = findViewById(R.id.errormessage);
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        Button btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = username.getText().toString();
                String pass = password.getText().toString();

                //find username
                if(username.getText().toString().trim().length() > 0){
                    myRef.child(user_name).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists()){
                                //find password
                                if(password.getText().toString().trim().length() > 0){
                                    myRef.child(user_name).child("password").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            if(dataSnapshot.exists()){
                                                String passdb = dataSnapshot.getValue(String.class);
                                                if(pass.equals(passdb)){ //compare password to password from db
                                                    passUsername(user_name);
                                                }else{
                                                    error_message.setText("Password incorrect");
                                                }
                                            }else{
                                                error_message.setText("Fail to find password");
                                            }
                                        }

                                        @Override
                                        public void onCancelled(DatabaseError error) {
                                            // Failed to read value
                                            error_message.setText("password fail loaded");
                                        }
                                    });
                                }else{
                                    error_message.setText("password cannot be empty");
                                }
                            }else{
                                error_message.setText("Username not found");
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            // Failed to read value
                            error_message.setText("email not found");
                        }
                    });
                }else{
                    error_message.setText("username cannot be empty");
                } // if username is not null
            }
        }); //btn1 click listener
    } //end of onCreate

    //function for passing data to Login Activity
    public void passUsername(String user_name){
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra(EXTRA_TEXT, user_name);
        startActivity(intent);
    }
}