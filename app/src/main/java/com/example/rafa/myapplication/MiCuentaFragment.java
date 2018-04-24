package com.example.rafa.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MiCuentaFragment extends Fragment {


    private String title;
    private int position;
    private View view;

    public MiCuentaFragment() {
        // Required empty public constructor
    }

    public static MiCuentaFragment newInstance(int position,String title) {
        // Required empty public constructor
        MiCuentaFragment miCuentaFragment = new MiCuentaFragment();
        Bundle args = new Bundle();
        args.putInt("position",position);
        args.putString("title",title);
        miCuentaFragment.setArguments(args);
        return miCuentaFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mi_cuenta, container, false);

        Button login_btn = (Button) view.findViewById(R.id.login_btn);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),LoginActivity.class);
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


    }

}
