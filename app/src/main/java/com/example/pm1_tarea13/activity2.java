package com.example.pm1_tarea13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pm1_tarea13.SQLiteConexion;
import com.example.pm1_tarea13.Transiciones;

public class activity2 extends AppCompatActivity {

    Button btadd;
    EditText tnom, tap, tedad, tcor, tdir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);


        init();

        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarEmpleado();
            }
        });

    }

    private void init()
    {
        tnom = (EditText) findViewById(R.id.txtnombres);
        tap = (EditText) findViewById(R.id.txtacapellidos);
        tedad = (EditText) findViewById(R.id.txtedad);
        tcor = (EditText) findViewById(R.id.txtcorreo);
        tdir = (EditText) findViewById(R.id.txtdireccion);
        btadd = (Button) findViewById(R.id.btnagregar);
    }

    private void AgregarEmpleado()
    {

        SQLiteConexion conexion = new SQLiteConexion(this, Transiciones.NameDataBase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Transiciones.nombres, tnom.getText().toString());
        valores.put(Transiciones.apellidos, tap.getText().toString());
        valores.put(Transiciones.edad, tedad.getText().toString());
        valores.put(Transiciones.correo, tcor.getText().toString());
        valores.put(Transiciones.direccion, tdir.getText().toString());

        Long resultado = db.insert(Transiciones.tablaEmpleados, Transiciones.id, valores);

        Toast.makeText(getApplicationContext(), "Registro Ingresado", Toast.LENGTH_LONG).show();

        db.close();

        ClearScreen();
    }

    private void ClearScreen()
    {
        tnom.setText("");
        tap.setText("");
        tedad.setText("");
        tcor.setText("");
        tdir.setText("");
    }
}