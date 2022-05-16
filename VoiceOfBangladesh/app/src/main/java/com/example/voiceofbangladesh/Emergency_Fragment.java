package com.example.voiceofbangladesh;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class Emergency_Fragment extends Fragment implements View.OnClickListener {

    private static final int REQUEST_CALL = 1;
    private CardView call_999,call_police,call_fire,call_ambulance;
    private static FragmentManager fragmentManager;
    private static View view;
    String number ;

    public Emergency_Fragment(){

    }
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_emergency, container,false);

       initViews();
        setListeners();


   return  view;
    }


    private void initViews() {
        fragmentManager = getActivity().getSupportFragmentManager();
        call_999 =(CardView) view.findViewById(R.id.card_999);
        call_police = (CardView) view.findViewById(R.id.card_police);
        call_fire = (CardView) view.findViewById(R.id.card_fire);
        call_ambulance= (CardView) view.findViewById(R.id.card_ambulance);


    }


    private void setListeners() {
        call_999.setOnClickListener(this);
        call_police.setOnClickListener(this);
        call_fire.setOnClickListener(this);
        call_ambulance.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.card_999 :
                 number = "999" ;
                makePhoneCall();

                break;
            case R.id.card_police :
                number = "+8801521216276" ;
                makePhoneCall();

                 break;
            case R.id.card_fire :
                number = "+8801" ;
                makePhoneCall();
                 break;
            case R.id.card_ambulance :
                number = "+880152" ;
                makePhoneCall();
                break;



        }

    }

    private void makePhoneCall() {


            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:"+number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(getActivity(), "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

}