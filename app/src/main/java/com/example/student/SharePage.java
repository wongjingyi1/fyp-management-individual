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

public class SharePage extends Fragment {

    //link firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users").child("username");

    private TextView remark,deadline,subject1,subject2;
    private Button btn1;
    public String titlepointer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            titlepointer = getArguments().getString("abc");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_share_page, container, false);

        String username = ((LoginActivity)getActivity()).username;
        deadline = view.findViewById(R.id.deadline);
        subject1 = view.findViewById(R.id.subject);
        subject2 = view.findViewById(R.id.subject2);
        remark = view.findViewById(R.id.remark);
        btn1 = view.findViewById(R.id.btn_1);

        //set topic
        subject2.setText(titlepointer);
        switch (titlepointer){
            case "proposal":
                subject1.setText("Proposal");
                myRef.child(username).child("Project").child("proposal").child("deadline").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String deadlinedb = dataSnapshot.getValue(String.class);
                        if(deadlinedb.length() > 0){
                            deadline.setText(deadlinedb);
                        }else{
                            deadline.setText("deadline not set yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        deadline.setText("Fail to read from db");
                    }
                });

                //read remark
                myRef.child(username).child("Project").child("proposal").child("remark").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String remarkdb = dataSnapshot.getValue(String.class);
                        if(remarkdb.length() > 0){
                            remark.setText(remarkdb);
                        }else{
                            remark.setText("Doesn't have any remark yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        remark.setText("Fail to read from db");
                    }
                });

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShareEdit ShareEdit = new ShareEdit();
                        Bundle args = new Bundle();
                        args.putString("abc", "proposal");
                        ShareEdit.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareEdit).commit();
                    }
                });
                break;
            case "thesis": // thesis -----------------------------------------------------------------------------------------------------------
                subject1.setText("Thesis");
                myRef.child(username).child("Project").child("thesis").child("deadline").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String deadlinedb = dataSnapshot.getValue(String.class);
                        if(deadlinedb.length() > 0){
                            deadline.setText(deadlinedb);
                        }else{
                            deadline.setText("deadline not set yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        deadline.setText("Fail to read from db");
                    }
                });

                //read remark
                myRef.child(username).child("Project").child("thesis").child("remark").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String remarkdb = dataSnapshot.getValue(String.class);
                        if(remarkdb.length() > 0){
                            remark.setText(remarkdb);
                        }else{
                            remark.setText("Doesn't have any remark yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        remark.setText("Fail to read from db");
                    }
                });

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShareEdit ShareEdit = new ShareEdit();
                        Bundle args = new Bundle();
                        args.putString("abc", "thesis");
                        ShareEdit.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareEdit).commit();
                    }
                });
                break;
            case "proposalpresentslide": // Proposal Presentation Slide -----------------------------------------------------------------------------------------------------------
                subject1.setText("Proposal Presentation Slide");
                myRef.child(username).child("Project").child("proposalpresentslide").child("deadline").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String deadlinedb = dataSnapshot.getValue(String.class);
                        if(deadlinedb.length() > 0){
                            deadline.setText(deadlinedb);
                        }else{
                            deadline.setText("deadline not set yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        deadline.setText("Fail to read from db");
                    }
                });

                //read remark
                myRef.child(username).child("Project").child("proposalpresentslide").child("remark").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String proposalpresentslidedb = dataSnapshot.getValue(String.class);
                        if(proposalpresentslidedb.length() > 0){
                            remark.setText(proposalpresentslidedb);
                        }else{
                            remark.setText("Doesn't have any remark yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        remark.setText("Fail to read from db");
                    }
                });

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShareEdit ShareEdit = new ShareEdit();
                        Bundle args = new Bundle();
                        args.putString("abc", "proposalpresentslide");
                        ShareEdit.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareEdit).commit();
                    }
                });
                break;
            case "finalpresentslide": // Final Presentation Slide -----------------------------------------------------------------------------------------------------------
                subject1.setText("Final Presentation Slide");
                myRef.child(username).child("Project").child("finalpresentslide").child("deadline").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String finalpresentslidedb = dataSnapshot.getValue(String.class);
                        if(finalpresentslidedb.length() > 0){
                            deadline.setText(finalpresentslidedb);
                        }else{
                            deadline.setText("deadline not set yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        deadline.setText("Fail to read from db");
                    }
                });

                //read remark
                myRef.child(username).child("Project").child("finalpresentslide").child("remark").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String finalpresentslidedb = dataSnapshot.getValue(String.class);
                        if(finalpresentslidedb.length() > 0){
                            remark.setText(finalpresentslidedb);
                        }else{
                            remark.setText("Doesn't have any remark yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        remark.setText("Fail to read from db");
                    }
                });

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShareEdit ShareEdit = new ShareEdit();
                        Bundle args = new Bundle();
                        args.putString("abc", "finalpresentslide");
                        ShareEdit.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareEdit).commit();
                    }
                });
                break;
            case "poster": // poster Slide -----------------------------------------------------------------------------------------------------------
                subject1.setText("Poster");
                myRef.child(username).child("Project").child("poster").child("deadline").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String posterdb = dataSnapshot.getValue(String.class);
                        if(posterdb.length() > 0){
                            deadline.setText(posterdb);
                        }else{
                            deadline.setText("deadline not set yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        deadline.setText("Fail to read from db");
                    }
                });

                //read remark
                myRef.child(username).child("Project").child("poster").child("remark").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String posterdb = dataSnapshot.getValue(String.class);
                        if(posterdb.length() > 0){
                            remark.setText(posterdb);
                        }else{
                            remark.setText("Doesn't have any remark yet");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        remark.setText("Fail to read from db");
                    }
                });

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShareEdit ShareEdit = new ShareEdit();
                        Bundle args = new Bundle();
                        args.putString("abc", "poster");
                        ShareEdit.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareEdit).commit();
                    }
                });
                break;
        }

        return view;
    }
}