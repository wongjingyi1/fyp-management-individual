package com.example.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    public String username;
    BottomNavigationView bottomNavigationView;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users").child("username");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //get data from main activity
        Intent intent = getIntent();
        username = intent.getStringExtra(MainActivity.EXTRA_TEXT);

        /*pass username from main
        TextView text1 = findViewById(R.id.username);
        text1.setText(username);
         */

        //prepare the message for handle
        Bundle bundle = new Bundle();
        bundle.putString("handletext", username);


        //Define the three fragment for bottom nav
        HomeFragment HomeFragment = new HomeFragment();
        HomeFragment.setArguments(bundle); //set arguments for handling
        ProgressFragment ProgressFragment = new ProgressFragment();
        ProgressFragment.setArguments(bundle); //set arguments for handling
        ViewMarkingFragment ViewMarkingFragment = new ViewMarkingFragment();
        ViewMarkingFragment.setArguments(bundle); //set arguments for handling

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //code for top appbar
        TextView studentname = findViewById(R.id.student_name);
        TextView studentID = findViewById(R.id.student_id);

        myRef.child(username).child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String studentnamedb = dataSnapshot.getValue(String.class);
                studentname.setText(studentnamedb);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                studentname.setText("Fail to read from database");
            }
        });

        myRef.child(username).child("studentID").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String studentIDdb = dataSnapshot.getValue(String.class);
                studentID.setText(studentIDdb);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                studentID.setText("Fail to read from database");
            }
        });

        //code for bottom nav
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,HomeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,HomeFragment).commit();
                        return true;
                    case R.id.progress:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,ProgressFragment).commit();
                        return true;
                    case R.id.view:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,ViewMarkingFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }

}