package com.example.speedlimit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
public class ViewBook extends AppCompatActivity {

    Button vb11,vb7;


    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;
    String NameHolder,BnameHolder,LocHolder;
    Button save, refreshvb7;
    EditText name,bname,loc1;
    private ListView listView;
    SQLiteHelper sqLiteHelper;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_book);





        vb11 = (Button) findViewById(R.id.button2);
        vb7 = (Button) findViewById(R.id.button7);

        sqLiteHelper = new SQLiteHelper(this);
        viewAll();
        vb7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(ViewBook.this, Menu.class);
                startActivity(intent);

            }
        });
    }
    public Cursor getAllData() {
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();


        //    BnameHolder = bname.getText().toString() ;

        Cursor res = db.rawQuery("select * from "+sqLiteHelper.TABLE_NAME11 +""  ,null );
        return res;
    }
    public void viewAll() {
        vb11.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View v) {


                        Cursor res = getAllData();
                        if(res.getCount() == 0) {
                            // show message

                            Toast.makeText(ViewBook.this,"Nothing Found", Toast.LENGTH_LONG).show();
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        buffer.append( "AmbNo  "  + " Location  " + " Status "+"\n" );
                        while (res.moveToNext()) {



                            buffer.append( res.getString(0)  + "            " + res.getString(6) + "            " + res.getString(8) +"\n" );
                            //buffer.append( " Driver Name : " +  res.getString(1)+ "\n"  );
                            //buffer.append( " Charges : " +  res.getString(2)+ "\n"  );
                            //buffer.append( " Size : " +  res.getString(3)+ "\n"  );


                        }
                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat mdformat = new SimpleDateFormat("dd / MM / yyyy ");
                        String strDate = mdformat.format(calendar.getTime());
                        // Show all data


                        showMessage("Booked Ambulance: ",buffer.toString() + "\n");

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

