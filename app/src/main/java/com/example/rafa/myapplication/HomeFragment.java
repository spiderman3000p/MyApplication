package com.example.rafa.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private String title;
    private int position;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(int position,String title) {
        // Required empty public constructor
        HomeFragment homeFragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putInt("position",position);
        args.putString("title",title);
        homeFragment.setArguments(args);
        return homeFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        CardView cv1 = new CardView(getContext());
        cv1 = (CardView) view.findViewById(R.id.cardview1);
        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MapsActivity.class);
                Bundle args = new Bundle();
                args.putString("title","Titulo 1");
                args.putString("Icono","icono1");
                args.putInt("color",R.color.opcion1);
                args.putInt("icono",R.drawable.ic_dashboard_black_24dp);
                intent.putExtras(args);
                startActivity(intent);
            }
        });
        CardView cv2 = new CardView(getContext());
        cv2 = (CardView) view.findViewById(R.id.cardview2);
        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MapsActivity.class);
                Bundle args = new Bundle();
                args.putString("title","Titulo 2");
                args.putString("Icono","icono2");
                args.putInt("color",R.color.opcion2);
                args.putInt("icono",R.drawable.ic_dashboard_black_24dp);
                intent.putExtras(args);
                startActivity(intent);
            }
        });
        CardView cv3 = new CardView(getContext());
        cv3 = (CardView) view.findViewById(R.id.cardview3);
        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MapsActivity.class);
                Bundle args = new Bundle();
                args.putString("title","Titulo 3");
                args.putString("Icono","icono3");
                args.putInt("color",R.color.opcion3);
                args.putInt("icono",R.drawable.ic_dashboard_black_24dp);
                intent.putExtras(args);
                startActivity(intent);
            }
        });
        CardView cv4 = new CardView(getContext());
        cv4 = (CardView) view.findViewById(R.id.cardview4);
        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MapsActivity.class);
                Bundle args = new Bundle();
                args.putString("title","Titulo 4");
                args.putString("Icono","icono4");
                args.putInt("color",R.color.opcion4);
                args.putInt("icono",R.drawable.ic_dashboard_black_24dp);
                intent.putExtras(args);
                startActivity(intent);
            }
        });
        CardView cv5 = new CardView(getContext());
        cv5 = (CardView) view.findViewById(R.id.cardview5);
        cv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MapsActivity.class);
                Bundle args = new Bundle();
                args.putString("title","Titulo 5");
                args.putString("Icono","icono5");
                args.putInt("color",R.color.opcion5);
                args.putInt("icono",R.drawable.ic_dashboard_black_24dp);
                intent.putExtras(args);
                startActivity(intent);
            }
        });
        CardView cv6 = new CardView(getContext());
        cv6 = (CardView) view.findViewById(R.id.cardview6);
        cv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MapsActivity.class);
                Bundle args = new Bundle();
                args.putString("title","Titulo 6");
                args.putString("Icono","icono6");
                args.putInt("color",R.color.opcion6);
                args.putInt("icono",R.drawable.ic_dashboard_black_24dp);
                intent.putExtras(args);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("position",0);
        title = getArguments().getString("title","Inicio");

        //enlazar cardviews con click listeners

    }

}
