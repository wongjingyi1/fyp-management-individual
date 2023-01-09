package com.example.student;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TitlePage extends Fragment {

    //link firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users").child("username");

    private TextView remark,deadline,title1,title2,title3;
    private Button btn1,btn2,btn3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_title_page, container, false);

        String username = ((LoginActivity)getActivity()).username;
        deadline = view.findViewById(R.id.deadline);
        title1 = view.findViewById(R.id.title1);
        title2 = view.findViewById(R.id.title2);
        title3 = view.findViewById(R.id.title3);
        remark = view.findViewById(R.id.remark);
        btn1 = view.findViewById(R.id.btn_1);
        btn2 = view.findViewById(R.id.btn_2);
        btn3 = view.findViewById(R.id.btn_3);

        // Read deadline
        myRef.child(username).child("Project").child("title").child("deadline").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String deadlinedb = dataSnapshot.getValue(String.class);
                deadline.setText(deadlinedb);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                deadline.setText("Fail to read from database");
            }
        });

        // Read title1
        myRef.child(username).child("Project").child("title").child("title1").child("title").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String title1db = dataSnapshot.getValue(String.class);
                if(title1db.length() > 0){
                    title1.setText(title1db);
                }else{
                    title1.setText("None");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                title1.setText("Fail to read from database");
            }
        });

        //btn title 1
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TitleEdit TitleEdit = new TitleEdit();
                Bundle args = new Bundle();
                args.putString("abc", "Title 1");
                TitleEdit.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,TitleEdit).commit();
            }
        });

        // Read title2
        myRef.child(username).child("Project").child("title").child("title2").child("title").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String title2db = dataSnapshot.getValue(String.class);
                if(title2db.length() > 0){
                    title2.setText(title2db);
                }else{
                    title2.setText("None");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                title2.setText("Fail to read from database");
            }
        });

        //btn title 2
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TitleEdit TitleEdit = new TitleEdit();
                Bundle args = new Bundle();
                args.putString("abc", "Title 2");
                TitleEdit.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,TitleEdit).commit();
            }
        });

        // Read title3
        myRef.child(username).child("Project").child("title").child("title3").child("title").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String title3db = dataSnapshot.getValue(String.class);
                if(title3db.length() > 0){
                    title3.setText(title3db);
                }else{
                    title3.setText("None");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                title3.setText("Fail to read from database");
            }
        });

        //btn title 3
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TitleEdit TitleEdit = new TitleEdit();
                Bundle args = new Bundle();
                args.putString("abc", "Title 3");
                TitleEdit.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,TitleEdit).commit();
            }
        });

        //read comment
        myRef.child(username).child("Project").child("title").child("remark").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String remarkdb = dataSnapshot.getValue(String.class);
                if(remarkdb.length() > 0){
                    remark.setText(remarkdb);
                }else{
                    remark.setText("None");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                remark.setText("Fail to read from database");
            }
        });

        return view;
    }
}