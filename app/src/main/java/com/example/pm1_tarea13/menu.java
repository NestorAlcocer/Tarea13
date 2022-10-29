package com.example.pm1_tarea13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class menu extends AppCompatActivity {
    Button bcreate,bconsul;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        bcreate = (Button) findViewById(R.id.btncrear);
        bconsul = (Button) findViewById(R.id.btnconsultar);


        bcreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),activity2.class);

                startActivity(intent);
            }
        });


        bconsul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),activity1.class);

                startActivity(intent);
            }
        });
    }
}