package com.example.in2dm3_03.notificaciones;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickfin(View v){
        //Paso 1:conseguir Notificaciones
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //Paso 2: Crear notificacion
        int icon = R.drawable.ic_launcher_background;
        CharSequence text ="Notification ticket text";
        long when = System.currentTimeMillis();

        NotificationCompat.Builder builder =new NotificationCompat.Builder(getApplicationContext(), NotificationChannel.DEFAULT_CHANNEL_ID);
        builder.setSmallIcon(icon);
        builder.setTicker(text);
        builder.setWhen(when);

        Intent intent = new Intent(this,Main2Activity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,0,intent,0);

        builder.setContentTitle("Notification Title");
        builder.setContentText("Notification text");
        builder.setContentIntent(contentIntent);
        builder.setAutoCancel(true);
    }

    public void clickfin2(View v){

    }
}
