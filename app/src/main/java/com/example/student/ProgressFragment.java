package com.example.student;

import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProgressFragment extends Fragment {

    //link firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users").child("username");

    private ConstraintLayout box1,box2,box3,box4,box5,box6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_progress, container, false);


        //get the handle message from previous activity
        String username = ((LoginActivity)getActivity()).username;

        box1 = view.findViewById(R.id.box1);
        box2 = view.findViewById(R.id.box2);
        box3 = view.findViewById(R.id.box3);
        box4 = view.findViewById(R.id.box4);
        box5 = view.findViewById(R.id.box5);
        box6 = view.findViewById(R.id.box6);

        //Read Title box ----------------------------------------------------------------------------------------------------(box1)
        myRef.child(username).child("Project").child("title").child("status").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String box1db = dataSnapshot.getValue(String.class);
                switch (box1db){
                    case "pending":
                        box1.setBackgroundColor(Color.RED);
                        break;
                    case "KIV":
                        box1.setBackgroundColor(Color.YELLOW);
                        break;
                    case "approve":
                        box1.setBackgroundColor(Color.GREEN);
                        break;
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                box1.setBackgroundColor(Color.YELLOW);
            }
        });

        //box1 click listener
        box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TitlePage TitlePage = new TitlePage();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new TitlePage()).commit();
            }
        });

        //Read Proposal box ----------------------------------------------------------------------------------------------------(box2)
        myRef.child(username).child("Project").child("proposal").child("status").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String box2db = dataSnapshot.getValue(String.class);
                switch (box2db){
                    case "pending":
                        box2.setBackgroundColor(Color.RED);
                        break;
                    case "KIV":
                        box2.setBackgroundColor(Color.YELLOW);
                        break;
                    case "approve":
                        box2.setBackgroundColor(Color.GREEN);
                        break;
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                box2.setBackgroundColor(Color.YELLOW);
            }
        });

        //box2 click listener
        box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharePage SharePage = new SharePage();
                Bundle args = new Bundle();
                args.putString("abc", "proposal");
                SharePage.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,SharePage).commit();
            }
        });

        //Read Thesis box ----------------------------------------------------------------------------------------------------(box2)
        myRef.child(username).child("Project").child("thesis").child("status").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String box3db = dataSnapshot.getValue(String.class);
                switch (box3db){
                    case "pending":
                        box3.setBackgroundColor(Color.RED);
                        break;
                    case "KIV":
                        box3.setBackgroundColor(Color.YELLOW);
                        break;
                    case "approve":
                        box3.setBackgroundColor(Color.GREEN);
                        break;
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                box3.setBackgroundColor(Color.YELLOW);
            }
        });

        //box2 click listener
        box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharePage SharePage = new SharePage();
                Bundle args = new Bundle();
                args.putString("abc", "thesis");
                SharePage.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,SharePage).commit();
            }
        });

        //Read Proposal Presentation Slide box ----------------------------------------------------------------------------------------------------(box2)
        myRef.child(username).child("Project").child("proposalpresentslide").child("status").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String box4db = dataSnapshot.getValue(String.class);
                switch (box4db){
                    case "pending":
                        box4.setBackgroundColor(Color.RED);
                        break;
                    case "KIV":
                        box4.setBackgroundColor(Color.YELLOW);
                        break;
                    case "approve":
                        box4.setBackgroundColor(Color.GREEN);
                        break;
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                box4.setBackgroundColor(Color.YELLOW);
            }
        });

        //box2 click listener
        box4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharePage SharePage = new SharePage();
                Bundle args = new Bundle();
                args.putString("abc", "proposalpresentslide");
                SharePage.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,SharePage).commit();
            }
        });

        //Read Final Presentation Slide box ----------------------------------------------------------------------------------------------------(box2)
        myRef.child(username).child("Project").child("finalpresentslide").child("status").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String box5db = dataSnapshot.getValue(String.class);
                switch (box5db){
                    case "pending":
                        box5.setBackgroundColor(Color.RED);
                        break;
                    case "KIV":
                        box5.setBackgroundColor(Color.YELLOW);
                        break;
                    case "approve":
                        box5.setBackgroundColor(Color.GREEN);
                        break;
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                box5.setBackgroundColor(Color.YELLOW);
            }
        });

        //box2 click listener
        box5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharePage SharePage = new SharePage();
                Bundle args = new Bundle();
                args.putString("abc", "finalpresentslide");
                SharePage.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,SharePage).commit();
            }
        });

        //Read Poster box ----------------------------------------------------------------------------------------------------(box2)
        myRef.child(username).child("Project").child("poster").child("status").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String box6db = dataSnapshot.getValue(String.class);
                switch (box6db){
                    case "pending":
                        box6.setBackgroundColor(Color.RED);
                        break;
                    case "KIV":
                        box6.setBackgroundColor(Color.YELLOW);
                        break;
                    case "approve":
                        box6.setBackgroundColor(Color.GREEN);
                        break;
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                box6.setBackgroundColor(Color.YELLOW);
            }
        });

        //box2 click listener
        box6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharePage SharePage = new SharePage();
                Bundle args = new Bundle();
                args.putString("abc", "poster");
                SharePage.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,SharePage).commit();
            }
        });


        return view;
    }
}