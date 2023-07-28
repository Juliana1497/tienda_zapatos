package com.juliana.tiendavirtualzapatos.ui.sucursales;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.juliana.tiendavirtualzapatos.R;

public class SucursalesFragment extends Fragment {

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

}