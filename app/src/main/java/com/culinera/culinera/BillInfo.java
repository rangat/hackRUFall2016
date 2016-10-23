package com.culinera.culinera;

import java.io.Serializable;

/**
 * Created by Arjun Bansil on 10/23/2016.
 */

public class BillInfo implements Serializable {
    String date, chamber, context;
    public BillInfo(String d, String c, String con ){
        this.date = d;
        this.chamber = c;
        this.context = con;
    }

    public String getDate(){
        return this.date;
    }

    public String getChamber(){
        return this.chamber;
    }

    public String getContext(){
        return this.context;

    }
}
