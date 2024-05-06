package com.example.hemapriya.smart_shopping;


import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

//import android.support.multidex.BuildConfig;

//import android.support.v4.content.FileProvider
//import androidx.multidex.BuildConfig;

public class PrintfinalBillActivity extends AppCompatActivity {

    SharedPrefHandler sharedPrefHandler;
    Button btnCreate,btnwithoutgst;
    String invoiceNo1,dated1,cuatName1,mobileNo1,custGst1,hsnCode1,state1,payment1;
    TextView textViewUnit;

    Double sum_inter =0.00,sum_intra=0.00,sum_cgst=0.00,sum_sgst=0.00,sum_igst=0.00,sum_amt=0.00;
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textViewid,textViewhsncode,textViewstate,textpayment,textViewcgst,textViewsgst,textViewigst,textViewval_cgst,textViewval_sgst,textViewval_igst, textViewamount_inter,textViewamount_intra,textViewamount,textinv;

    String sr;
    int mrandomnumber;
    String s;

    LinearLayout LinearLayoutView;
    String string_mno,stringname,stringaddress,stringpdetails,stringamt;


    private static final int PERMISSION_REQUEST_CODE = 100;






    String invoice_id;
    Double twoDigitsumsgst,twoDigitsumcgst,twoDigitsumigst,twoDigitsumintra,twoDigitsuminter,twoidigistsum_amt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_page);
        sharedPrefHandler=new SharedPrefHandler(this);





        stringpdetails=sharedPrefHandler.getSharedPreferences("udetails");
        stringamt=sharedPrefHandler.getSharedPreferences("uamout");

        string_mno=sharedPrefHandler.getSharedPreferences("umno");
        stringname=sharedPrefHandler.getSharedPreferences("uname");
        stringaddress=sharedPrefHandler.getSharedPreferences("address");

       // LinearLayoutView=(LinearLayout)findViewById(R.id.Lout);

        textView1=(TextView)findViewById(R.id.pcode);
        textView2=(TextView)findViewById(R.id.pname);
        textView3=(TextView)findViewById(R.id.pqty);
        textView4=(TextView)findViewById(R.id.pprice);
        textView5=(TextView)findViewById(R.id.pamount);
        textView6=(TextView)findViewById(R.id.pgrand);
        textViewhsncode=(TextView)findViewById(R.id.h_code);
        textViewid=(TextView)findViewById(R.id.cid);

        textinv=(TextView)findViewById(R.id.inv);


        textViewUnit=(TextView)findViewById(R.id.Unit);

        // input_id=sharedPrefHandler.getSharedPreferences("lid");


        textViewcgst=(TextView)findViewById(R.id.cg);
        textViewsgst=(TextView)findViewById(R.id.sg);
        textViewigst=(TextView)findViewById(R.id.ig);


        textViewval_cgst=(TextView)findViewById(R.id.val_cgst);
        textViewval_sgst=(TextView)findViewById(R.id.val_sgst);
        textViewval_igst=(TextView)findViewById(R.id.val_igst);
        textViewamount_inter=(TextView)findViewById(R.id.amount_inter);
        textViewamount_intra=(TextView)findViewById(R.id.amount_intra);

        textViewamount=(TextView)findViewById(R.id.amount);
        // getCartItems(string_mno);

        textView1.setText(stringpdetails);
        textView2.setText(stringamt);


        //  getSaleItems(input_id);

//        btn_print_take=(Button)findViewById(R.id.btn_print_take);

        invoiceNo1= sharedPrefHandler.getSharedPreferences("invoiceNo1");
        dated1= sharedPrefHandler.getSharedPreferences("dated1");
        cuatName1=sharedPrefHandler.getSharedPreferences("cuatName1");
        mobileNo1=sharedPrefHandler.getSharedPreferences("mobileNo1");
        custGst1=sharedPrefHandler.getSharedPreferences("custGst1");
        hsnCode1=sharedPrefHandler.getSharedPreferences("hsnCode1");
        state1=sharedPrefHandler.getSharedPreferences("state");
        payment1=sharedPrefHandler.getSharedPreferences("payment");
        invoice_id=sharedPrefHandler.getSharedPreferences("lid");




