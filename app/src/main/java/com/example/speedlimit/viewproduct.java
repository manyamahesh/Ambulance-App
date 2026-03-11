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
public class viewproduct extends AppCompatActivity {
    Button Register;

    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;
    String NameHolder,BnameHolder,LocHolder;
    Button save, refresh,bc1;
    EditText name,bname,loc1;
    private ListView listView;
    SQLiteHelper sqLiteHelper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewproduct);

        Register = (Button) findViewById(R.id.BtnV);
        bc1 = (Button) findViewById(R.id.button4);
        loc1 = (EditText) findViewById(R.id.loc);
        sqLiteHelper = new SQLiteHelper(this);
        viewAll();





        bc1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(viewproduct.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
    public Cursor getAllData() {
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();

        LocHolder = loc1.getText().toString();
        //    BnameHolder = bname.getText().toString() ;

        Cursor res = db.rawQuery("select * from "+sqLiteHelper.TABLE_NAMEamb + " where " + SQLiteHelper.Table_Column_71_amb7 + "=?", new String[]{LocHolder}  );
        return res;
    }
    public void viewAll() {
        Register.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View v) {


                        Cursor res = getAllData();
                        if(res.getCount() == 0) {
                            // show message

                            Toast.makeText(viewproduct.this,"Nothing Found", Toast.LENGTH_LONG).show();
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        buffer.append( "AmbNo  " +  "Driver Name  " + "Driver Contact  " + "Charges  " + "Location " + "\n" );
                        while (res.moveToNext()) {



                            buffer.append( res.getString(0) + "    " + res.getString(1) + "    " + "    " +  res.getString(2) + "    " + res.getString(5) + "    " + res.getString(6) +"\n" );
                            //buffer.append( " Driver Name : " +  res.getString(1)+ "\n"  );
                            //buffer.append( " Charges : " +  res.getString(2)+ "\n"  );
                            //buffer.append( " Size : " +  res.getString(3)+ "\n"  );


                        }
                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat mdformat = new SimpleDateFormat("dd / MM / yyyy ");
                        String strDate = mdformat.format(calendar.getTime());
                        // Show all data


                        showMessage("Ambulance Detail: ",buffer.toString() + "\n");

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

