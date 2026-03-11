package com.example.speedlimit;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME = "speed";

    public static final String TABLE_NAME = "register";
    public static final String Table_Column_ID = "id";



    public static final String TABLE_NAME3 = "reg";
    public static final String Table_Column_Id = "id";

    public static final String Table_Column_1_Mobile = "mobile";

    public static final String Table_Column_2_Un = "un";

    public static final String Table_Column_3_Pw = "pw";
    //sendquerytable

    public static final String TABLE_NAME1 = "sendquery";


    public static final String Table_Column_1_Fname = "b1";

    public static final String Table_Column_2_Address = "b2";

    public static final String Table_Column_3_Contact = "b3";

    public static final String Table_Column_4_Ano = "b4";
    public static final String Table_Column_5_Atype = "b5";
    public static final String Table_Column_6_Asize = "b6";
    public static final String Table_Column_7_Loc = "b7";
    public static final String Table_Column_8_Time = "b8";
    public static final String Table_Column_9_Status = "b9";


    public static final String TABLE_NAME11 = "sendquery1";


    public static final String Table_Column_1_Fname1 = "b11";

    public static final String Table_Column_2_Address1 = "b22";

    public static final String Table_Column_3_Contact1 = "b33";

    public static final String Table_Column_4_Ano1 = "b44";
    public static final String Table_Column_5_Atype1 = "b55";
    public static final String Table_Column_6_Asize1 = "b66";
    public static final String Table_Column_7_Loc1 = "b77";
    public static final String Table_Column_8_Time1 = "b88";
    public static final String Table_Column_9_Status1 = "b99";




    public static final String TABLE_NAME4 = "product";


    public static final String Table_Column_1_P1 = "p11";
    public static final String Table_Column_2_P2= "p22";
    public static final String Table_Column_3_P3 = "p33";
    public static final String Table_Column_4_P4 = "p44";
    public static final String Table_Column_5_P5 = "pd5";
    public static final String Table_Column_6_P6 = "pp66";
    public static final String Table_Column_7_P7 = "pp77";



    public static final String TABLE_NAME555 = "amb1";


    public static final String Table_Column_11_P1 = "a1";
    public static final String Table_Column_21_P2 = "a2";
    public static final String Table_Column_31_P3 = "a3";
    public static final String Table_Column_41_P4 = "a4";
    public static final String Table_Column_51_P5 = "a5";
    public static final String Table_Column_61_P6 = "a6";
    public static final String Table_Column_71_P7 = "a7";

    public static final String TABLE_NAMEamb = "addamb";


    public static final String Table_Column_11_amb1 = "am1";
    public static final String Table_Column_21_amb2 = "am2";
    public static final String Table_Column_31_amb3 = "am3";
    public static final String Table_Column_41_amb4 = "am4";
    public static final String Table_Column_51_amb5 = "am5";
    public static final String Table_Column_61_amb6 = "am6";
    public static final String Table_Column_71_amb7 = "am7";




    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }


    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME1 + " (" + Table_Column_1_Fname + " VARCHAR, " + Table_Column_2_Address + " VARCHAR, " + Table_Column_3_Contact + " VARCHAR, " + Table_Column_4_Ano + " VARCHAR, " + Table_Column_5_Atype + " VARCHAR, " + Table_Column_6_Asize + " VARCHAR, " + Table_Column_7_Loc + " VARCHAR, " + Table_Column_8_Time + " VARCHAR, " + Table_Column_9_Status + " VARCHAR)";
        database.execSQL(CREATE_TABLE);
        String CREATE_TABLE1 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME3 + " (" + Table_Column_Id + " VARCHAR, " + Table_Column_1_Mobile + " VARCHAR, " + Table_Column_2_Un + " VARCHAR, " + Table_Column_3_Pw + " VARCHAR)";
        database.execSQL(CREATE_TABLE1);
        String CREATE_TABLE2 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME4 + " (" + Table_Column_1_P1 + " VARCHAR, " + Table_Column_2_P2 + " VARCHAR, " + Table_Column_3_P3 + " VARCHAR, " + Table_Column_4_P4 + " VARCHAR, " + Table_Column_5_P5 + " VARCHAR, " + Table_Column_6_P6 + " VARCHAR, " + Table_Column_7_P7 + " VARCHAR)";
        database.execSQL(CREATE_TABLE2);

        String CREATE_TABLE4 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME11 + " (" + Table_Column_1_Fname1 + " VARCHAR, " + Table_Column_2_Address1 + " VARCHAR, " + Table_Column_3_Contact1 + " VARCHAR, " + Table_Column_4_Ano1 + " VARCHAR, " + Table_Column_5_Atype1 + " VARCHAR, " + Table_Column_6_Asize1 + " VARCHAR, " + Table_Column_7_Loc1 + " VARCHAR, " + Table_Column_8_Time1 + " VARCHAR, " + Table_Column_9_Status1 + " VARCHAR)";
        database.execSQL(CREATE_TABLE4);
        String CREATE_TABLE6 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAMEamb + " (" + Table_Column_11_amb1 + " VARCHAR, " + Table_Column_21_amb2 + " VARCHAR, " + Table_Column_31_amb3 + " VARCHAR, " + Table_Column_41_amb4 + " VARCHAR, " + Table_Column_51_amb5 + " VARCHAR, " + Table_Column_61_amb6 + " VARCHAR, " + Table_Column_71_amb7 + " VARCHAR)";
        database.execSQL(CREATE_TABLE6);
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

}