//        btnCreate = (Button)findViewById(R.id.btn_print_bill);
        btnwithoutgst = (Button)findViewById(R.id.btn_withoutgst);

//        btn_print_take.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//
//
//            }
//        });
//        btnCreate.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view) {
//
//               // Toast.makeText(PrintfinalBillActivity.this, ""+invoiceNo1+dated1+cuatName1+mobileNo1+custGst1+hsnCode1+cgst1+sgst1+igst1+totalbillamount, Toast.LENGTH_SHORT).show();
//                string_pcode=sharedPrefHandler.getSharedPreferences("pcode");
//                string_pname=sharedPrefHandler.getSharedPreferences("pname");
//                string_qty=sharedPrefHandler.getSharedPreferences("pqty");
//                string_price=sharedPrefHandler.getSharedPreferences("pprice");
//                string_amount=sharedPrefHandler.getSharedPreferences("pamount");
//                string_grand=sharedPrefHandler.getSharedPreferences("grand");
//
//                string_discount=sharedPrefHandler.getSharedPreferences("disc");
//               createPdf(invoiceNo1,dated1,cuatName1,mobileNo1,custGst1,hsnCode1,totalbillamount,string_pcode,string_pname,string_qty,string_price,string_amount,string_grand,state1,payment1);
//
//
//            }
//        });


        btnwithoutgst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

