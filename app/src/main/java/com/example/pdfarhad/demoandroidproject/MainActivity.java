package com.example.pdfarhad.demoandroidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private EditText username, password;
    private Button submitBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ArrayList <String> arrayList = new ArrayList<String>();
        arrayList.add("A");
        arrayList.add("B");

        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.editUserName);
        password = (EditText) findViewById(R.id.editPassword);
        submitBtn = (Button) findViewById(R.id.button);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("demo") && password.getText().toString().equals("1234")){
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putStringArrayListExtra("RECEIVED_ARRAY",arrayList);
                    startActivity(intent);
                }else{
                    Toast toast= Toast.makeText(getApplicationContext(),
                            "Error", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
            }
        });
    }
}
