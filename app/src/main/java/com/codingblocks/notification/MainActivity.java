package com.codingblocks.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button simple,inbox,bigtext,bigimage;
NotificationManager notificationManager;
String channel_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simple=findViewById(R.id.simple);
        inbox=findViewById(R.id.inbox);
        bigimage=findViewById(R.id.bigimage);
        bigtext=findViewById(R.id.texttype);
        channel_id="CHANNEL";
        notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        NotificationChannel notificationChannel= null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notificationChannel = new NotificationChannel(channel_id, "defult", NotificationManager.IMPORTANCE_DEFAULT);

            notificationManager.createNotificationChannel(notificationChannel);
        }

        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getBaseContext(),MainActivity.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(getBaseContext(),111,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                Notification simplenotifiction =new NotificationCompat.Builder(MainActivity.this,channel_id).
                        setSmallIcon(R.mipmap.ic_launcher).setContentTitle("basic notification").setContentText("no")

                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent).build();

                notificationManager.notify(123,simplenotifiction);

            }
        });
        inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),MainActivity.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(getBaseContext(),121,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                Notification notification=new NotificationCompat.Builder(MainActivity.this,channel_id).setSmallIcon(R.mipmap.ic_launcher).setContentTitle("basic notification").setContentText("no")
                        .setStyle(new NotificationCompat.InboxStyle().addLine("new").addLine("pattern").addLine("etrrt").addLine("yut").addLine("wqty").addLine("heg"))
                        .setContentIntent(pendingIntent)
                        .build();
                notificationManager.notify(234,notification);

            }
        });

        bigtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),MainActivity.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(getBaseContext(),117,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                Notification notification=new NotificationCompat.Builder(MainActivity.this,channel_id).setSmallIcon(R.mipmap.ic_launcher).setContentTitle("basic notification").setContentText("no")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("Let's define a periodic infinite sequence S (0-indexed) with period K using the formula Si=(i%K)+1 Chef has found a sequence of positive integers A with length N buried underground. He suspects that it is a contiguous subsequence of some periodic sequence. Unfortunately, some elements of A are unreadable. Can you tell Chef the longest possible period K of an infinite periodic sequence which contains A (after suitably filling in the unreadable elements) as a contiguous subsequence?"))
                               .setContentIntent(pendingIntent)
                                .build();
                        notificationManager.notify(119,notification);


            }
        });
        bigimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.ic_action_name);
                Intent intent=new Intent(getBaseContext(),MainActivity.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(getBaseContext(),117,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                Notification notification=new NotificationCompat.Builder(MainActivity.this,channel_id).setSmallIcon(R.mipmap.ic_launcher).setContentTitle("basic notification").setContentText("no")
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap))
                        .setContentIntent(pendingIntent)
                        .build();
                notificationManager.notify(156,notification);

            }
        });

    }
}
