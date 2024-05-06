package com.example.hemapriya.smart_shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by hema priya on 12-09-2022.
 */
public class Login_page extends AppCompatActivity {
    EditText mno,pass;
    String usr_mno,usr_pass;
    Button login,New;
    SharedPrefHandler shr;
    String str_shr_mno,str_shr_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        mno=(EditText)findViewById(R.id.et_mno);
        pass=(EditText)findViewById(R.id.et_password);
        login=(Button)findViewById(R.id.btn_login);
        New=(Button)findViewById(R.id.btn_CAA);
        shr=new SharedPrefHandler(this);
        str_shr_mno=shr.getSharedPreferences("number");
        str_shr_pass=shr.getSharedPreferences("password");
        Toast.makeText(Login_page.this, "input  "+usr_mno+usr_pass, Toast.LENGTH_SHORT).show();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usr_mno = mno.getText().toString();
                usr_pass = pass.getText().toString();
                if (usr_mno.length() < 10 || usr_pass.isEmpty()) {
                    Toast.makeText(Login_page.this, "enter valid number", Toast.LENGTH_SHORT).show();

                } else if (usr_mno.equals(str_shr_mno) && usr_pass.equals(str_shr_pass)) {
                    shr.setSharedPreferences("login","true");
                    shr.setSharedPreferences("umno",usr_mno);
                    Intent i = new Intent(getApplication(), Home_page.class);
                    startActivity(i);
                    Toast.makeText(Login_page.this, "valid", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Login_page.this, "login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        New.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplication(),Signup_page.class);
                startActivity(i);
                Toast.makeText(Login_page.this, "valid", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
