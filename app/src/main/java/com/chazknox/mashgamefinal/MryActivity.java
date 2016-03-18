package com.chazknox.mashgamefinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Random;

public class MryActivity extends AppCompatActivity {

    public EditText name1EditText;
    public EditText name2EditText;
    public EditText name3EditText;
    public EditText name4EditText;
    public EditText name5EditText;

    public ArrayList<String> namesArrList = new ArrayList<String>();
    public Random random = new Random();

    String name1 = "";
    String msg = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mry);



        name1EditText = (EditText) findViewById(R.id.name1EditText);
        name2EditText = (EditText) findViewById(R.id.name2EditText);
        name3EditText = (EditText) findViewById(R.id.name3EditText);
        name4EditText = (EditText) findViewById(R.id.name4EditText);
        name5EditText = (EditText) findViewById(R.id.name5EditText);


        namesArrList.add(name1EditText.getText().toString());
        namesArrList.add(name2EditText.getText().toString());
        namesArrList.add(name3EditText.getText().toString());
        namesArrList.add(name4EditText.getText().toString());
        namesArrList.add(name5EditText.getText().toString());

        int index = random.nextInt(namesArrList.size());
        msg = namesArrList.get(index);

        /*for (Object element : namesArrList) {
            if (element != null) {
                return;
            } else {
                return;
            }
        }*/

    }

    public void submitButtonClick(View view) {

        //String msg = namesArrList.get(0);
        Intent intent = new Intent(this, KidsActivity.class);

        intent.putExtra("mry", msg);
        startActivity(intent);

        }
    }


