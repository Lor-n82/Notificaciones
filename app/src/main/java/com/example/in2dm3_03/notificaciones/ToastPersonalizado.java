package com.example.in2dm3_03.notificaciones;

import android.support.v4.widget.ImageViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class ToastPersonalizado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_personalizado);

        LayoutInflater inf = getLayoutInflater();
        View vista =inf.inflate(R.layout.activity_toast_personalizado, (ViewGroup) findViewById(R.id.activity_toast_personalizado));

        TextView textotoast=(TextView) vista.findViewById(R.id.textViewToast);
        textotoast.setText("Este es el texto");

        Toast t = new Toast(getApplicationContext());
        t.setDuration(Toast.LENGTH_LONG);
        t.setView(vista);
        t.show();

        finish();
    }


}
