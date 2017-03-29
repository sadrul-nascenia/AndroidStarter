package com.example.pdfarhad.demoandroidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends Activity {
    private TextView demoLbl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ArrayList<String> receivedArray = getIntent().getStringArrayListExtra("RECEIVED_ARRAY");
        Log.d("Array = ",receivedArray.toString());

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, receivedArray);
        final ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedFromList = (String) listView.getItemAtPosition(position);

                Intent intent = new Intent(SecondActivity.this, DetailActivity.class);
                intent.putExtra("RECEIVED_STRING",selectedFromList);
                startActivity(intent);
            }
        });
    }
}
