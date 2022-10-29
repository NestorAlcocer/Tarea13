package com.example.pm1_tarea13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pm1_tarea13.SQLiteConexion;
import com.example.pm1_tarea13.Transiciones;

public class activity1 extends AppCompatActivity {


    SQLiteConexion conexion = new SQLiteConexion(this, Transiciones.NameDataBase, null, 1);

    EditText id, nombres, apellidos, edad, correo, direccion;
    Button bconsulta, beliminar, bact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);

        init();

        bconsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BuscarEmpleado();
            }
        });

        bact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditarContacto();
            }
        });

        beliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarContacto();
            }
        });

    }

    private void BuscarEmpleado() {
        try {
            SQLiteDatabase db = conexion.getWritableDatabase();
            /* Parametros de BUSQUEDA de la sentencia SELECT*/
            String[] params = {id.getText().toString()};

            /* Campos a retornar  de la sentencia SELECT*/
            String[] fields = {Transiciones.nombres,
                    Transiciones.apellidos,
                    Transiciones.correo,
                    Transiciones.edad,
                    Transiciones.direccion};

            String WhereCondition = Transiciones.id + "=?";

            Cursor cdata = db.query(Transiciones.tablaEmpleados,
                    fields,
                    WhereCondition, params, null, null, null);

            cdata.moveToFirst();

            if (cdata.getCount() > 0) {
                nombres.setText(cdata.getString(0));
                apellidos.setText(cdata.getString(1));
                correo.setText(cdata.getString(2));
                edad.setText(cdata.getString(3));
                direccion.setText(cdata.getString(4));

                Toast.makeText(getApplicationContext(), "Consultado con exito !!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "No hay datos !!", Toast.LENGTH_LONG).show();
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "ha ocurrido un inconveniente !!", Toast.LENGTH_LONG).show();
        }


    }


    private void EditarContacto() {
        //SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDatabase,null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        String ObjCodigo = id.getText().toString();

        ContentValues valores = new ContentValues();

        valores.put(Transiciones.nombres, nombres.getText().toString());
        valores.put(Transiciones.apellidos, apellidos.getText().toString());
        valores.put(Transiciones.edad, edad.getText().toString());
        valores.put(Transiciones.correo, correo.getText().toString());
        valores.put(Transiciones.direccion, direccion.getText().toString());

        try {
            db.update(Transiciones.tablaEmpleados, valores, Transiciones.id + " = " + ObjCodigo, null);
            db.close();
            Toast.makeText(getApplicationContext(), "Se actualizo correctamente", Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "No se actualizo", Toast.LENGTH_SHORT).show();
        }


        ClearScreen();
    }


    private void Eliminar() {


    }

    private void init() {
        conexion = new SQLiteConexion(this, Transiciones.NameDataBase, null, 1);

        bconsulta = (Button) findViewById(R.id.btnbuscar);
        beliminar = (Button) findViewById(R.id.btneliminar);
        bact = (Button) findViewById(R.id.btnactualizar);

        id = (EditText) findViewById(R.id.txtcid);
        nombres = (EditText) findViewById(R.id.txtcnombres);
        apellidos = (EditText) findViewById(R.id.txtcapellidos);
        edad = (EditText) findViewById(R.id.txtcedad);
        correo = (EditText) findViewById(R.id.txtccorreo);
        direccion = (EditText) findViewById(R.id.txtcdireccion);

    }


    private void eliminarContacto() {
        SQLiteConexion conexion = new SQLiteConexion(this, Transiciones.NameDataBase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        String obtenerCodigo = id.getText().toString();

        db.delete(Transiciones.tablaEmpleados, Transiciones.id + " = " + obtenerCodigo, null);

        Toast.makeText(getApplicationContext(), "Registro eliminado con exito, Codigo " + obtenerCodigo
                , Toast.LENGTH_LONG).show();
        db.close();
        ClearScreen();


    }

    private void ClearScreen() {
        id.setText("");
        nombres.setText("");
        apellidos.setText("");
        edad.setText("");
        correo.setText("");
        direccion.setText("");
    }
}