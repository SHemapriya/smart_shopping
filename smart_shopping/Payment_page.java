package com.example.hemapriya.smart_shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by hema priya on 17-09-2022.
 */
public class Payment_page extends AppCompatActivity {
    Button gpay,phonepe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_page);

        gpay=(Button)findViewById(R.id.btn_Gpay);
        phonepe=(Button)findViewById(R.id.btn_phonepay);

        gpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.nbu.paisa.user");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                } else {
                    Toast.makeText(Payment_page.this, "There is no package is available in android", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(Payment_page.this, "I clicked on GPay", Toast.LENGTH_SHORT).show();
            }
        });

        phonepe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.phonepe.app");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                } else {
                    Toast.makeText(Payment_page.this, "There is no package available in android", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(Payment_page.this, "I clicked on PhonePe", Toast.LENGTH_SHORT).show();
            }
        });




    }
}