package com.example.speedlimit;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ClientloginActivity extends AppCompatActivity {

    ImageView image;

    Button LogInButton, RegisterButton,hButton,pbut,b22 ;
    EditText Email, Password ;
    String EmailHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;
    String TempPassword = "NOT_FOUND" ;
    public static final String UserEmail = "";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientlogin);


        LogInButton = (Button) findViewById(R.id.b11);


        b22 = (Button) findViewById(R.id.b22can);

        Email = (EditText) findViewById(R.id.t1);
        Password = (EditText) findViewById(R.id.t2);

        LogInButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                EmailHolder = Email.getText().toString();
                PasswordHolder = Password.getText().toString();
             if ((EmailHolder.equals("admin")) && (PasswordHolder.equals("admin"))) {
                 Intent intent = new Intent(ClientloginActivity.this, Menu.class);
                 startActivity(intent);
             }

            }
        });


        b22.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(ClientloginActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

}
