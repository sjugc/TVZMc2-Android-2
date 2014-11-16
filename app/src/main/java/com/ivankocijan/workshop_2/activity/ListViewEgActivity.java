package com.ivankocijan.workshop_2.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.ivankocijan.workshop_2.R;
import com.ivankocijan.workshop_2.adapter.ListAdapter;
import com.ivankocijan.workshop_2.model.POJO;

import java.util.ArrayList;

public class ListViewEgActivity extends Activity {

    private ListView simpleListView;
    private ArrayList<POJO> pojoArrayList;
    private ListAdapter adapter;

    private Button addNewItem;
    private Button removeItem;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item_eg);

        simpleListView = (ListView) findViewById(R.id.simple_list);
        addNewItem = (Button) findViewById(R.id.add_new_item_to_list);
        removeItem = (Button) findViewById(R.id.remoce_item_from_list);

        pojoArrayList = new ArrayList<POJO>();

        for (int i = 0; i < 5; i++) {
            pojoArrayList.add(new POJO(String.valueOf(i)));
        }

        adapter = new ListAdapter(this, pojoArrayList);
        simpleListView.setAdapter(adapter);
        simpleListView.setEmptyView(findViewById(R.id.simple_list_empty_view));

        addNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {

                int newItemNumber = pojoArrayList.size();

                pojoArrayList.add(new POJO(String.valueOf(newItemNumber)));
                adapter.notifyDataSetChanged();

            }
        });

        removeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {

                if (pojoArrayList.size() != 0) {

                    pojoArrayList.remove(pojoArrayList.size() - 1);
                    adapter.notifyDataSetChanged();

                }


            }
        });


    }

}
