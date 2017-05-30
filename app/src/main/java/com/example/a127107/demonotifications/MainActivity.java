package com.example.a127107.demonotifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int requestCode = 123;
    int notificationID = 888;

    Button btnNotify1,btnNotify2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotify1 = (Button)findViewById(R.id.btnNotify1);
        btnNotify2 = (Button)findViewById(R.id.btnNotify2);

        btnNotify1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,requestCode,intent,PendingIntent.FLAG_CANCEL_CURRENT);

                //build notifications
                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                builder.setContentTitle("Amazing Offer!");
                builder.setContentText("Subject");
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentIntent(pendingIntent);
                builder.setAutoCancel(true);

                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                builder.setSound(uri);
                builder.setPriority(Notification.PRIORITY_HIGH);

                Notification n = builder.build();
                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

                //a good to have id, in case you want to cancel it

                notificationManager.notify(notificationID,n);
                finish();
            }
        });

        btnNotify2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,requestCode,intent,PendingIntent.FLAG_CANCEL_CURRENT);

                Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
                bigTextStyle.bigText("This is one big text");
                bigTextStyle.setBigContentTitle("Big TExt- long content");
                bigTextStyle.setSummaryText("Reflection Journal");

                //build notifications
                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                builder.setContentTitle("Amazing Offer!");
                builder.setContentText("Subject");
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentIntent(pendingIntent);
                builder.setStyle(bigTextStyle);
                builder.setAutoCancel(true);

                Notification n = builder.build();
                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

                //this replaces the existing notication with the same id

                notificationManager.notify(notificationID,n);
                finish();
            }
        });
    }
}
