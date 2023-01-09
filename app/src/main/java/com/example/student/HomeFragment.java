package com.example.student;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {

    //link firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users").child("username");

    private TextView current_subject;
    private TextView current_status;
    private TextView current_deadline;
    private TextView next_subject;
    private TextView next_deadline;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //get the handle message from previous activity
        String username = getArguments().getString("handletext");

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        current_subject = view.findViewById(R.id.current_subject);
        current_status = view.findViewById(R.id.current_status);
        current_deadline = view.findViewById(R.id.current_deadline);
        next_subject = view.findViewById(R.id.next_subject);
        next_deadline = view.findViewById(R.id.next_deadline);

        //return current progress
        myRef.child(username).child("Project").child("currentstate").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value1 = dataSnapshot.getValue(String.class);
                current_subject.setText(value1);

                    //return current detail of current progress
                    myRef.child(username).child("Project").child(value1).child("status").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String value2 = dataSnapshot.getValue(String.class);
                            current_status.setText(value2);
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            current_status.setText("Fail to load current status");
                        }
                    });

                //return deadline of current progress
                myRef.child(username).child("Project").child(value1).child("deadline").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String value3 = dataSnapshot.getValue(String.class);
                        current_deadline.setText(value3);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        current_deadline.setText("Fail to load current deadline");
                    }
                });

                //return future work
                String nextsub = "";
                switch (value1){
                    case "title":
                        nextsub = "proposal";
                        next_subject.setText(nextsub);
                        break;
                    case "proposal":
                        nextsub = "thesis";
                        next_subject.setText(nextsub);
                        break;
                    case "thesis":
                        nextsub = "proposalpresentslide";
                        next_subject.setText(nextsub);
                        break;
                    case "proposalpresentslide":
                        nextsub = "finalpresentslide";
                        next_subject.setText(nextsub);
                        break;
                    case "finalpresentslide":
                        nextsub = "poster";
                        next_subject.setText(nextsub);
                        break;
                    case "poster":
                        nextsub = "No More Future Work";
                        next_subject.setText(nextsub);
                        break;
                }

                if(nextsub == "No More Future Work"){
                    myRef.child(username).child("Project").child("duedate").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String value4 = dataSnapshot.getValue(String.class);
                            next_deadline.setText("FYP due date at " + value4);
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            next_deadline.setText("Fail to find next subject deadline");
                        }
                    });
                }else{
                    myRef.child(username).child("Project").child(nextsub).child("deadline").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String value4 = dataSnapshot.getValue(String.class);
                            next_deadline.setText(value4);
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            next_deadline.setText("Fail to find next subject deadline");
                        }
                    });
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                current_subject.setText("Fail to load current subject");
            }
        });


        return view;
    }
}