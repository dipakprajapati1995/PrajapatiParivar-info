package com.example.prajapatiparivar.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.prajapatiparivar.NewsActivity;
import com.example.prajapatiparivar.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Random;

public class NofiticationFcm  extends FirebaseMessagingService {
    Bitmap bitmap;
    String title, body;
    String clickaction;


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        super.onMessageReceived(remoteMessage);
        Map<String, String> data = remoteMessage.getData();
        title = data.get("title");
        body = data.get("message");
        clickaction = data.get("click_action");
        String imageUri = data.get("image");


        bitmap = getBitmapfromUrl(imageUri);
        Log.d("test", "onMessageReceived: " + bitmap);

        notificationCode(title, body, bitmap);


    }


    public void notificationCode(String title, String body, Bitmap img) {

        Intent intent;
        try {
            if (clickaction.equals("updatedata")) {
                intent = new Intent(this, NewsActivity.class);
                intent.putExtra("click_action", "updatedata");
            } else {
                intent = new Intent(this, Class.forName(clickaction));
            }

        } catch (Exception e) {
            e.printStackTrace();
            intent = new Intent(this, NewsActivity.class);
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1410,
                intent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.BigTextStyle styleText = new NotificationCompat.BigTextStyle();
        styleText.setBigContentTitle(title);
        styleText.bigText(body);

        NotificationManager notificationManager =
                (NotificationManager)
                        getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder notificationBuilder;


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            String channel_id = getString(R.string.default_notification_channel_id); // default_channel_id
            String channel_title = getString(R.string.default_notification_channel_title); // Default Channel

            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = notificationManager.getNotificationChannel(channel_id);
            if (mChannel == null) {
                mChannel = new NotificationChannel(channel_id, channel_title, importance);
                mChannel.enableVibration(true);
                mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                notificationManager.createNotificationChannel(mChannel);
            }

            notificationBuilder = new
                    NotificationCompat.Builder(this, channel_id)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setLargeIcon(img)

                    .setStyle(new NotificationCompat.BigPictureStyle()
                            .bigPicture(img).setSummaryText(title).setBigContentTitle(body))    /*Notification with Image*/

                    .setAutoCancel(true)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setAutoCancel(true)
                    .setDefaults(Notification.DEFAULT_SOUND)
                    .setContentIntent(pendingIntent)
                    .setStyle(new NotificationCompat.BigPictureStyle()
                            .bigPicture(img)
                            .bigLargeIcon(img));
            //  .setStyle(styleText);

        } else {
            notificationBuilder = new
                    NotificationCompat.Builder(this)
                    .setLargeIcon(img)

                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setAutoCancel(true)
                    .setDefaults(Notification.DEFAULT_SOUND)
                    .setContentIntent(pendingIntent)
                    .setStyle(new NotificationCompat.BigPictureStyle()
                            .bigPicture(img)
                            .bigLargeIcon(img));

        }

        int notiID = 112;
        try {
            Random rand = new Random();
            notiID = rand.nextInt(100) + 1;
        } catch (Exception e) {
            notiID = 111;
        }

        notificationManager.notify(notiID, notificationBuilder.build());


    }

    public Bitmap getBitmapfromUrl(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            return bitmap;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;

        }
    }

}
