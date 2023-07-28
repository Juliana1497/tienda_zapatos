package com.juliana.tiendavirtualzapatos.ui.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.juliana.tiendavirtualzapatos.ui.Model.Sneaker;
import com.juliana.tiendavirtualzapatos.R;

public class SneakerAdapter extends BaseAdapter {

    private Context context;

    public SneakerAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return Sneaker.ITEMS.length;
    }

    @Override
    public Sneaker getItem(int position) {
        return Sneaker.ITEMS[position];
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.card_view_productos,parent,false);
        }

        ImageView fotoSneaker = (ImageView) view.findViewById(R.id.sneakerDetailedImage);
        TextView nombreSneaker = (TextView) view.findViewById(R.id.sneakerDetailedTitle);
        TextView descripcionSneaker = (TextView) view.findViewById(R.id.sneakerDescription);
        Button botonComprar = (Button) view.findViewById(R.id.botonComprar);

        Sneaker item = getItem(position);
        fotoSneaker.setImageResource(item.getIdDrawable());
        nombreSneaker.setText(item.getName());
        descripcionSneaker.setText(item.getDescription());
        botonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(), "Producto agregado al carrito", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
