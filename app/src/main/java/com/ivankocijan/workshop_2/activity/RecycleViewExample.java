package com.ivankocijan.workshop_2.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.ivankocijan.workshop_2.R;
import com.ivankocijan.workshop_2.adapter.CustomAdapter;
import com.ivankocijan.workshop_2.model.POJO;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewExample extends ActionBarActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<POJO> list;


    private Button addNewItem;
    private Button removeItem;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_example);

        addNewItem = (Button) findViewById(R.id.add_new_item_to_list_rv);
        removeItem = (Button) findViewById(R.id.remoce_item_from_list_rv);

        list = new ArrayList<POJO>();

        for (int i = 0; i < 5; i++) {
            list.add(new POJO(String.valueOf(i)));
        }

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // RecyclerView can perform several optimizations
        // if it can know in advance that changes in adapter content cannot
        // change the size of the RecyclerView itself.
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CustomAdapter(list);
        recyclerView.setAdapter(adapter);

        addNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {

                int newItemNumber = list.size();

                list.add(new POJO(String.valueOf(newItemNumber)));
                adapter.notifyDataSetChanged();

            }
        });

        removeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {

                if (list.size() != 0) {

                    list.remove(list.size() - 1);
                    adapter.notifyDataSetChanged();

                }


            }
        });


    }

}
