package com.example.hemapriya.smart_shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by hema priya on 15-09-2022.
 */
public class Billing_page extends AppCompatActivity
{

    EditText customerno,address,customermno,productdetails;
    String usr_customer,usr_add,usr_customermno,usr_productdetails;
    Button submit;

    SharedPrefHandler sharedPrefHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.billing_page);

        sharedPrefHandler=new SharedPrefHandler(this);



        customerno=(EditText)findViewById(R.id.et_cnqq);
        address=(EditText)findViewById(R.id.et_Addbqq);
        customermno=(EditText)findViewById(R.id.et_mnobqq);
        productdetails=(EditText)findViewById(R.id.et_pdqq);

        submit=(Button)findViewById(R.id.btn_submitBqq);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                usr_customer=customerno.getText().toString();
                usr_add=address.getText().toString();
                usr_customermno=customermno.getText().toString();
                usr_productdetails=productdetails.getText().toString();
                if (usr_customer.isEmpty()||usr_add.isEmpty()||usr_customermno.isEmpty()||usr_productdetails.isEmpty()){
                    Toast.makeText(Billing_page.this, "fill details", Toast.LENGTH_SHORT).show();
                }
                else {



                    sharedPrefHandler.setSharedPreferences("umno",usr_customermno);
                    sharedPrefHandler.setSharedPreferences("uname",usr_add);
                    sharedPrefHandler.setSharedPreferences("uamout",usr_customer);
                    sharedPrefHandler.setSharedPreferences("udetails",usr_productdetails);




                  Intent i = new Intent(getApplication(),PrintfinalBillActivity.class);
                    startActivity(i);
                    Toast.makeText(Billing_page.this, "pay the Bill", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
