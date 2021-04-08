package com.tess.futrash.shared_pref;

import android.content.Context;
import android.content.SharedPreferences;

public class SpHandle {

    public static final String SP_FOOD_TRASH_CUSTOMER_APP = "FtCustomer";

    public static final String SP_ID_USER = "spIdUser";
    public static final String SP_TOKEN_USER = "spTokenUser";
    public static final String SP_ID_CHART="spIdChart";
    public static final String SP_ID_ORDER="spIdOrder";
    public static final String SP_ID_CONFIRM_ORDER="spIdConfirmOrder";
    public static final String SP_ID_ITEM="spIdItem";

    public  static final  String SP_NAMA_CUST="spNamaCust";
    public static  final  String SP_EMAIL_CUST="spEmailCust";
    public static final String SP_PHONE_CUST="spPhoneCust";
    public static final String SP_ROLE_CUST="spRoleCust";

    public static final String SP_ID_MITRA_ITEM="spIdMitra";

    public static final String SP_HAVE_LOGIN = "spHaveLogin";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SpHandle(Context context){
        sp = context.getSharedPreferences(SP_FOOD_TRASH_CUSTOMER_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void setSpTokenUser(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void setSpIdUser(String keySP, Long value){
        spEditor.putLong(keySP, value);
        spEditor.commit();
    }

    public void setIdMitraItem(String keySp, Long value){
        spEditor.putLong(keySp,value);
        spEditor.commit();
    }

    public void setSpIdChart(String keySP, Long value){
        spEditor.putLong(keySP,value);
        spEditor.commit();
    }

    public void setSpIdOrder(String keySP, Long value){
        spEditor.putLong(keySP,value);
        spEditor.commit();
    }

    public void setSpIdConfirm(String keySP, Long value){
        spEditor.putLong(keySP,value);
        spEditor.commit();
    }

    public void setSpNamaCust(String keySp, String value){
        spEditor.putString(keySp,value);
        spEditor.commit();
    }

    public void setSpEmailCust(String keySP, String value){
        spEditor.putString(keySP,value);
        spEditor.commit();
    }

    public void setSpPhoneCust(String keySP, String value){
        spEditor.putString(keySP,value);
        spEditor.commit();
    }

    public  void setSpRoleCust(String keySP, String value){
        spEditor.putString(keySP,value);
        spEditor.commit();
    }

    public void setSpIdItem(String keySp, Long value){
        spEditor.putLong(keySp, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getSpTokenUser(){
        return sp.getString(SP_TOKEN_USER, "");
    }

    public Long getSpIdUser(){
        return sp.getLong(SP_ID_USER, 0);
    }

    public Long getSpIdChart(){
        return sp.getLong(SP_ID_CHART,0);
    }

    public Long getSpIdOrder(){
        return  sp.getLong(SP_ID_ORDER,0);
    }

    public Long getSpIdConfirm(){
        return  sp.getLong(SP_ID_CONFIRM_ORDER,0);
    }

    public String getSpNamaCust(){
        return  sp.getString(SP_NAMA_CUST,"");

    }

    public String getSpEmailCust(){
        return  sp.getString(SP_EMAIL_CUST,"");
    }

    public String getSpPhoneCust(){
        return  sp.getString(SP_PHONE_CUST,"");
    }

    public String getSpRoleCust(){
        return  sp.getString(SP_ROLE_CUST,"");

    }

    public  Long getIdMitra(){
        return  sp.getLong(SP_ID_MITRA_ITEM, 0);
    }

    public Long getSpIdItem(){
        return  sp.getLong(SP_ID_ITEM,0);
    }

    public Boolean getHaveLogin(){
        return sp.getBoolean(SP_HAVE_LOGIN, false);
    }

}
