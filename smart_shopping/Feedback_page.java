package com.example.hemapriya.smart_shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hema priya on 14-09-2022.
 */
public class Feedback_page extends AppCompatActivity {
    EditText sub,mno,msg;
    TextView rate;
    Button submit;
    String usr_sub,usr_mno,usr_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_page);
        sub=(EditText)findViewById(R.id.et_sub);
        mno=(EditText)findViewById(R.id.et_no);
        msg=(EditText)findViewById(R.id.et_message);
        submit=(Button)findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usr_sub=sub.getText().toString();
                usr_mno=mno.getText().toString();
                usr_msg=msg.getText().toString();
                if (usr_sub.isEmpty()||usr_mno.length()<10||usr_msg.isEmpty()){
                    Toast.makeText(Feedback_page.this, "Enter feedback", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "sathemapriya@gmail.co"});
                    email.putExtra(Intent.EXTRA_SUBJECT, usr_sub);
                    email.putExtra(Intent.EXTRA_TEXT, usr_msg+usr_mno);

                    email.setType("message/rfc822");

                    startActivity(Intent.createChooser(email, "Choose an Email client :"));

                    Toast.makeText(Feedback_page.this, " sent sucessfully", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}