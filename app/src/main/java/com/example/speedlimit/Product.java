package com.example.speedlimit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import java.io.OutputStreamWriter;
public class Product extends AppCompatActivity {

    Button p55,p66;
    EditText p11,p22,p33,p44,p555,p666,p777;
    String P1Holder, P2Holder, P3Holder, P4Holder,P5Holder,P6Holder, P7Holder,   IdHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;
    String F_Result = "Not_Found";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
       p55 = (Button) findViewById(R.id.p5);
       p66 = (Button) findViewById(R.id.p6);

        p11 = (EditText) findViewById(R.id.p1);
        p22 = (EditText) findViewById(R.id.p2);
        p33 = (EditText) findViewById(R.id.p3);
        p44= (EditText) findViewById(R.id.p4);
        p555= (EditText) findViewById(R.id.p551);
        p666= (EditText) findViewById(R.id.p661);
        p777= (EditText) findViewById(R.id.p771);

        sqLiteHelper = new SQLiteHelper(this);

        p66.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(Product.this, Menu.class);
                startActivity(intent);

            }
        });
        // Adding click listener to register button.
        p55.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                // Creating SQLite database if dose n't exists
                SQLiteDataBaseBuild();

                // Creating SQLite table if dose n't exists.
                SQLiteTableBuild();

                // Checking EditText is empty or Not.
                CheckEditTextStatus();

                // Method to check Email is already exists or not.
                CheckingEmailAlreadyExistsOrNot();

                // Empty EditText After done inserting process.
                EmptyEditTextAfterDataInsert();


            }
        });
    }
    // SQLite database build method.
    public void SQLiteDataBaseBuild(){

        sqLiteDatabaseObj = openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    // SQLite table build method.
    public void SQLiteTableBuild() {

        sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS " + SQLiteHelper.TABLE_NAMEamb + "( " + SQLiteHelper.Table_Column_11_amb1 + " VARCHAR, " + SQLiteHelper.Table_Column_21_amb2 + " VARCHAR, " + SQLiteHelper.Table_Column_31_amb3 + " VARCHAR, " + SQLiteHelper.Table_Column_41_amb4 + " VARCHAR, " + SQLiteHelper.Table_Column_51_amb5 + " VARCHAR, " + SQLiteHelper.Table_Column_61_amb6 + " VARCHAR, " + SQLiteHelper.Table_Column_71_amb7 + " VARCHAR);");

    }

    // Insert data into SQLite database method.
    public void InsertDataIntoSQLiteDatabase(){

        // If editText is not empty then this block will executed.
        if(EditTextEmptyHolder == true)
        {

            // SQLite query to insert data into table.
            SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAMEamb + " (am1,am2,am3,am4,am5,am6,am7) VALUES('" + P1Holder + "', '" + P2Holder + "', '" + P3Holder + "', '" + P4Holder + "', '" + P5Holder + "', '" + P6Holder + "', '" + P7Holder + "');";

            // Executing query.
            sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);

            // Closing SQLite database object.
            sqLiteDatabaseObj.close();

            // Printing toast message after done inserting.
            Toast.makeText(Product.this,"Saved Successfully", Toast.LENGTH_LONG).show();

        }
        // This block will execute if any of the registration EditText is empty.
        else {

            // Printing toast message if any of EditText is empty.
            Toast.makeText(Product.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();

        }

    }

    // Empty edittext after done inserting process method.
    public void EmptyEditTextAfterDataInsert(){

        p11.getText().clear();

        p22.getText().clear();

        p33.getText().clear();
        p44.getText().clear();

    }

    // Method to check EditText is empty or Not.
    public void CheckEditTextStatus(){

        // Getting value from All EditText and storing into String Variables.
        P1Holder = p11.getText().toString();

        P2Holder = p22.getText().toString();
        P3Holder = p33.getText().toString();
        P4Holder = p44.getText().toString();
        P5Holder = p555.getText().toString();
        P6Holder = p666.getText().toString();
        P7Holder = p777.getText().toString();
        if( TextUtils.isEmpty(P1Holder) || TextUtils.isEmpty(P2Holder)|| TextUtils.isEmpty(P3Holder)){

            EditTextEmptyHolder = false ;

        }
        else {

            EditTextEmptyHolder = true ;
        }
    }

    // Checking Email is already exists or not.
    public void CheckingEmailAlreadyExistsOrNot(){

        // Opening SQLite database write permission.
        sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();

        // Adding search email query to cursor.
        cursor = sqLiteDatabaseObj.query(SQLiteHelper.TABLE_NAMEamb, null, " " + SQLiteHelper.Table_Column_11_amb1 + "=?", new String[]{P1Holder}, null, null, null);

        while (cursor.moveToNext()) {

            if (cursor.isFirst()) {

                cursor.moveToFirst();

                // If Email is already exists then Result variable value set as Email Found.
                F_Result = "Already Exists";

                // Closing cursor.
                cursor.close();
            }
        }

        // Calling method to check final result and insert data into SQLite database.
        CheckFinalResult();

    }


    // Checking result
    public void CheckFinalResult(){

        // Checking whether email is already exists or not.
        if(F_Result.equalsIgnoreCase("Found"))
        {

            // If email is exists then toast msg will display.
            Toast.makeText(Product.this,"Already Exists",Toast.LENGTH_LONG).show();

        }
        else {

            // If email already dose n't exists then user registration details will entered to SQLite database.
            InsertDataIntoSQLiteDatabase();

        }

        F_Result = "Not_Found" ;

    }

}
