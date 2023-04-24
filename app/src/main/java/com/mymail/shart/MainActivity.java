package com.mymail.shart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText insert, insert1, insert2;

    Button retur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert = findViewById(R.id.editInsert);
        insert1 = findViewById(R.id.editInsert2);
        insert2 = findViewById(R.id.editInsert3);
        retur = findViewById(R.id.BtnRetur);

        SharedPreferences preferences = getSharedPreferences("backd", Context.MODE_PRIVATE);
        insert.setText(preferences.getString("insert",""));
        insert1.setText(preferences.getString("insert1",""));
        insert2.setText(preferences.getString("insert2",""));
    }

    public void retur(View view)
    {
        SharedPreferences preferences = getSharedPreferences("backd", Context.MODE_PRIVATE);
        SharedPreferences.Editor objEditor = preferences.edit();
        objEditor.putString("insert",insert.getText().toString());
        objEditor.commit();

        objEditor.putString("insert1",insert1.getText().toString());
        objEditor.commit();

        objEditor.putString("insert2",insert2.getText().toString());
        objEditor.commit();

        finish();
    }

    @Override
    public void onStart(){
        super.onStart();

        retur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retur(view);
            }
        });
    }
}