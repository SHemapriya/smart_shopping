package com.example.hemapriya.smart_shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hema priya on 12-09-2022.
 */
public class Home_page extends AppCompatActivity {
    SharedPrefHandler shr;
    TextView Shopping,Myorder,Billing;
    ImageView Shop,Myo,Bill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        shr = new SharedPrefHandler(this);
        Shopping=(TextView)findViewById(R.id.tv_shopping);
        Myorder=(TextView)findViewById(R.id.tv_myo);
        Billing=(TextView)findViewById(R.id.tv_bill);
        Shop=(ImageView)findViewById(R.id.img_su);
        Myo=(ImageView)findViewById(R.id.img_myo);
        Bill=(ImageView)findViewById(R.id.img_bill);
        Shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),Shopping_page.class);
                startActivity(i);
                Toast.makeText(Home_page.this, "welcome", Toast.LENGTH_SHORT).show();
            }
        });
        Myorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), Order_page.class);
                startActivity(i);
                Toast.makeText(Home_page.this, "welcome", Toast.LENGTH_SHORT).show();
            }
        });
        Billing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), Billing_page.class);
                startActivity(i);
                Toast.makeText(Home_page.this, "welcome", Toast.LENGTH_SHORT).show();
            }
        });

        Shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),Shopping_page.class);
                startActivity(i);
                Toast.makeText(Home_page.this, "welcome", Toast.LENGTH_SHORT).show();

            }
        });
        Myo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), Myorder_page.class);
                startActivity(i);
                Toast.makeText(Home_page.this, "welcome", Toast.LENGTH_SHORT).show();

            }
        });
        Bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),Billing_page.class);
                startActivity(i);
                Toast.makeText(Home_page.this, "welcome", Toast.LENGTH_SHORT).show();

            }
        });


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
        // as you specify a parent activity in AndroidManifest.provider_paths.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_logout) {
            shr.setSharedPreferences("login", "true");
            Intent i = new Intent(getApplication(), Login_page.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_feedback) {
            shr.setSharedPreferences("login", "true");
            Intent i = new Intent(getApplication(), Feedback_page.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_profile) {
            shr.setSharedPreferences("login", "true");
            Intent i = new Intent(getApplication(), Profile_page.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_about) {
            shr.setSharedPreferences("login", "true");
            Intent i = new Intent(getApplication(),Aboutus_page.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_payment) {
            shr.setSharedPreferences("login", "true");
            Intent i = new Intent(getApplication(),Payment_page.class);
            startActivity(i);
            return true;
        }


            return super.onOptionsItemSelected(item);
        }
    }

