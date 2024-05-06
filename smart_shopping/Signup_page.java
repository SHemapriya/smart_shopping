package com.example.hemapriya.smart_shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hema priya on 12-09-2022.
 */
public class Signup_page extends AppCompatActivity {
    EditText name,password,email,mno,city,postal;
    String usr_name,usr_pass,usr_email,usr_number,usr_city,usr_postal;
    SharedPrefHandler shr;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);
        name=(EditText)findViewById(R.id.et_name);
        password=(EditText)findViewById(R.id.et_password1);
        city=(EditText)findViewById(R.id.et_city1);
        postal=(EditText)findViewById(R.id.et_pa1);
        email=(EditText)findViewById(R.id.et_email2);
        mno=(EditText)findViewById(R.id.et_mno1);
        signup=(Button)findViewById(R.id.btn_signup);
        shr=new SharedPrefHandler(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usr_name=name.getText().toString();
                usr_pass=password.getText().toString();
                usr_email=email.getText().toString();
                usr_number=mno.getText().toString();
                usr_city=city.getText().toString();
                usr_postal=postal.getText().toString();

                shr.setSharedPreferences("uname",usr_name);


                if (usr_name.isEmpty() || usr_pass.isEmpty() || usr_email.isEmpty() || usr_number.isEmpty() || usr_city.isEmpty() || usr_postal.isEmpty()
                    || !usr_email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
                    || !usr_number.matches("^[6-9]\\d{9}")
                    || !usr_name.matches("[a-zA-Z]+"))

                {
                    Toast.makeText(Signup_page.this, "Fill the details", Toast.LENGTH_SHORT).show();

                }
                else {
                    shr.setSharedPreferences("password", usr_pass);
                    shr.setSharedPreferences("number", usr_number);
                    CreateUserAccount();
                    Intent i = new Intent(getApplication(),Login_page.class);
                    startActivity(i);
                    Toast.makeText(Signup_page.this, "valid successfull", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //this function is used to post application dtata to this server using post method and help of a retrofit library(http protocol)
    private void CreateUserAccount() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<IsExit> call = api.Signup_page(
                usr_name,
                usr_pass,
                usr_email,
                usr_number,
                usr_city,
                usr_postal
        );

        call.enqueue(new Callback<IsExit>() {
            @Override
            public void onResponse(Call<IsExit> call, Response<IsExit> response) {
                IsExit responseResult = response.body();

                Boolean isSuccess = false;
                if (responseResult != null) {
                    isSuccess = responseResult.getSuccess();
                }

                if (isSuccess) {

                } else {
                    // Show Creation Failed Message

                }
            }

            @Override
            public void onFailure(Call<IsExit> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

