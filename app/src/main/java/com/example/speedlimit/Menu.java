package com.example.speedlimit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class Menu extends AppCompatActivity {

    Button b11,b22,b33,b44;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        b11 = (Button) findViewById(R.id.b1);
        b22 = (Button) findViewById(R.id.b2);
        b33 = (Button) findViewById(R.id.b3);
        b44 = (Button) findViewById(R.id.b4);
       b11.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(Menu.this, Viewamb.class);
                startActivity(intent);

            }
        });

        b22.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(Menu.this, Product.class);
                startActivity(intent);

            }
        });

        b33.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(Menu.this, bill.class);
                startActivity(intent);

            }
        });
        b44.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(Menu.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }
}