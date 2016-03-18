package com.chazknox.mashgamefinal;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    //MyDBHandler dbHandler;

    //build the object that is going to be the notification itself
    NotificationCompat.Builder notification;

    //must give notification an unique ID
    private static final int uniqueID = 45123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //build new notification
        notification = new NotificationCompat.Builder(this);

        //remove notification once it has been visited
        notification.setAutoCancel(true);

        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(getBaseContext());

        //read Preferences
        String strUsername = pref.getString("username", "");

        //check to see if checkbox is checked
        boolean bAppUpdates = pref.getBoolean("applicationUpdates", false);
        String downloadType = pref.getString("downloadType", "1");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        RelativeLayout main_view = (RelativeLayout)findViewById(R.id.main_view);

        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent i = new Intent(this, MyPreferencesActivity.class);
                startActivity(i);

                return true;

            case R.id.menu_red:
                if(item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }

                main_view.setBackgroundColor(Color.RED);

                return true;

            case R.id.menu_green:
                if(item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }

                main_view.setBackgroundColor(Color.GREEN);
                return true;

            case R.id.menu_yellow:
                if(item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }

                main_view.setBackgroundColor(Color.YELLOW);
                return true;

            case R.id.menu_blue:
                if(item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }

                main_view.setBackgroundColor(Color.BLUE);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void startButtonClick(View view) {
        Intent intent = new Intent(this, MryActivity.class);
        startActivity(intent);
    }
    //class for displaying notification
    public void notifyClick(View view) {
        notification.setSmallIcon(R.mipmap.ic_launcher);
        notification.setTicker("Click here for special offers");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("MASH KING");
        notification.setContentText("Download the new Hit game NOW!!!!");

        //set notification sound
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        notification.setSound(alarmSound);

        //send a notification to the homescreen
        Intent i = new Intent(this, MainActivity.class);

        //give device access to perform this intent by calling the PendingIntent
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i,
                PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //send out the notification
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());



    }

    public void historyButtonClick(View view) {
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }

}
