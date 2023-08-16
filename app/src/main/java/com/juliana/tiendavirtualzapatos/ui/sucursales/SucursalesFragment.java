package com.juliana.tiendavirtualzapatos.ui.sucursales;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.juliana.tiendavirtualzapatos.MainActivity2;
import com.juliana.tiendavirtualzapatos.R;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class SucursalesFragment extends Fragment {

    private MainActivity2 main;
    private MapView mapView;
    public SucursalesFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.sucursales_layout, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}