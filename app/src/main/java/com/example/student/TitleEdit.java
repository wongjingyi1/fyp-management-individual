package com.example.student;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TitleEdit extends Fragment {

    //link firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users").child("username");

    private TextView toptitle;
    private String titlepointer;
    public EditText edit_title, edit_abstract;
    private Button btn_save, btn_discard;

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
        View view = inflater.inflate(R.layout.fragment_title_edit, container, false);

        //get username from activity
        String username = ((LoginActivity)getActivity()).username;

        toptitle = view.findViewById(R.id.text1);
        edit_title = view.findViewById(R.id.edit_file);
        edit_abstract = view.findViewById(R.id.edit_abstract);
        btn_save = view.findViewById(R.id.btn_save);
        btn_discard = view.findViewById(R.id.btn_discard);

        toptitle.setText(titlepointer);
        switch (titlepointer){
            case "Title 1":
                // Read title 1
                myRef.child(username).child("Project").child("title").child("title1").child("title").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            edit_title.setText(titledb);
                        }else{
                            edit_title.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        edit_title.setText("Fail to read from database");
                    }
                });
                //read abstract 1
                myRef.child(username).child("Project").child("title").child("title1").child("abstract").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String abstractdb = dataSnapshot.getValue(String.class);
                        if(abstractdb.length() > 0){
                            edit_abstract.setText(abstractdb);
                        }else{
                            edit_abstract.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        edit_abstract.setText("Fail to read from database");
                    }
                });
                break;
            case "Title 2":
                // Read title 2
                myRef.child(username).child("Project").child("title").child("title2").child("title").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            edit_title.setText(titledb);
                        }else{
                            edit_title.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        edit_title.setText("Fail to read from database");
                    }
                });
                //read abstract 2
                myRef.child(username).child("Project").child("title").child("title2").child("abstract").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String abstractdb = dataSnapshot.getValue(String.class);
                        if(abstractdb.length() > 0){
                            edit_abstract.setText(abstractdb);
                        }else{
                            edit_abstract.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        edit_abstract.setText("Fail to read from database");
                    }
                });
                break;
            case "Title 3":
                // Read title 1
                myRef.child(username).child("Project").child("title").child("title3").child("title").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            edit_title.setText(titledb);
                        }else{
                            edit_title.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        edit_title.setText("Fail to read from database");
                    }
                });
                //read abstract 1
                myRef.child(username).child("Project").child("title").child("title3").child("abstract").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String abstractdb = dataSnapshot.getValue(String.class);
                        if(abstractdb.length() > 0){
                            edit_abstract.setText(abstractdb);
                        }else{
                            edit_abstract.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        edit_abstract.setText("Fail to read from database");
                    }
                });
                break;
        }

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TitleEdit TitleEdit = new TitleEdit();
                Bundle args = new Bundle();
                switch (titlepointer){
                    case "Title 1":
                        // Save title 1
                        myRef.child(username).child("Project").child("title").child("title1").child("title").setValue(edit_title.getText().toString());
                        myRef.child(username).child("Project").child("title").child("title1").child("abstract").setValue(edit_abstract.getText().toString());
                        args.putString("abc", "Title 1");
                        TitleEdit.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,TitleEdit).commit();
                        break;
                    case "Title 2":
                        // Save title 2
                        myRef.child(username).child("Project").child("title").child("title2").child("title").setValue(edit_title);
                        myRef.child(username).child("Project").child("title").child("title2").child("abstract").setValue(edit_abstract);
                        args.putString("abc", "Title 2");
                        TitleEdit.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,TitleEdit).commit();
                        break;
                    case "Title 3":
                        // Save title 3
                        myRef.child(username).child("Project").child("title").child("title3").child("title").setValue(edit_title);
                        myRef.child(username).child("Project").child("title").child("title3").child("abstract").setValue(edit_abstract);
                        args.putString("abc", "Title 3");
                        TitleEdit.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,TitleEdit).commit();
                        break;
                }
            }
        });

        btn_discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TitlePage TitlePage = new TitlePage();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new TitlePage()).commit();
            }
        });


        return view;
    }
}