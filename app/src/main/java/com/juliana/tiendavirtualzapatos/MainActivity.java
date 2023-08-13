package com.juliana.tiendavirtualzapatos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.juliana.tiendavirtualzapatos.databinding.ActivityMainBinding;
import com.juliana.tiendavirtualzapatos.ui.bd.AdminSQL;
import com.juliana.tiendavirtualzapatos.ui.crud.Create;

import kotlinx.coroutines.MainCoroutineDispatcher;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private EditText edit1, edit2, edit3, edit4;
    //private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        setTheme(R.style.Theme_TiendaVirtualZapatos_NoActionBar);
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_productos, R.id.nav_servicios, R.id.nav_sucursales)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        edit1 = (EditText) findViewById(R.id.editText1);
        edit2 = (EditText) findViewById(R.id.editText2);
        edit3 = (EditText) findViewById(R.id.editText3);
        edit4 = (EditText) findViewById(R.id.editText4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =  item.getItemId();
        if(id == R.id.itemCarrito){
            Toast.makeText(this,"Este es el carrito de compras",Toast.LENGTH_SHORT).show();
        }else if(id == R.id.itemNosotros){
            Fragment crear = new Create();
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main, crear).commit();
            //Toast.makeText(this,"Este es nosotros",Toast.LENGTH_SHORT).show();
        }else if(id == R.id.itemCerrarSesion){
            Toast.makeText(this,"Este es cerrar sesión",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void insertar(View v){
        AdminSQL admin = new AdminSQL(this,"admin",null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = edit4.getText().toString();
        String tit = edit1.getText().toString();
        String img = edit2.getText().toString();
        String desc = edit3.getText().toString();
        ContentValues fila = new ContentValues();
        fila.put("id",cod);
        fila.put("titulo",tit);
        fila.put("imagen",img);
        fila.put("descripcion",desc);

        bd.insert("producto", null, fila);
        bd.close();

        edit1.setText("");
        edit2.setText("");
        edit3.setText("");
        edit4.setText("");
        Toast.makeText(this, "se guardó el producto", Toast.LENGTH_SHORT).show();
    }

    public void consultar(View v){
        AdminSQL admin = new AdminSQL(this, "admin", null, 1);
        SQLiteDatabase bd = admin.getReadableDatabase();
        String cod = edit4.getText().toString();
        Cursor fila = bd.rawQuery("select titulo, imagen, descripcion from producto where id="+cod, null);
        if(fila.moveToFirst()){
            String tit =  fila.getString(0);
            String img = fila.getString(1);
            String desc = fila.getString(2);
            edit1.setText(tit);
            edit2.setText(img);
            edit3.setText(desc);
        }else{
            Toast.makeText(this,"Producto no encontrado", Toast.LENGTH_SHORT).show();
        }
        bd.close();
    }

    public void borrar(View v){
        AdminSQL admin = new AdminSQL(this,"admin",null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = edit4.getText().toString();
        int cantidad;
        cantidad = bd.delete("producto", "id="+cod, null);
        bd.close();
        if (cantidad==1){
            Toast.makeText(this, "Se elimino el producto", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "No se pudo eliminar el producto", Toast.LENGTH_SHORT).show();
        }
        edit1.setText("");
        edit2.setText("");
        edit3.setText("");
        edit4.setText("");
    }

    public void actualizar(View v){
        AdminSQL admin = new AdminSQL(this,"admin",null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String cod = edit4.getText().toString();
        String tit = edit1.getText().toString();
        String img = edit2.getText().toString();
        String desc = edit3.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("id",cod);
        registro.put("titulo",tit);
        registro.put("imagen",img);
        registro.put("descripcion",desc);
        int cantidad;
        cantidad = bd.update("producto",registro,"id="+cod,null);
        if (cantidad==1){
            Toast.makeText(this, "Se actualizo el producto", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "No se pudo actualizar el producto", Toast.LENGTH_SHORT).show();
        }
        bd.close();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}