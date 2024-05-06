package com.example.hemapriya.smart_shopping;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by hema priya on 19-09-2022.
 */
public class morder_page extends AppCompatActivity {
    SharedPrefHandler sharedPrefHandler;
    String string_pid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myorder_page);

        sharedPrefHandler=new SharedPrefHandler(this);
        string_pid=sharedPrefHandler.getSharedPreferences("values");


        Toast.makeText(morder_page.this, "" + string_pid, Toast.LENGTH_SHORT).show();


    }
}
