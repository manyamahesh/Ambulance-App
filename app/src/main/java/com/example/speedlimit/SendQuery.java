package com.example.speedlimit;

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

public class SendQuery extends AppCompatActivity {
    Button btnsend1, cancel1,getloc1,btnsave1;
    EditText txt11, txt22, txt33, txt44, txt55, txt66,txt77,txt88;
    String T1Holder, T2Holder, T3Holder, T4Holder, T5Holder, T6Holder, T7Holder, T8Holder, T9Holder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;
    String F_Result = "Not_Found";
    String STORETEXT="storetext.txt";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_query);
        btnsend1 = (Button) findViewById(R.id.btnsend);


        cancel1 = (Button) findViewById(R.id.btncancel);
        txt11 = (EditText) findViewById(R.id.txt1);
        txt22 = (EditText) findViewById(R.id.txt2);
        txt33 = (EditText) findViewById(R.id.txt3);
        txt44 = (EditText) findViewById(R.id.txt4);
        txt55 = (EditText) findViewById(R.id.txt5);
        txt66 = (EditText) findViewById(R.id.txt6);
        txt77= (EditText) findViewById(R.id.txt7);
        txt88 = (EditText) findViewById(R.id.txt8);
        sqLiteHelper = new SQLiteHelper(this);





        // Adding click listener to register button.
        btnsend1.setOnClickListener(new View.OnClickListener() {

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

        cancel1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(SendQuery.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }
    // SQLite database build method.
    public void SQLiteDataBaseBuild(){

        sqLiteDatabaseObj = openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    // SQLite table build method.
    public void SQLiteTableBuild() {

        sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS " + SQLiteHelper.TABLE_NAME11 + "(" + SQLiteHelper.Table_Column_1_Fname1 + " VARCHAR, " + SQLiteHelper.Table_Column_2_Address1 + " VARCHAR, " + SQLiteHelper.Table_Column_3_Contact1 + " VARCHAR, " + SQLiteHelper.Table_Column_4_Ano1 + " VARCHAR, " + SQLiteHelper.Table_Column_5_Atype1 + " VARCHAR, " + SQLiteHelper.Table_Column_6_Asize1 + " VARCHAR, " + SQLiteHelper.Table_Column_7_Loc1 + " VARCHAR, " + SQLiteHelper.Table_Column_8_Time1 + " VARCHAR, " + SQLiteHelper.Table_Column_9_Status1 + " VARCHAR);");

    }

    // Insert data into SQLite database method.
    public void InsertDataIntoSQLiteDatabase(){

        // If editText is not empty then this block will executed.
        if(EditTextEmptyHolder == true)
        {

            // SQLite query to insert data into table.
            SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME11 + " (b11,b22,b33,b44,b55,b66,b77,b88,b99) VALUES('" + T1Holder + "', '" + T2Holder + "', '" + T3Holder + "', '" + T4Holder + "', '" + T5Holder + "', '" + T6Holder + "', '" + T7Holder + "', '" + T8Holder + "', '" + T9Holder + "');";

            // Executing query.
            sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);

            // Closing SQLite database object.
            sqLiteDatabaseObj.close();

            // Printing toast message after done inserting.
            Toast.makeText(SendQuery.this,"Saved Successfully", Toast.LENGTH_LONG).show();

        }
        // This block will execute if any of the registration EditText is empty.
        else {

            // Printing toast message if any of EditText is empty.
            Toast.makeText(SendQuery.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();

        }

    }

    // Empty edittext after done inserting process method.
    public void EmptyEditTextAfterDataInsert(){

        txt11.getText().clear();

        txt22.getText().clear();

        txt33.getText().clear();
        txt44.getText().clear();
        txt55.getText().clear();
        txt66.getText().clear();
        txt77.getText().clear();
        txt88.getText().clear();

    }

    // Method to check EditText is empty or Not.
    public void CheckEditTextStatus(){

        // Getting value from All EditText and storing into String Variables.
        T1Holder = txt11.getText().toString();
        T2Holder = txt22.getText().toString();
        T3Holder = txt33.getText().toString();
        T4Holder = txt44.getText().toString();
        T5Holder = txt55.getText().toString();
        T6Holder = txt66.getText().toString();
        T7Holder = txt77.getText().toString();
        T8Holder = txt88.getText().toString();
        T9Holder = "B";
        if(TextUtils.isEmpty(T1Holder) || TextUtils.isEmpty(T2Holder) || TextUtils.isEmpty(T3Holder)|| TextUtils.isEmpty(T4Holder)){

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
        cursor = sqLiteDatabaseObj.query(SQLiteHelper.TABLE_NAME11, null, " " + SQLiteHelper.Table_Column_1_Fname1 + "=?", new String[]{T1Holder}, null, null, null);

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
            Toast.makeText(SendQuery.this,"Already Exists",Toast.LENGTH_LONG).show();

        }
        else {

            // If email already dose n't exists then user registration details will entered to SQLite database.
            InsertDataIntoSQLiteDatabase();

        }

        F_Result = "Not_Found" ;

    }

}
