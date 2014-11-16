package com.ivankocijan.workshop_2.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ivankocijan.workshop_2.R;


public class MainActivity extends Activity {

    private Button listViewExample;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewExample = (Button) findViewById(R.id.button_list_view_eg);

        listViewExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {

                startActivity(new Intent(MainActivity.this, ListViewEgActivity.class));

            }
        });

    }


}
