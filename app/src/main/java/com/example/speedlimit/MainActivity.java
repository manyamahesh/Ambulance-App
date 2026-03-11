package com.example.speedlimit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.net.Uri;
public class MainActivity extends AppCompatActivity {
    Button login1,custlog1,btnview1,btnview11 ,drb1,mp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login1 = (Button)findViewById(R.id.loginbtn);
        custlog1 = (Button)findViewById(R.id.custlogin);
        drb1 = (Button)findViewById(R.id.drb);
       mp1 = (Button)findViewById(R.id.btnview3);
        btnview1 = (Button)findViewById(R.id.btnview2);
        btnview11 = (Button)findViewById(R.id.btnview);
        login1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(MainActivity.this, AdminLogin.class);
                startActivity(intent);

            }
        });
        drb1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(MainActivity.this, SendQuery.class);
                startActivity(intent);

            }
        });
       mp1.setOnClickListener(new View.OnClickListener() {

     public void onClick(View view) {

              // Opening new user registration activity using intent on button click.
          //  Intent intent = new Intent(MainActivity.this, MapActivity.class);
            //   startActivity(intent);
         String url = "https://www.google.com/maps/@12.9531904,77.7453568,12z?entry=ttu";
         if (url.startsWith("https://") || url.startsWith("http://")) {
             Uri uri = Uri.parse(url);
             Intent intent = new Intent(Intent.ACTION_VIEW, uri);
             startActivity(intent);
         }else{
             Toast.makeText(MainActivity.this, "Invalid Url", Toast.LENGTH_SHORT).show();
         }
            }
       });
        custlog1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(MainActivity.this, ClientloginActivity.class);
                startActivity(intent);

            }
        });
        btnview1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(MainActivity.this, viewproduct.class);
                startActivity(intent);

            }
        });

        btnview11.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(MainActivity.this, ViewBooked.class);
                startActivity(intent);

            }
        });
    }
}