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
public class dataset extends AppCompatActivity {
    Button Register;

    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;
    String NameHolder,BnameHolder;
    Button save, refresh;
    EditText name,bname;
    private ListView listView;
    SQLiteHelper sqLiteHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dataset);

        Register = (Button) findViewById(R.id.Re);
        sqLiteHelper = new SQLiteHelper(this);
        viewAll();
    }
    public Cursor getAllData() {
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();


        //    BnameHolder = bname.getText().toString() ;

        Cursor res = db.rawQuery("select * from "+sqLiteHelper.TABLE_NAME11+""  ,null);
        return res;
    }
    public void viewAll() {
        Register.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View v) {


                        Cursor res = getAllData();
                        if(res.getCount() == 0) {
                            // show message

                            Toast.makeText(dataset.this,"Nothing Found", Toast.LENGTH_LONG).show();
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        buffer.append( "Name  " + "Contact  " + "AmbNo   " + "Amount  " + "\n"  );
                        while (res.moveToNext()) {


                            //  if(TempPassword.equalsIgnoreCase(BnameHolder))
                            //    {

                            buffer.append(res.getString(0) +  "    " + res.getString(2) + "    " +res.getString(3)+ "     "+ "500"+ "\n"  );
                           // buffer.append( " Contact : " +  res.getString(2) + "\n" );
                           // buffer.append( " AmbNo : " +  res.getString(3) + "\n" );
                           // buffer.append( " Amount : " +  "500"  + "\n" );


                            //    }
                        }

                       // SQLiteDataBaseQueryHolder = "update  " + SQLiteHelper.TABLE_NAME11+ " set " +SQLiteHelper.Table_Column_9_Status1 + "=? "+ "  where " + SQLiteHelper.Table_Column_3_Ano + "=?", ("A",res.getString(2));

                        // Executing query.
                        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);

                        // Closing SQLite database object.
                        sqLiteDatabaseObj.close();




                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat mdformat = new SimpleDateFormat("dd / MM / yyyy ");
                        String strDate = mdformat.format(calendar.getTime());
                        // Show all data


                        showMessage("CASH-RECEIPT ",buffer.toString() + "\n");

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

