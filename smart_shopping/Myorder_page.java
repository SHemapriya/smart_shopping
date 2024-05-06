package com.example.hemapriya.smart_shopping;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hema priya on 15-09-2022.
 */
public class Myorder_page extends AppCompatActivity {
    SharedPrefHandler shr;
    String str_val;

    String[] products;
    List<ProductArray> productList;
    ArrayAdapter<String> adapter;

    TextView t1,t2,t3,t4,t5,t6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myorder_page);
        shr=new SharedPrefHandler(this);

        str_val=shr.getSharedPreferences("pid");

        getProductByCode(str_val);

        t1=(TextView)findViewById(R.id.tv_order1);
        t2=(TextView)findViewById(R.id.tv_order2);
        t3=(TextView)findViewById(R.id.tv_order3);
        t4=(TextView)findViewById(R.id.tv_order4);
        t5=(TextView)findViewById(R.id.tv_order5);
        t6=(TextView)findViewById(R.id.tv_order6);




    }
    private void getProductByCode(final String str_val)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<ProductArray>> call = api.getproductDetails(str_val);

        call.enqueue(new Callback<List<ProductArray>>() {
            @Override
            public void onResponse(Call<List<ProductArray>> call, Response<List<ProductArray>> response) {
                productList = response.body();

                Boolean isSuccess = false;
                if (response.body() != null) {
                    isSuccess = true;
                }

                if (isSuccess) {
                    t1.setText(productList.get(0).getname());
                    t2.setText( productList.get(0).getid());
                    t3.setText( productList.get(0).getManufacturedate());
                    t4.setText( productList.get(0).getExpiredate());
                    t5.setText(productList.get(0).getQrcode());
                    t6.setText(productList.get(0).getquantity());


                    //finish();

                } else {

                }
            }

            @Override
            public void onFailure(Call<List<ProductArray>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
