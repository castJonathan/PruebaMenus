package com.jcastillo.pruebamenus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNombre = findViewById(R.id.tvNombre);
        registerForContextMenu(tvNombre);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mAbout:
                Intent iAbout = new Intent(this, ActivityAbout.class);
                startActivity(iAbout);
                break;
            case R.id.mSettings:
                Intent iSettings = new Intent(this, ActivitySettings.class);
                startActivity(iSettings);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mEdit:
                Toast.makeText(this, "Editando", Toast.LENGTH_LONG).show();
                break;
            case R.id.mDelete:
                Toast.makeText(this, "Borrando", Toast.LENGTH_LONG).show();
                break;
        }

        return super.onContextItemSelected(item);

    }

    public void levantarMenuPopup(View view){
        ImageView image =(ImageView) findViewById(R.id.imgImagen);
        PopupMenu popupMenu = new PopupMenu(this, image);
        popupMenu.getMenuInflater().inflate(R.menu.menu_pupup, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.mView:
                        Toast.makeText(MainActivity.this, "View Image", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.mViewDetail:
                        Toast.makeText(MainActivity.this, "View Image Detail", Toast.LENGTH_LONG).show();
                        break;
                }

                return false;
            }
        });

        popupMenu.show();

    }
}