//                string_pcode=sharedPrefHandler.getSharedPreferences("pcode");
//                string_pname=sharedPrefHandler.getSharedPreferences("pname");
//                string_qty=sharedPrefHandler.getSharedPreferences("pqty");
//                string_price=sharedPrefHandler.getSharedPreferences("pprice");
//                string_amount=sharedPrefHandler.getSharedPreferences("pamount");
//                string_grand=sharedPrefHandler.getSharedPreferences("grand");


                createPdfwithoutgst(string_mno,stringname,stringaddress,stringpdetails,stringamt);


            }
        });




    }

    private boolean checkPermission() {
        int result = ActivityCompat.checkSelfPermission(PrintfinalBillActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int result1 = ActivityCompat.checkSelfPermission(PrintfinalBillActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED)
        {
            return true;
        } else {
            return false;
            //ActivityCompat.requestPermissions(PrintfinalBillActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},PERMISSION_REQUEST_CODE);
        }
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(PrintfinalBillActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(PrintfinalBillActivity.this, "Write External Storage permission allows us to save files. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(PrintfinalBillActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }


//    private void getSaleItems(final String input_id) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Api.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
//                .build();
//
//        Api api = retrofit.create(Api.class);
//
//        Call<List<SaleItems>> call = api.getSaleItems(input_id);
//
//        call.enqueue(new Callback<List<SaleItems>>() {
//            @Override
//            public void onResponse(Call<List<SaleItems>> call, Response<List<SaleItems>> response) {
//                saleItemList = response.body();
//                saleItems = new String[saleItemList.size()];
//
//                // Get cart items by product_code and iterate and add row to sale_items table
//                // Mean while calculate total_amount
//
//                int slno=1;
//                for (int i = 0; i < saleItemList.size(); i++)
//                {
//
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<SaleItems>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }



//
//    private void createPdf(String invoiceNo1,String dated1,String cuatName1,String mobileNo1,String custGst1,String hsnCode1,String totalbillamount,String string_pcode,String string_pname,String string_qty,String string_price,String string_amount,String string_grand,String state1,String payment1)
//    {
//        // create a new document
//
//        if (checkPermission()) {
//            PdfDocument document = new PdfDocument();
//
//            // crate a page description
//            PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(750, 550, 1).create();
//            PdfDocument.Page page = document.startPage(pageInfo);
//            Canvas canvas = page.getCanvas();
//            Paint paint = new Paint();
//            paint.setColor(Color.BLACK);
//            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//            paint.setTextSize(10);
//
//
//            Paint paint1 = new Paint();
//            paint1.setColor(Color.BLACK);
//            paint1.setStyle(Paint.Style.STROKE);
//
//            paint1.setStrokeWidth(2);
//
//
//
//            canvas.drawLine(5, 10, 745, 10, paint1);
//            canvas.drawLine(5, 10, 0, 545, paint1);
//
//            canvas.drawLine(1, 545, 745, 545, paint1);
//            canvas.drawLine(745, 10, 745, 545, paint1);
//
//
//            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//            paint.setTextSize(10);
//
//            canvas.drawText("GSTIN : 29EPEPM5469C1ZL", 10, 20, paint);
//
//           canvas.drawText("(O) : 8951101357", 620, 20, paint);
//            //canvas.drawText("(R): 9480182681", 580, 30, paint);
//            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//            canvas.drawText("BUYER'S COPY", 620, 40, paint);
//
//            paint.setTextSize(10);
//            canvas.drawText("TAX INVOICE", 330, 40, paint);
//            canvas.drawText("CASH MEMO", 330, 50, paint);
//
//
//            paint.setColor(Color.BLACK);
//            paint.setTextSize(18);
//            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//            // paint.setTypeface(bold);
//            canvas.drawText("SHIVANI SALES CORPORATION", 250, 70, paint);
//            paint.setColor(Color.BLACK);
//
//            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//            paint.setTextSize(10);
//            canvas.drawText("ICICI Bank Beside City Line Apartment Y.S.Colony,P.B.Road, DHARWAD-04", 220, 85, paint);
//            paint.setTextSize(10);
//            canvas.drawText("No.  " + invoiceNo1+invoice_id, 10, 100, paint);
//            canvas.drawText("Date  :  " + dated1, 550, 100, paint);
//            canvas.drawText("To, " + cuatName1, 10, 120, paint);
//            canvas.drawText("Payment Status  :  " + payment1, 550, 130, paint);
//
//            canvas.drawText("Cell  :  " + mobileNo1, 10, 160, paint);
//
//
//
//           // canvas.drawText("HSN Code : " + hsnCode1, 180, 130, paint);
//            canvas.drawText("Party GSTIN :  " + custGst1, 10, 140, paint);
//
//
//
//            canvas.drawLine(1, 180, 745, 180, paint1);
//            canvas.drawLine(1, 210, 745, 210, paint1);
//
//
//
//
//
//
//            //SL No
//            canvas.drawLine(40, 180, 40, 450, paint1);
//            //Description
//            canvas.drawLine(210, 180, 210, 450, paint1);
//
//
//
//            //HSA/SAC
//            canvas.drawLine(280, 180, 280, 450, paint1);
//
//
//// Rate
//            canvas.drawLine(330, 180, 330, 450, paint1);
////Amount
//           canvas.drawLine(390, 180, 390, 450, paint1);
////            //
//           canvas.drawLine(460, 180, 460, 470, paint1);
////
//            canvas.drawLine(555, 180, 555, 470, paint1);
//
//
//            canvas.drawLine(650, 180, 650, 470, paint1);
//
//
//            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//            paint.setTextSize(10);
//
//
//            canvas.drawText("Sl.No ", 10, 195, paint);
//            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//            paint.setTextSize(10);
//
//            int x = 10, y = 230;
//            // int v=5;
//            for (String line : textViewid.getText().toString().split("\n"))
//            {
//                canvas.drawText(line, x, y, paint);
//                y += paint.descent() - paint.ascent();
//            }
//
//            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//            paint.setTextSize(10);
//            canvas.drawText("Description", 50, 195, paint);
//            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//            paint.setTextSize(10);
//
//            int x1 = 50, y1 = 230;
//            for (String line : textView1.getText().toString().split("\n")) {
//                canvas.drawText(line, x1, y1, paint);
//                y1 += paint.descent() - paint.ascent();
//            }
//
//
//            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//            paint.setTextSize(10);
//            canvas.drawText("HSN/SAC", 220, 195, paint);
//            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//            paint.setTextSize(10);
//
//            int x11 = 220, y11 = 230;
//            for (String line : textViewhsncode.getText().toString().split("\n"))
//            {
//                canvas.drawText(line, x11, y11, paint);
//                y11 += paint.descent() - paint.ascent();
//            }
//
//
//
//
//
//
//
//
//
//
//
//
//
//            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//            paint.setTextSize(10);
//            canvas.drawText("Qty ", 290, 195, paint);
//            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//            paint.setTextSize(10);
//            int x2 = 290, y2 = 230;
//            for (String line : textView4.getText().toString().split("\n"))
//            {
//                canvas.drawText(line, x2, y2, paint);
//                y2 += paint.descent() - paint.ascent();
//            }
//
//
//
//            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//            paint.setTextSize(10);
//            canvas.drawText("Unit", 340, 195, paint);
//            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//            paint.setTextSize(10);
//
//            int x111 = 340, y111 = 230;
//            for (String line : textViewUnit.getText().toString().split("\n"))
//            {
//                canvas.drawText(line, x111, y111, paint);
//                y111 += paint.descent() - paint.ascent();
//            }
//
//
//
//
//
//            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//            paint.setTextSize(10);
//            canvas.drawText("Rate ", 400, 195, paint);
//            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//            paint.setTextSize(10);
//
//            int x3 = 400, y3 = 230;
//            for (String line : textView3.getText().toString().split("\n"))
//            {
//                canvas.drawText(line, x3, y3, paint);
//                y3 += paint.descent() - paint.ascent();
//            }
//
//
//
//                if (state1.equals(intra)) {
//
//                    Double percgst=Double.parseDouble(string_discount);
//                    // Double total1=Double.parseDouble(grand_amt);
//                    Double cCom1 = ((Double) percgst*twoDigitsumintra) / 100;
//
//
//                    DecimalFormat decimalFormat = new DecimalFormat("#.##");
//                    double twoDigitsF = Double.valueOf(decimalFormat.format(cCom1));
//
//                    Double Final_grand=twoDigitsumintra - twoDigitsF;
//                    grand_amt = (Final_grand + twoDigitsumcgst + twoDigitsumsgst);
//
//                    paint.setTextSize(10);
//                    canvas.drawText("Discount Amount ", 300, 490, paint);
//                    canvas.drawText("Rs." + twoDigitsF, 400, 490, paint);
//                    DecimalFormat decimalFormatsumigst = new DecimalFormat("#.##");
//                    grand_amtintra = Double.valueOf(decimalFormatsumigst.format(grand_amt));
//                    paint.setTextSize(12);
//                    canvas.drawText("GRAND TOTAL ", 450, 490, paint);
//                    canvas.drawText("Rs." + grand_amtintra, 550, 490, paint);
//                    long l=grand_amtintra.longValue();
//                    String return_val_in_english =   EnglishNumberToWords.convert(l);
//                    paint.setTextSize(12);
//                    canvas.drawText("( Rs." + return_val_in_english+" )", 450, 500, paint);
//                    canvas.drawText("" + twoDigitsumintra, 660, 463, paint);
//                    canvas.drawText("" + twoDigitsumcgst, 470, 463, paint);
//                    canvas.drawText("" + twoDigitsumsgst, 560, 463, paint);
//                    paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//                    paint.setTextSize(10);
//                    canvas.drawText("CGST ( % )", 470, 195, paint);
//                    paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//                    paint.setTextSize(10);
//                    int x5 = 470, y5 = 230;
//                    for (String line : textViewcgst.getText().toString().split("\n")) {
//                        canvas.drawText(line, x5, y5, paint);
//                        y5 += paint.descent() - paint.ascent();
//                    }
//                    canvas.drawLine(495, 210, 495, 450, paint1);
//                    paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//                    paint.setTextSize(10);
//                    int x51 = 510, y51 = 230;
//                    for (String line : textViewval_cgst.getText().toString().split("\n")) {
//
//
//                        canvas.drawText(line, x51, y51, paint);
//                        y51 += paint.descent() - paint.ascent();
//                    }
//                    canvas.drawLine(590, 210, 590, 450, paint1);
//                    paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//                    paint.setTextSize(10);
//                    canvas.drawText("SGST ( % ) ", 560, 195, paint);
//                    paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//                    paint.setTextSize(10);
//                    int x6 = 560, y6 = 230;
//                    for (String line : textViewsgst.getText().toString().split("\n")) {
//                        canvas.drawText(line, x6, y6, paint);
//                        y6 += paint.descent() - paint.ascent();
//                    }
//                    paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//                    paint.setTextSize(10);
//                    int x61 = 600, y61 = 230;
//                    for (String line : textViewval_sgst.getText().toString().split("\n")) {
//                        canvas.drawText(line, x61, y61, paint);
//                        y61 += paint.descent() - paint.ascent();
//                    }
//                    paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//                    paint.setTextSize(10);
//                    canvas.drawText("Amount (Rs.)", 660, 195, paint);
//                    paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//                    paint.setTextSize(10);
//
//
//                    int x4 = 660, y4 = 230;
//                    for (String line : textViewamount_intra.getText().toString().split("\n")) {
//                        canvas.drawText(line, x4, y4, paint);
//                        y4 += paint.descent() - paint.ascent();
//                    }
//
//
//
//                } else {
//
//
//                    canvas.drawText("" + twoDigitsumigst, 470, 463, paint);
//
//                    canvas.drawText("" + twoDigitsuminter, 560, 463, paint);
//
//
////                    canvas.drawText("" + twoDigitsuminter, 400, 460, paint);
////                    canvas.drawText("" + twoDigitsumigst, 520, 460, paint);
//                    grand_amt = (twoDigitsuminter + twoDigitsumigst);
//
//
//                    DecimalFormat decimalFormatsumigst = new DecimalFormat("#.##");
//                    grand_amtinter = Double.valueOf(decimalFormatsumigst.format(grand_amt));
//
//
//                    paint.setTextSize(12);
//                    canvas.drawText("GRAND TOTAL ", 500, 500, paint);
//                    canvas.drawText("Rs." + grand_amtinter, 600, 500, paint);
//
//
//
//
//
//                    paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//                    paint.setTextSize(10);
//                    canvas.drawText("IGST ( % )", 470, 195, paint);
//                    paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//                    paint.setTextSize(10);
//
//
//                    int x5 = 470, y5 = 230;
//                    for (String line : textViewigst.getText().toString().split("\n")) {
//                        canvas.drawText(line, x5, y5, paint);
//                        y5 += paint.descent() - paint.ascent();
//                    }
//
//                    canvas.drawLine(495, 210, 495, 450, paint1);
//
//
//                    paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//                    paint.setTextSize(10);
//
//
//                    int x51 = 510, y51 = 230;
//                    for (String line : textViewval_igst.getText().toString().split("\n")) {
//                        canvas.drawText(line, x51, y51, paint);
//                        y51 += paint.descent() - paint.ascent();
//                    }
//
//
//
//
//
//                    paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//                    paint.setTextSize(10);
//                    canvas.drawText("Amount (Rs.)", 560, 195, paint);
//                    paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//                    paint.setTextSize(10);
//
//
//                    int x4 = 560, y4 = 230;
//                    for (String line : textViewamount_inter.getText().toString().split("\n"))
//                    {
//                        canvas.drawText(line, x4, y4, paint);
//                        y4 += paint.descent() - paint.ascent();
//                    }
//
//
//                }
//
//
//
//
//
//
//
//
//            canvas.drawLine(1, 450, 745, 450, paint1);
//            canvas.drawLine(460, 470, 745, 470, paint1);
//
//            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//            paint.setTextSize(10);
//
//
//
//
//
//
//
//
//
//            canvas.drawText("For SHIVANI SALES CORPORATION ", 550, 530, paint);
//
//
//            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
//            paint.setTextSize(10);
//            canvas.drawText("Goods once sold will not be taken back or Exchanged and", 10, 470, paint);
//            canvas.drawText(" No warranty & No guarantee E.& O.E", 10, 480, paint);
//
//
//
//
//            canvas.drawText("Bank Name :Karnataka Vikas Grameena Bank .", 10, 500, paint);
//            canvas.drawText("A/c Name : SHIVANI SALES CORPORATION .", 10, 510, paint);
//            canvas.drawText("A/c No : 89112325193 .", 10, 520, paint);
//            canvas.drawText("IFSC Code : KVGB0004007 , Branch  : Gandhi Nagar , DHARWAD", 10, 530, paint);
//
//
//
//          //  document.finishPage(page);
//
//
//            //canvas.drawt
//            // finish the page
//            document.finishPage(page);
//            // draw text on the graphics object of the page
//
//
//            // write the document content
//            String directory_path = Environment.getExternalStorageDirectory().getPath() + "/bravery/";
//            File file = new File(directory_path);
//            if (!file.exists()) {
//                file.mkdirs();
//            }
//            String sname = invoiceNo1 + ".pdf";
//            String targetPdf = directory_path + sname;
//            File filePath = new File(targetPdf);
//            try {
//                document.writeTo(new FileOutputStream(filePath));
//                Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
//                sharedPrefHandler.setSharedPreferences("in", sname);
//            }
//            catch (IOException e)
//            {
//                Log.e("main", "error " + e.toString());
//                Toast.makeText(this, "Something wrong: " + e.toString(), Toast.LENGTH_LONG).show();
//            }
//
//            document.close();
//            s = sharedPrefHandler.getSharedPreferences("in");
//            viewPdf(s);
//
//        }
//        else
//        {
//            requestPermission();
//        }
//    }
//

    //PRINT BILL WITHOUT GST VALUE


    private void createPdfwithoutgst(String string_mno,String stringname,String stringaddress,String stringpdetails,String stringamt)
    {

        if (checkPermission()) {
            PdfDocument document = new PdfDocument();

            // crate a page description
            PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(500, 550, 1).create();
            PdfDocument.Page page = document.startPage(pageInfo);
            Canvas canvas = page.getCanvas();
            Paint paint = new Paint();
            paint.setColor(Color.BLACK);
            paint.setTextSize(8);


            canvas.drawLine(5, 10, 495, 10, paint);
            canvas.drawLine(5, 10, 0, 545, paint);

            canvas.drawLine(1, 545, 495, 545, paint);
            canvas.drawLine(495, 10, 495, 545, paint);


            //canvas.drawText("GSTIN : 29ADVFS9266Q1ZG", 10, 20, paint);

            canvas.drawText("(O) : 9035292096", 420, 20, paint);

            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
            // canvas.drawText("BUYER'S COPY", 420, 40, paint);

            paint.setTextSize(9);
//            canvas.drawText("TAX INVOICE", 220, 40, paint);
//            canvas.drawText("CASH MEMO", 220, 50, paint);


            Random random = new Random();
            mrandomnumber = random.nextInt(1000);

            sr=Integer.toString(mrandomnumber);
            //SimpleDateFormat formatter_do = new SimpleDateFormat("yyyy-MM-dd");
            String dated =new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
            // String invoi=dated+sr;


            paint.setColor(Color.BLACK);
            paint.setTextSize(15);
            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
            // paint.setTypeface(bold);
            canvas.drawText("Smart Shopping", 160, 70, paint);
            paint.setColor(Color.BLACK);
            paint.setTextSize(7);
            canvas.drawText("P.B.Road, DHARWAD-04", 210, 85, paint);
            paint.setTextSize(10);
            // canvas.drawText("No.  " + invoi, 10, 100, paint);
            canvas.drawText("Date  :  " + dated, 350, 100, paint);
            canvas.drawText("To, " + stringname, 10, 120, paint);
            // canvas.drawText("Payment Status  :  " + payment1, 350, 130, paint);

            canvas.drawText("Cell  :  " + string_mno, 10, 140, paint);
            // canvas.drawText("HSN Code : " + hsnCode1, 180, 130, paint);
            //canvas.drawText("Party GSTIN :  " + custGst1, 10, 140, paint);

            canvas.drawLine(1, 180, 495, 180, paint);
            canvas.drawLine(1, 210, 495, 210, paint);





            //SL No
            canvas.drawLine(40, 180, 40, 450, paint);
            //Description
            //canvas.drawLine(220, 180, 220, 450, paint);



            //HSA/SAC
            // canvas.drawLine(290, 180, 290, 450, paint);


// Rate
            canvas.drawLine(330, 180, 330, 450, paint);
//Amount
            canvas.drawLine(390, 180, 390, 450, paint);
//            //
            // canvas.drawLine(480, 180, 480, 450, paint);
////
//            canvas.drawLine(590, 180, 590, 470, paint);

            paint.setTextSize(10);
            canvas.drawText("Sl.No ", 10, 195, paint);
            paint.setTextSize(10);
            int x = 10, y = 230;
            // int v=5;
            for (String line : textViewid.getText().toString().split("\n"))
            {
                canvas.drawText(line, x, y, paint);
                y += paint.descent() - paint.ascent();
            }

            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
            paint.setTextSize(10);
            canvas.drawText("Description", 50, 195, paint);
            paint.setTextSize(10);
            int x1 = 50, y1 = 230;
            for (String line : textView1.getText().toString().split("\n")) {
                canvas.drawText(line, x1, y1, paint);
                y1 += paint.descent() - paint.ascent();
            }


            paint.setTypeface(Typeface.create("Arial", Typeface.BOLD));
            paint.setTextSize(10);
            canvas.drawText("Amount ", 340, 195, paint);
            paint.setTextSize(10);
            int x3 = 340, y3 = 230;
            for (String line : textView2.getText().toString().split("\n"))
            {
                canvas.drawText(line, x3, y3, paint);
                y3 += paint.descent() - paint.ascent();
            }







            paint.setTextSize(11);
            canvas.drawText("GRAND TOTAL ", 320, 500, paint);
            canvas.drawText("Rs." + textView2.getText().toString(), 410, 500, paint);














            canvas.drawLine(1, 450, 495, 450, paint);
//            canvas.drawLine(390, 470, 695, 470, paint);

            paint.setTextSize(8);



            canvas.drawText("For smart shopping ", 350, 530, paint);


//            paint.setTextSize(8);
//            canvas.drawText("Bank Name : Karnataka Vikas Grameena Bank", 10, 470, paint);
//            canvas.drawText("A/c Name : SHIVANI SALES CORPORATION", 10, 480, paint);
//
//            canvas.drawText("A/c No : 89112325193", 10, 490, paint);
//            canvas.drawText("IFSC Code : KVGB0004007", 10, 500, paint);
//            canvas.drawText("Branch : Gandhi Nagar , DHARWAD", 10, 510, paint);
            //  document.finishPage(page);


            //canvas.drawt
            // finish the page
            document.finishPage(page);
            // draw text on the graphics object of the page


            // write the document content
            String directory_path = Environment.getExternalStorageDirectory().getPath() + "/bravery/";
            File file = new File(directory_path);
            if (!file.exists()) {
                file.mkdirs();
            }
            String sname = invoiceNo1 + ".pdf";
            String targetPdf = directory_path + sname;
            File filePath = new File(targetPdf);
            try {
                document.writeTo(new FileOutputStream(filePath));
                Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
                sharedPrefHandler.setSharedPreferences("in", sname);
            } catch (IOException e) {
                Log.e("main", "error " + e.toString());
                Toast.makeText(this, "Something wrong: " + e.toString(), Toast.LENGTH_LONG).show();
            }

            document.close();
            s = sharedPrefHandler.getSharedPreferences("in");
            viewPdf(s);

        }
        else
        {
            requestPermission();
        }
    }










    // Method for opening a pdf file
    public void viewPdf(String s) {


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/bravery/"+s;
        File file = new File(directory_path);


        Uri uri = FileProvider.getUriForFile(PrintfinalBillActivity.this, BuildConfig.APPLICATION_ID + ".provider",file);

        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(uri, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try
        {
            startActivity(pdfIntent);
        }
        catch(ActivityNotFoundException e)
        {
            Toast.makeText(PrintfinalBillActivity .this, "No Application available to view pdf", Toast.LENGTH_LONG).show();
        }
    }

}