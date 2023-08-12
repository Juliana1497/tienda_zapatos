package com.juliana.tiendavirtualzapatos;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.juliana.tiendavirtualzapatos.ui.bd.AdminSQL;

public class MainActivity2 extends AppCompatActivity {

    //private ImageView imagenMoviendose;
    //private ProgressBar barra;
    private EditText edit1, edit2, edit3;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);

        edit1 = (EditText) findViewById(R.id.editText1);
        edit2 = (EditText) findViewById(R.id.editText2);
        edit3 = (EditText) findViewById(R.id.editText3);
    }

    public void insertar(View v){
        AdminSQL admin = new AdminSQL(this,"admin",null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String tit = edit1.getText().toString();
        String desc = edit2.getText().toString();
        String img = edit3.getText().toString();
        ContentValues fila = new ContentValues();
        fila.put("titulo",tit);
        fila.put("descripcion",desc);
        fila.put("imagen",img);
        bd.insert("producto", null, fila);
        bd.close();

        edit1.setText("");
        edit2.setText("");
        edit3.setText("");
        Toast.makeText(this, "se guardó el producto", Toast.LENGTH_SHORT);
    }
}
