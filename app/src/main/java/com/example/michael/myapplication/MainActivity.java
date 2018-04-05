package com.example.michael.myapplication;

import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int a, b, c;
    Button rules, roll;
    ImageView box1, box2, box3;
    SeekBar bar;
    Handler handler;
    long startTime;
    int speed;
    boolean f;
    TextView prog1;
    TextView points;
    Update update;
    int p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roll = findViewById(R.id.roll);
        //rules = findViewById(R.id.rules);
        box1 = findViewById(R.id.box1);
        box2 = findViewById(R.id.box2);
        box3 = findViewById(R.id.box3);
        Random r;
        update = new Update();
        bar = findViewById(R.id.bar);
        handler = new Handler();
        startTime = System.currentTimeMillis();
        prog1 = findViewById(R.id.prog1);
        f = false;
        points = findViewById(R.id.points);
        a = 0;
        b = 0;
        c = 0;
        p = 0;
        rules = findViewById(R.id.rules);

        if (savedInstanceState != null) {
            points.setText(savedInstanceState.getString("POINTS"));
            prog1.setText(savedInstanceState.getString("TOAST"));
            a = (savedInstanceState.getInt("1"));
            b = (savedInstanceState.getInt("2"));
            c = (savedInstanceState.getInt("3"));
            p = (savedInstanceState.getInt("4"));
            switch (a)

            {
                case 1:
                    box1.setImageResource(R.drawable.cherry);
                    break;
                case 2:
                    box1.setImageResource(R.drawable.pear);
                    break;
                case 3:
                    box1.setImageResource(R.drawable.berry);
                    break;
                case 4:
                    box1.setImageResource(R.drawable.grape);
                    break;
            }

            switch (b)

            {
                case 1:
                    box2.setImageResource(R.drawable.cherry);
                    break;
                case 2:
                    box2.setImageResource(R.drawable.pear);
                    break;
                case 3:
                    box2.setImageResource(R.drawable.berry);
                    break;
                case 4:
                    box2.setImageResource(R.drawable.grape);
                    break;
            }

            switch (c)

            {
                case 1:
                    box3.setImageResource(R.drawable.cherry);
                    break;
                case 2:
                    box3.setImageResource(R.drawable.pear);
                    break;
                case 3:
                    box3.setImageResource(R.drawable.berry);
                    break;
                case 4:
                    box3.setImageResource(R.drawable.grape);
                    break;
            }
        }
    }

        public void onSaveInstanceState (Bundle savedInstanceState) {
            super.onSaveInstanceState(savedInstanceState);
            savedInstanceState.putString("POINTS", points.getText().toString());
            savedInstanceState.putString("TOAST", prog1.getText().toString());
            savedInstanceState.putInt("1", a);
            savedInstanceState.putInt("2", b);
            savedInstanceState.putInt("3", c);
            savedInstanceState.putInt("4", p);
            ;

        }



    public void rulesPressed(View v) {
        Intent i = new Intent(this, new_activity.class);
        i.putExtra("POINTS", p);
        startActivity(i);
    }



    public void OnSeekBarChangeListener() {
        bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar bar, int i, boolean b) {
                        speed = bar.getProgress();
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar SeekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar SeekBar) {

                    }
                }
        );
    }


    public void buttonPressed(View v) {
        if (f == true) {
            handler.removeCallbacks(update);
            f = false;
            setPoints();
            points.setText("You scored: " + p);
        } else {
            prog1.setText("");
            f = true;

            if (speed <= 5) {
                handler.postDelayed(update, 100);
            } else if (speed > 5 && speed <= 15) {
                handler.postDelayed(update, 50);
            } else {
                handler.postDelayed(update, 25);
            }
        }
    }


    public void findPears() {
        if (a == 2) {
            p += 10;
            if (b == 2) {
                p += 10;
                if (c == 2) {
                    p += 10;
                }
            } else if (c == 2) {
                p += 10;
                if (b == 2) {
                    p += 10;
                }
            }
        }
       else if (b == 2) {
            p += 10;
            if (a == 2) {
                p += 10;
                if (c == 2) {
                    p += 10;
                }
            } else if (c == 2) {
                p += 10;
                if (a == 2) {
                    p += 10;
                }
            }
        }
       else if (c == 2) {
            p += 10;
            if (a == 2) {
                p += 10;
                if (b == 2) {
                    p += 10;
                }
            } else if (b == 2) {
                p += 10;
                if (a == 2) {
                    p += 10;
                }
            }
        }
    }

    public void setPoints() {
        if (a == b && b == c) {
            p += 50;
            prog1.setText("JACKPOT!   - ");
            findPears();
        }
        else{
            findPears();
        }
    }

    private class Update implements Runnable{
        @Override
        public void run() {

            Random r = new Random();
            a = r.nextInt(4) + 1;
            b = r.nextInt(4) + 1;
            c = r.nextInt(4) + 1;
            //prog1.setText(a + ", " + b + ", " + c);


            switch (a)

            {
                case 1:
                    box1.setImageResource(R.drawable.cherry);
                    break;
                case 2:
                    box1.setImageResource(R.drawable.pear);
                    break;
                case 3:
                    box1.setImageResource(R.drawable.berry);
                    break;
                case 4:
                    box1.setImageResource(R.drawable.grape);
                    break;
            }

            switch (b)

            {
                case 1:
                    box2.setImageResource(R.drawable.cherry);
                    break;
                case 2:
                    box2.setImageResource(R.drawable.pear);
                    break;
                case 3:
                    box2.setImageResource(R.drawable.berry);
                    break;
                case 4:
                    box2.setImageResource(R.drawable.grape);
                    break;
            }

            switch (c)

            {
                case 1:
                    box3.setImageResource(R.drawable.cherry);
                    break;
                case 2:
                    box3.setImageResource(R.drawable.pear);
                    break;
                case 3:
                    box3.setImageResource(R.drawable.berry);
                    break;
                case 4:
                    box3.setImageResource(R.drawable.grape);
                    break;
            }
            if (speed <= 5) {
                handler.postDelayed(update, 100);
            } else if (speed > 5 && speed <= 15) {
                handler.postDelayed(update, 50);
            } else {
                handler.postDelayed(update, 25);


        }

        }

        ;
    };}







