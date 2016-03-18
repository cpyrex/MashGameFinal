package com.chazknox.mashgamefinal;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ResultsActivity extends AppCompatActivity {

    String msg;
    String msg1;
    String msg2;
    String msg3;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        dbHandler = new MyDBHandler(this, null, null, 1);
        //printDatabase();
        //get values from previous screen
        Bundle data = getIntent().getExtras();
        //check to see if data is null, prevents exceptions
        if(data == null){
            return;
        }

        msg  = data.getString("mry");
        msg1 = data.getString("kids");
        msg2 = data.getString("job");
        msg3 = data.getString("home");

        final TextView resultsTextView = (TextView) findViewById(R.id.resultsTextView);
        final TextView resultsTextView1 = (TextView) findViewById(R.id.resultsTextView1);
        final TextView resultsTextView2 = (TextView) findViewById(R.id.resultsTextView2);
        final TextView resultsTextView3 = (TextView) findViewById(R.id.resultsTextView3);

        resultsTextView.setText(msg + " is your husband. ");
        resultsTextView1.setText("You have " + msg1 + " kids. ");
        resultsTextView2.setText("You work at " + msg2);
        resultsTextView3.setText("You live in a " + msg3);



    }
    public void printDatabase(){
        List<Entry> dbString = dbHandler.databaseToString();
        String log = "";
        for (Entry pn : dbString){
            log += "\nID: " + pn.get_id() +
                    " Name: " + pn.get_name() + "\n" +
                    " Kids: " + pn.get_kids() + "\n" +
                    " Job: " + pn.get_job() + "\n" +
                    " Home: " + pn.get_home() + "\n";

        }
        System.out.println(log);
       // Toast.makeText(getBaseContext(), log, Toast.LENGTH_LONG).show();
    }

    public void saveButtonOnClick(View view) {
        Entry e = new Entry(msg, msg1, msg2, msg3);
        dbHandler.addEntry(e);
        printDatabase();
    }


}
