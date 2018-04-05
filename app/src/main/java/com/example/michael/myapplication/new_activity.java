package com.example.michael.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Michael on 4/2/2018.
 */
public class new_activity extends AppCompatActivity {
    TextView p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_new_activity);
        p = findViewById(R.id.p);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("POINTS");
            p.setText(value);
        }
        else{
            p.setText("You scored: 0");
        }

    }
}
