package com.example.hemapriya.smart_shopping;

/**
 * Created by hema priya on 17-09-2022.
 */
public class Get_product_array {
    private String name;
    private String id;
    private String Manufacturedate;
    private String Expiredate;
    private String QRcode;
    private String quantity;
    public Get_product_array(String name,String id,String Manufacturedate,String Expiredate,String QRcode,String quantity){
        this.name=name;
        this.id=id;
        this.Manufacturedate=Manufacturedate;
        this.Expiredate=Expiredate;
        this.QRcode=QRcode;
        this.quantity=quantity;
    }
    public String getname()
    {
        return name;
    }
    public String getid()
    {
        return id;
    }
    public String getManufacturedate()
    {
        return Manufacturedate;
    }
    public String getExpiredate()
    {
        return Expiredate;
    }
    public String getQRcode()
    {
        return QRcode;
    }
    public String getquantity()
    {
        return quantity ;
    }


}
