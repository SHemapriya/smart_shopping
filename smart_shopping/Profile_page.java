package com.example.hemapriya.smart_shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hema priya on 14-09-2022.
 */
public class Profile_page extends AppCompatActivity {
    EditText name, password, city, postal, email, number;
    String usr_name, usr_pass, usr_city, usr_postal, usr_email, usr_number;
    Button update;
    String str_shr_umno;
    SharedPrefHandler shr;
    String[] product;
    List<User_account_array>productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);
        name = (EditText) findViewById(R.id.et_name4);
        password = (EditText) findViewById(R.id.et_password4);
        city = (EditText) findViewById(R.id.et_city4);
        postal = (EditText) findViewById(R.id.et_pa4);
        email = (EditText) findViewById(R.id.et_email4);
        number = (EditText) findViewById(R.id.et_mno4);
        update = (Button) findViewById(R.id.btn_update1);
        shr=new SharedPrefHandler(this);
        str_shr_umno=shr.getSharedPreferences("umno");
        Toast.makeText(Profile_page.this, ""+str_shr_umno, Toast.LENGTH_SHORT).show();
        getProductByCode(str_shr_umno);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usr_name = name.getText().toString();
                usr_pass = password.getText().toString();
                usr_email = email.getText().toString();
                usr_number = number.getText().toString();
                usr_city = city.getText().toString();
                usr_postal = postal.getText().toString();
                if (usr_name.isEmpty() || usr_pass.isEmpty() || usr_email.isEmpty() || usr_number.isEmpty() || usr_city.isEmpty() || usr_postal.isEmpty()
                        || !usr_email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
                        || !usr_number.matches("^[6-9]\\d{9}")
                        || !usr_name.matches("[a-zA-Z]+"))

                {
                    Toast.makeText(Profile_page.this, "Fill the details", Toast.LENGTH_SHORT).show();

                } else {
                    CreateUserAccount();

                    Toast.makeText(Profile_page.this, "update successfull", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void getProductByCode(final String str_shr_umno)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<User_account_array>> call = api.getUserDetails(str_shr_umno);

        call.enqueue(new Callback<List<User_account_array>>() {
            @Override
            public void onResponse(Call<List<User_account_array>> call, Response<List<User_account_array>> response) {
                productList = response.body();

                Boolean isSuccess = false;
                if (response.body() != null) {
                    isSuccess = true;
                }

                if (isSuccess) {
                    name.setText(productList.get(0).getusername());
                    password.setText(productList.get(0).getpassword());
                    city.setText( productList.get(0).getcity());
                    postal.setText( productList.get(0).getpostal());
                    email.setText( productList.get(0).getemailid());
                    number.setText(productList.get(0).getmobilenumber());


                    //finish();

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<User_account_array>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void CreateUserAccount() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<IsExit> call = api.Update_page(
                usr_name, usr_pass, usr_city, usr_postal, usr_email, usr_number
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








