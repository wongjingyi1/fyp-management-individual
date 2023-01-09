package com.example.student;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class recyclerview extends Fragment {

    RecyclerView recyclerView;
    ArrayList<datamodel> dataholder;

    public recyclerview() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_view_marking, container, false);
        recyclerView=view.findViewById(R.id.todayRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataholder=new ArrayList<>();

        datamodel ob1=new datamodel(R.drawable.ic_baseline_android_24,"Angular","Web Application");
        dataholder.add(ob1);

        datamodel ob2=new datamodel(R.drawable.ic_baseline_android_24,"C Programming","Embed Programming");
        dataholder.add(ob2);

        datamodel ob3=new datamodel(R.drawable.ic_baseline_android_24,"C++ Programming","Embed Programming");
        dataholder.add(ob3);

        datamodel ob4=new datamodel(R.drawable.ic_baseline_android_24,".NET Programming","Desktop and Web Programming");
        dataholder.add(ob4);

        datamodel ob5=new datamodel(R.drawable.ic_baseline_android_24,"Java Programming","Desktop and Web Programming");
        dataholder.add(ob5);

        datamodel ob6=new datamodel(R.drawable.ic_baseline_android_24,"Magento","Web Application Framework");
        dataholder.add(ob6);

        datamodel ob7=new datamodel(R.drawable.ic_baseline_android_24,"NodeJS","Web Application Framework");
        dataholder.add(ob7);

        datamodel ob8=new datamodel(R.drawable.ic_baseline_android_24,"Python","Desktop and Web Programming");
        dataholder.add(ob8);

        datamodel ob9=new datamodel(R.drawable.ic_baseline_android_24,"Shopify","E-Commerce Framework");
        dataholder.add(ob9);

        datamodel ob10=new datamodel(R.drawable.ic_baseline_android_24,"Wordpress","WebApplication Framewrok");
        dataholder.add(ob10);

        recyclerView.setAdapter(new myadapter(dataholder));

        return view;
    }

}