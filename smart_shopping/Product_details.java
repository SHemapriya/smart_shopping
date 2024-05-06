package com.example.hemapriya.smart_shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hema priya on 17-09-2022.
 */
public class Product_details extends AppCompatActivity {
    TextView productname,id,Manufacture_date,Expire_date,qr_code,quantity;
    Button order;
    String usr_productname,usr_id,usr_manufacture,usr_expire,usr_qr,usr_quantity;
    String []product;
    List<Get_product_array> productList;
    String str_shr;

    SharedPrefHandler sharedPrefHandler;
    String str_val;

    String str_user_mno,str_name,str_product_id,str_qrcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);
        productname=(TextView)findViewById(R.id.tv_name5);
        id=(TextView)findViewById(R.id.tv_ID);
        Manufacture_date=(TextView)findViewById(R.id.tv_md);
        Expire_date=(TextView)findViewById(R.id.tv_ed);
        qr_code=(TextView)findViewById(R.id.tv_qr);
        quantity=(TextView)findViewById(R.id.tv_quantity);
        order=(Button)findViewById(R.id.btn_update1);



        sharedPrefHandler=new SharedPrefHandler(this);


        str_val=sharedPrefHandler.getSharedPreferences("key");
        getProductByCode(str_val);

        Toast.makeText(Product_details.this, "product details"+str_val, Toast.LENGTH_SHORT).show();


        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                str_name = sharedPrefHandler.getSharedPreferences("uname");
                str_user_mno = sharedPrefHandler.getSharedPreferences("umno");
                str_product_id = id.getText().toString();
                str_qrcode = qr_code.getText().toString();

                CreateUserAccount();

                Intent intent = new Intent(getApplication(), Home_page.class);
                startActivity(intent);
                Toast.makeText(Product_details.this, "Thank You for Order..", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getProductByCode(final String str_val)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Get_product_array>> call = api.getProduct(str_val);

        call.enqueue(new Callback<List<Get_product_array>>() {
            @Override
            public void onResponse(Call<List<Get_product_array>> call, Response<List<Get_product_array>> response) {
                productList = response.body();

                Boolean isSuccess = false;
                if (response.body() != null) {
                    isSuccess = true;
                }

                if (isSuccess) {
                    productname.setText(productList.get(0).getname());
                    id.setText(productList.get(0).getid());
                    Manufacture_date.setText(productList.get(0).getManufacturedate());
                    Expire_date.setText(productList.get(0).getExpiredate());
                    qr_code.setText(productList.get(0).getQRcode());
                    quantity.setText(productList.get(0).getquantity());


                    //finish();

                } else {


                }
            }

            @Override
            public void onFailure(Call<List<Get_product_array>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void CreateUserAccount() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api Api = retrofit.create(Api.class);

        Call<IsExit> call = Api.Product_page(
                str_user_mno, str_name, str_product_id, str_qrcode

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