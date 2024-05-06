
package com.example.hemapriya.smart_shopping;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.Spinner;
        import android.widget.Toast;

        import com.example.hemapriya.smart_shopping.Api;
        import com.example.hemapriya.smart_shopping.OrderArray;
        import com.example.hemapriya.smart_shopping.R;
        import com.example.hemapriya.smart_shopping.SharedPrefHandler;
        import com.example.hemapriya.smart_shopping.morder_page;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;
        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lenovo on 17-09-2022.
 */
public class Order_page extends AppCompatActivity {
    SharedPrefHandler shr;
    Button search;
    Spinner s1,s2;
    String str_usr,str_id;
    ListView listView;

    String[] products;
    List<OrderArray> productList;
    ArrayAdapter<String> adapter;


    String str_mno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_page);


        listView=(ListView)findViewById(R.id.lv_otder_pid);



        shr=new SharedPrefHandler(this);


        str_mno=shr.getSharedPreferences("umno");
        Toast.makeText(Order_page.this, ""+str_mno, Toast.LENGTH_SHORT).show();
        getProductByCode(str_mno);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String str_pid=listView.getItemAtPosition(position).toString();

                shr.setSharedPreferences("pid",str_pid);
                Intent i=new Intent(getApplication(),Myorder_page.class);
                startActivity(i);
            }
        });


    }

    private void getProductByCode(final  String str_mno) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<OrderArray>> call = api.Order_pid(str_mno);

        call.enqueue(new Callback<List<OrderArray>>() {
            @Override
            public void onResponse(Call<List<OrderArray>> call, Response<List<OrderArray>> response) {
                // List<Product> responseResult = response.body();
                productList = response.body();

                Boolean isSuccess = false;
                if(productList != null) {
                    isSuccess = true;
                }

                if(isSuccess) {

                    // responseResult.getSuccess();
                    // Update all field with result data

                    loadProductListView();

                } else {


                }
            }

            @Override
            public void onFailure(Call<List<OrderArray>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }





    private void loadProductListView() {
        //Creating an String array for the ListView
        products = new String[productList.size()];



        //looping through all the products and inserting the names inside the string array
        for (int i = 0; i < productList.size(); i++) {
            products[i] = productList.get(i).getproductid();
        }

        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.item, products);
        listView.setAdapter(adapter);


    }
}
