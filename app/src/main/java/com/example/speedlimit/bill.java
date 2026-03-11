package com.example.speedlimit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
public class bill extends AppCompatActivity {
    Button Register;

    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;
    String NameHolder,BnameHolder,LocHolder,BDHolder,DTHolder;
    Button save, refresh,bc1;
    EditText name,bname,loc1,dt1,bd1;
    private ListView listView;
    SQLiteHelper sqLiteHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);


        bc1 = (Button) findViewById(R.id.button8);

        dt1 = (EditText) findViewById(R.id.dt);
        bd1 = (EditText) findViewById(R.id.bd);
        sqLiteHelper = new SQLiteHelper(this);





        viewAll();

    }
    public Cursor getAllData() {
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();


        //    BnameHolder = bname.getText().toString() ;

        Cursor res = db.rawQuery("select * from "+sqLiteHelper.TABLE_NAMEamb +""  ,null );
        return res;
    }
    public void viewAll() {
        bc1.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View v) {


                        Cursor res = getAllData();
                        if(res.getCount() == 0) {
                            // show message

                            Toast.makeText(bill.this,"Nothing Found", Toast.LENGTH_LONG).show();
                            return;
                        }
                        DTHolder = dt1.getText().toString();
                        int a1,a2;
                        a1= Integer.valueOf(DTHolder);

                        a2=a1*10;
                        String strI = String.valueOf(a2);

                        StringBuffer buffer = new StringBuffer();
                        buffer.append( "AmbNo  " +  "Driver Name  " + "Distance Covered " + "Charges  " + "Amount " + "\n" );
                        while (res.moveToNext()) {



                            buffer.append( res.getString(0) + "    " + res.getString(1) + "    " + "    " +  DTHolder + "    " + res.getString(5) + "    " + strI +"\n" );
                            //buffer.append( " Driver Name : " +  res.getString(1)+ "\n"  );
                            //buffer.append( " Charges : " +  res.getString(2)+ "\n"  );
                            //buffer.append( " Size : " +  res.getString(3)+ "\n"  );


                        }
                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat mdformat = new SimpleDateFormat("dd / MM / yyyy ");
                        String strDate = mdformat.format(calendar.getTime());
                        // Show all data


                        showMessage("CASH-RECEIPT: ",buffer.toString() + "\n");

                    }
                }
        );
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}

