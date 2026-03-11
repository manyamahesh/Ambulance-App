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
public class RegisterActivity extends AppCompatActivity {

    Button reg1,bn11;
    EditText txtid1, txtmobile1, txtun1, txtpw1;
    String IdHolder, MobileHolder, UnHolder, PwHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;
    String F_Result = "Not_Found";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        reg1 = (Button) findViewById(R.id.register);
        bn11 = (Button) findViewById(R.id.button6);
        txtid1 = (EditText) findViewById(R.id.txtid);
        txtmobile1 = (EditText) findViewById(R.id.txtmobile);
        txtun1 = (EditText) findViewById(R.id.txtun);
        txtpw1 = (EditText) findViewById(R.id.txtpw);

        sqLiteHelper = new SQLiteHelper(this);

        bn11.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(RegisterActivity.this, AdminLogin.class);
                startActivity(intent);

            }
        });
        // Adding click listener to register button.
        reg1.setOnClickListener(new View.OnClickListener() {

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

        sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS " + SQLiteHelper.TABLE_NAME3 + "(" + SQLiteHelper.Table_Column_Id + " VARCHAR, " + SQLiteHelper.Table_Column_1_Mobile + " VARCHAR, " + SQLiteHelper.Table_Column_2_Un + " VARCHAR, " + SQLiteHelper.Table_Column_3_Pw + " VARCHAR);");

    }

    // Insert data into SQLite database method.
    public void InsertDataIntoSQLiteDatabase(){

        // If editText is not empty then this block will executed.
        if(EditTextEmptyHolder == true)
        {

            // SQLite query to insert data into table.
            SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME3 + " (id,mobile,un,pw) VALUES('" + IdHolder + "', '" + MobileHolder + "', '" + UnHolder + "', '" + PwHolder + "');";

            // Executing query.
            sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);

            // Closing SQLite database object.
            sqLiteDatabaseObj.close();

            // Printing toast message after done inserting.
            Toast.makeText(RegisterActivity.this,"Saved Successfully", Toast.LENGTH_LONG).show();

        }
        // This block will execute if any of the registration EditText is empty.
        else {

            // Printing toast message if any of EditText is empty.
            Toast.makeText(RegisterActivity.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();

        }

    }

    // Empty edittext after done inserting process method.
    public void EmptyEditTextAfterDataInsert(){

        txtid1.getText().clear();

        txtmobile1.getText().clear();

        txtun1.getText().clear();
        txtpw1.getText().clear();

    }

    // Method to check EditText is empty or Not.
    public void CheckEditTextStatus(){

        // Getting value from All EditText and storing into String Variables.
        IdHolder = txtid1.getText().toString();

        MobileHolder = txtmobile1.getText().toString();
        UnHolder = txtun1.getText().toString();
        PwHolder = txtpw1.getText().toString();


        if(TextUtils.isEmpty(IdHolder) || TextUtils.isEmpty(MobileHolder) || TextUtils.isEmpty(UnHolder)|| TextUtils.isEmpty(PwHolder)){

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
        cursor = sqLiteDatabaseObj.query(SQLiteHelper.TABLE_NAME3, null, " " + SQLiteHelper.Table_Column_Id + "=?", new String[]{IdHolder}, null, null, null);

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
            Toast.makeText(RegisterActivity.this,"Already Exists",Toast.LENGTH_LONG).show();

        }
        else {

            // If email already dose n't exists then user registration details will entered to SQLite database.
            InsertDataIntoSQLiteDatabase();

        }

        F_Result = "Not_Found" ;

    }

}
