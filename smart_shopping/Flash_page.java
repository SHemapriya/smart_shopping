package com.example.hemapriya.smart_shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hema priya on 12-09-2022.
 */
public class Flash_page extends AppCompatActivity {
    SharedPrefHandler shr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash_page);
        shr = new SharedPrefHandler(this);
        Thread th = new Thread() {
            @Override
            public void run() {
                super.run();
                {
                    try {
                        sleep(3000);
                        shr = new SharedPrefHandler(getApplicationContext());
                        if (shr.getSharedPreferences("login").equals("NF")) {
                            shr.setSharedPreferences("login", "false");
                            Intent i = new Intent(getApplication(), Login_page.class);
                            startActivity(i);

                        } else if (shr.getSharedPreferences("login").equals("false")) {
                            Intent i = new Intent(getApplication(), Login_page.class);
                            startActivity(i);
                        } else if (shr.getSharedPreferences("login").equals("true")) {
                            Intent i = new Intent(getApplication(), Home_page.class);
                            startActivity(i);
                            finish();
                        }
                    }
                        catch(Exception e){

                        }

                    }
                }



        }; th.start();
    }
}



