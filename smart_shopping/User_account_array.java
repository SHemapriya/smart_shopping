package com.example.hemapriya.smart_shopping;

/**
 * Created by hema priya on 14-09-2022.
 */
public class User_account_array {
    private String username;
    private String password;
    private String emailid;
    private String mobilenumber;
    private String city;
    private String postal;
    public User_account_array(String username,String password,String emailid,String city,String postal,String mobilenumber){
        this.username=username;
        this.password=password;
        this.emailid=emailid;
        this.city=city;
        this.postal=postal;
        this.mobilenumber=mobilenumber;
    }
    public String getusername()
    {
        return username;
    }
    public String getpassword()
    {
        return password;
    }
    public String getemailid()
    {
        return emailid;
    }
    public String getmobilenumber()
    {
        return mobilenumber;
    }
    public String getcity()
    {
        return city;
    }
    public String getpostal()
    {
        return postal ;
    }


}

