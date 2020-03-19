package com.motofit.beta.r1.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.motofit.beta.r1.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MotorcycleFragment extends Fragment{
    View v;
    private Spinner brand,service_drop,model;
    private ImageButton imageButton;
    private LocationManager locationManager;
    private Geocoder geocoder;
    private List<Address> addresses;
    private CoordinatorLayout coordinatorLayout;
    private static final int REQUEST_LOCATION=1;
    private EditText e1;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_motorcycle, container, false);

        brand=v.findViewById(R.id.brand);
        service_drop=v.findViewById(R.id.service_drop);
        model=v.findViewById(R.id.model);
        imageButton = v.findViewById(R.id.imageButton);
        e1=v.findViewById(R.id.e1);




        //Brand name... DropDown
        ArrayAdapter<String> service = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.company));
        service.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brand.setAdapter(service);

        //Model name... DropDown
        ArrayAdapter<String> service1 = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.doorstep_service));
        service1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        service_drop.setAdapter(service1);

        //Model name fetch from spinner of brand
        brand.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(brand.getSelectedItem().equals("Hero Motors"))
                {
                    ArrayAdapter<String> service2 = new ArrayAdapter<>(getActivity(),
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.hero));
                    service2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    model.setAdapter(service2);
                }
                else if(brand.getSelectedItem().equals("Honda Motors"))
                {
                    ArrayAdapter<String> service3 = new ArrayAdapter<>(getActivity(),
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.honda));
                    service3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    model.setAdapter(service3);
                }
                else if(brand.getSelectedItem().equals("TVS Motors"))
                {
                    ArrayAdapter<String> service4 = new ArrayAdapter<>(getActivity(),
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.tvs));
                    service4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    model.setAdapter(service4);
                }
                else if(brand.getSelectedItem().equals("Bajaj Motors"))
                {
                    ArrayAdapter<String> service5 = new ArrayAdapter<>(getActivity(),
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.bajaj));
                    service5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    model.setAdapter(service5);
                }
                else if(brand.getSelectedItem().equals("Yamaha Motors"))
                {
                    ArrayAdapter<String> service6 = new ArrayAdapter<>(getActivity(),
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.yamaha));
                    service6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    model.setAdapter(service6);
                }
                else if(brand.getSelectedItem().equals("Royal Enfield"))
                {
                    ArrayAdapter<String> service7 = new ArrayAdapter<>(getActivity(),
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.royol_enfield));
                    service7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    model.setAdapter(service7);
                }
                else if(brand.getSelectedItem().equals("Mahindra Motors"))
                {
                    ArrayAdapter<String> service8 = new ArrayAdapter<>(getActivity(),
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.mahindra));
                    service8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    model.setAdapter(service8);
                }
                else if(brand.getSelectedItem().equals("KTM"))
                {
                    ArrayAdapter<String> service9 = new ArrayAdapter<>(getActivity(),
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ktm));
                    service9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    model.setAdapter(service9);
                }
                else if(brand.getSelectedItem().equals("Piaggio"))
                {
                    ArrayAdapter<String> service10 = new ArrayAdapter<>(getActivity(),
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.piaggio));
                    service10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    model.setAdapter(service10);
                }
                else if(brand.getSelectedItem().equals("BMW"))
                {
                    ArrayAdapter<String> service11 = new ArrayAdapter<>(getActivity(),
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.bmw));
                    service11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    model.setAdapter(service11);
                }
                else
                {
                    ArrayAdapter<String> service12 = new ArrayAdapter<>(getActivity(),
                            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.select_model));
                    service12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    model.setAdapter(service12);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ///////code for getting location
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager)getContext().getSystemService(Context.LOCATION_SERVICE);
                if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                    //enable to gps on your devices.
                    OnGPS();
                }
                else{
                    //gps is already on ..
                    getlocation();
                }
            }
        });



        return v;
    }

    ////getting location method from onclicklistener
    private void getlocation()
    {
        if(ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(getActivity(),new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);
        }
        else{
            Location LocationGps=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Location LocationNetwork=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            Location LocationPassive=locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
            if(LocationGps!=null)
            {
                double lat=LocationGps.getLatitude();
                double log=LocationGps.getLongitude();
                location(lat,log);
            }
            if(LocationNetwork!=null)
            {
                double lat=LocationNetwork.getLatitude();
                double log=LocationNetwork.getLongitude();
                location(lat,log);
            }
            if(LocationPassive!=null)
            {
                double lat=LocationPassive.getLatitude();
                double log=LocationPassive.getLongitude();
                location(lat,log);
            }
            else
            {
                Toast.makeText(getContext(),"Can't Get Your Location",Toast.LENGTH_LONG).show();
            }
        }
    }

    private void location(double latitude,double longitude)
    {
        geocoder=new Geocoder(getContext(), Locale.getDefault());
        try
        {
            addresses=geocoder.getFromLocation(latitude,longitude,1);

            String address=addresses.get(0).getAddressLine(0);
            String area=addresses.get(0).getLocality();
            String city=addresses.get(0).getAdminArea();
            String country=addresses.get(0).getCountryName();
            String postalcode=addresses.get(0).getPostalCode();
            String fulladdress=address +", "+area+", "+city+", "+country+", "+postalcode;
            e1.setText(fulladdress);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void OnGPS()
    {
        final AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        builder.setMessage("Enable GPS").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        final AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}
