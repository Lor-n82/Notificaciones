package com.example.in2dm3_03.notificaciones;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;
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

        NotificationCompat.Builder builder =new NotificationCompat.Builder(getApplicationContext());
        builder.setSmallIcon(icon);
        builder.setTicker(text);
        builder.setWhen(when);

        Intent intent = new Intent(this,Main2Activity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,0,intent,0);

        builder.setContentTitle("Notification Title");
        builder.setContentText("Notification text");
        builder.setContentIntent(contentIntent);
        builder.setAutoCancel(true);

        builder.setDefaults(NotificationCompat.DEFAULT_VIBRATE);
        builder.setDefaults(NotificationCompat.DEFAULT_SOUND);

        Notification notif= builder.build();

        final int HELLO_ID=1;
        mNotificationManager.notify(HELLO_ID,notif);
        finish();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void clickfin2(View v){
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        int icon = R.drawable.ic_launcher_background;
        String text ="Notification ticket text";
        long when = System.currentTimeMillis();
        NotificationCompat.Builder builder =new NotificationCompat.Builder(getApplicationContext());
        builder.setSmallIcon(icon);
        builder.setTicker(text);
        builder.setWhen(when);

        RemoteViews contentView =new RemoteViews(getPackageName(),R.layout.activity_main2);
        contentView.setImageViewResource(R.id.imageView, R.drawable.ic_launcher_foreground);
        contentView.setTextViewText(R.id.textView2,"Personalizada");
        contentView.setTextViewText(R.id.textView3,"Texto personalizado");
        builder.setAutoCancel(true);
        Intent intent =new Intent(this,Main2Activity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,0,intent,0);
        builder.setContentIntent(contentIntent);
        Notification notif;

        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.N){
            builder.setCustomContentView(contentView);
            notif=builder.build();
        }else{
            notif = builder.build();
            notif.contentView=contentView;
        }

        final int HELLO_ID=2;

        mNotificationManager.notify(HELLO_ID, notif);
        finish();

    }
}
