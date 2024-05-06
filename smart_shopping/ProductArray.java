package com.example.hemapriya.smart_shopping;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by hema priya on 19-09-2022.
 */
public class ProductArray {
    private String name;
    private String id;
    private String Manufacturedate;
    private String Expiredate;
    private String Qrcode;
    private String quantity;

    public ProductArray(String  name, String id,String Manufacturedate,String Expiredate,String Qrcode,String quantity)
    {
        this.name=name;
        this.id=id;
        this.Manufacturedate=Manufacturedate;
        this.Expiredate=Expiredate;
        this.Qrcode=Qrcode;
        this.quantity=quantity;
    }
    public  String getname()
    {

        return name;
    }
    public  String getid()
    {

        return id;
    }
    public  String getManufacturedate()
    {

        return Manufacturedate;
    }
    public  String getExpiredate()
    {

        return Expiredate;
    }
    public  String getQrcode()
    {

        return Qrcode;
    }
    public  String getquantity()
    {

        return quantity;
    }
}
