package com.example.hemapriya.smart_shopping;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by hema priya on 14-09-2022.
 */
public class Contactus_page extends AppCompatActivity {
    ImageView sumayya,hemapriya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus_page);
        sumayya =(ImageView)findViewById(R.id.btn_sumii);
        hemapriya =(ImageView)findViewById(R.id.btn_priya);
        sumayya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:8762244115"));
                startActivity(i);
            }
        });
        hemapriya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:9606717844"));
                startActivity(i);
            }
        });

    }
}
