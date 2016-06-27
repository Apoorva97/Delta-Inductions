package com.example.apoorvan.button_task1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ContentFrameLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int count = 0;
    RelativeLayout lay;
    public static final String PREFS_NAME = "myPref";
    public static final String PREFS_KEY = "COUNT";
    SharedPreferences sharedPreferences;
    TextView dispcount;
    Button buttoncount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt(PREFS_KEY,count);

        if (sharedPreferences.contains(PREFS_KEY)) {
            count = sharedPreferences.getInt(PREFS_KEY, count);
        }
        dispcount = (TextView) findViewById(R.id.textView_click);
        buttoncount = (Button) findViewById(R.id.button_click);
        lay = (RelativeLayout) findViewById(R.id.sample_main_layout);
        Button reset = (Button) findViewById((R.id.reset));

        dispcount.setText("COUNT:" + count);
        buttoncount.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                count++;
                dispcount.setText("COUNT:" + count);
                if (Math.random() < 0.2)
                    lay.setBackgroundColor(Color.RED);
                else if (Math.random() < 0.4)
                    lay.setBackgroundColor(Color.BLUE);
                else if (Math.random() < 0.6)
                    lay.setBackgroundColor(Color.MAGENTA);
                else if (Math.random() < 0.8)
                    lay.setBackgroundColor(Color.YELLOW);
                else
                    lay.setBackgroundColor(Color.GREEN);
            }

        });

        reset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                dispcount.setText("COUNT: 0");
            }
        });
        save();
        getValue();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("count");
        dispcount.setText("COUNT:" + count);
    }

    public void save() {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(PREFS_KEY, count);
        editor.commit();

    }

    public int getValue() {

        sharedPreferences =getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        if(sharedPreferences.contains(PREFS_KEY)){
            return count;
        }
        return count;
    }

    @Override
    protected void onPause() {
        super.onPause();
        save();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getValue();
    }

}
