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
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.widget.Button;
import android.widget.Toast;
public class MapActivity extends AppCompatActivity {
    Button reg1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        reg1 = (Button) findViewById(R.id.button);
        reg1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {







                        // TODO Auto-generated method stub
                        String url = "http://www.gobloggerslive.com";

                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);



            }
        });


    }
}