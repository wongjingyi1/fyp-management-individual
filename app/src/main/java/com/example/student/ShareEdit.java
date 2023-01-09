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


public class ShareEdit extends Fragment {

    //link firebase
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users").child("username");

    private TextView toptitle;
    private EditText edit_file,edit_comment;
    private Button btn_save,btn_discard;
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

        View view = inflater.inflate(R.layout.fragment_share_edit, container, false);
        String username = ((LoginActivity)getActivity()).username;

        toptitle = view.findViewById(R.id.titlepointer);
        edit_file = view.findViewById(R.id.edit_file);
        edit_comment = view.findViewById(R.id.edit_comment);
        btn_save = view.findViewById(R.id.btn_save);
        btn_discard = view.findViewById(R.id.btn_discard);

        toptitle.setText(titlepointer);
        switch (titlepointer){
            case "proposal":
                // Read Proposal
                myRef.child(username).child("Project").child("proposal").child("upload").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            edit_file.setText(titledb);
                        }else{
                            edit_file.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        edit_file.setText("Fail to read from database");
                    }
                });
                //read thesis
                myRef.child(username).child("Project").child("proposal").child("comment").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String abstractdb = dataSnapshot.getValue(String.class);
                        if(abstractdb.length() > 0){
                            edit_comment.setText(abstractdb);
                        }else{
                            edit_comment.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        edit_comment.setText("Fail to read from database");
                    }
                });
                break;
            case "thesis":
                // Read thesis
                myRef.child(username).child("Project").child("thesis").child("upload").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            edit_file.setText(titledb);
                        }else{
                            edit_file.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        edit_file.setText("Fail to read from database");
                    }
                });
                //read thesis
                myRef.child(username).child("Project").child("thesis").child("comment").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String abstractdb = dataSnapshot.getValue(String.class);
                        if(abstractdb.length() > 0){
                            edit_comment.setText(abstractdb);
                        }else{
                            edit_comment.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        edit_comment.setText("Fail to read from database");
                    }
                });
                break;
            case "proposalpresentslide":
                // proposalpresentslide
                myRef.child(username).child("Project").child("proposalpresentslide").child("upload").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            edit_file.setText(titledb);
                        }else{
                            edit_file.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        edit_file.setText("Fail to read from database");
                    }
                });
                //read thesis
                myRef.child(username).child("Project").child("proposalpresentslide").child("comment").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String abstractdb = dataSnapshot.getValue(String.class);
                        if(abstractdb.length() > 0){
                            edit_comment.setText(abstractdb);
                        }else{
                            edit_comment.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        edit_comment.setText("Fail to read from database");
                    }
                });
                break;
            case "finalpresentslide":
                // proposalpresentslide
                myRef.child(username).child("Project").child("finalpresentslide").child("upload").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            edit_file.setText(titledb);
                        }else{
                            edit_file.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        edit_file.setText("Fail to read from database");
                    }
                });
                //read thesis
                myRef.child(username).child("Project").child("finalpresentslide").child("comment").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String abstractdb = dataSnapshot.getValue(String.class);
                        if(abstractdb.length() > 0){
                            edit_comment.setText(abstractdb);
                        }else{
                            edit_comment.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        edit_comment.setText("Fail to read from database");
                    }
                });
                break;
            case "poster":
                // proposalpresentslide
                myRef.child(username).child("Project").child("poster").child("upload").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String titledb = dataSnapshot.getValue(String.class);
                        if(titledb.length() > 0){
                            edit_file.setText(titledb);
                        }else{
                            edit_file.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        edit_file.setText("Fail to read from database");
                    }
                });
                //read thesis
                myRef.child(username).child("Project").child("poster").child("comment").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String abstractdb = dataSnapshot.getValue(String.class);
                        if(abstractdb.length() > 0){
                            edit_comment.setText(abstractdb);
                        }else{
                            edit_comment.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        edit_comment.setText("Fail to read from database");
                    }
                });
                break;
        }

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareEdit ShareEdit = new ShareEdit();
                Bundle args = new Bundle();
                switch (titlepointer){
                    case "proposal":
                        // Save title 1
                        myRef.child(username).child("Project").child("proposal").child("upload").setValue(edit_file.getText().toString());
                        myRef.child(username).child("Project").child("proposal").child("comment").setValue(edit_comment.getText().toString());
                        args.putString("abc", "proposal");
                        ShareEdit.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareEdit).commit();
                        break;
                    case "thesis":
                        // Save title 1
                        myRef.child(username).child("Project").child("thesis").child("upload").setValue(edit_file.getText().toString());
                        myRef.child(username).child("Project").child("thesis").child("comment").setValue(edit_comment.getText().toString());
                        args.putString("abc", "thesis");
                        ShareEdit.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareEdit).commit();
                        break;
                    case "proposalpresentslide":
                        // Save title 1
                        myRef.child(username).child("Project").child("proposalpresentslide").child("upload").setValue(edit_file.getText().toString());
                        myRef.child(username).child("Project").child("proposalpresentslide").child("comment").setValue(edit_comment.getText().toString());
                        args.putString("abc", "proposalpresentslide");
                        ShareEdit.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareEdit).commit();
                        break;
                    case "finalpresentslide":
                        // Save title 1
                        myRef.child(username).child("Project").child("finalpresentslide").child("upload").setValue(edit_file.getText().toString());
                        myRef.child(username).child("Project").child("finalpresentslide").child("comment").setValue(edit_comment.getText().toString());
                        args.putString("abc", "finalpresentslide");
                        ShareEdit.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareEdit).commit();
                        break;
                    case "poster":
                        // Save title 1
                        myRef.child(username).child("Project").child("poster").child("upload").setValue(edit_file.getText().toString());
                        myRef.child(username).child("Project").child("poster").child("comment").setValue(edit_comment.getText().toString());
                        args.putString("abc", "poster");
                        ShareEdit.setArguments(args);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ShareEdit).commit();
                        break;
                }
            }
        });

        btn_discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressFragment ProgressFragment = new ProgressFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,new ProgressFragment()).commit();
            }
        });


        return view;
    }
}
