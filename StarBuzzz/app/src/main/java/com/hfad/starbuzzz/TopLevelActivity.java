package com.hfad.starbuzzz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TopLevelActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        // create onItemClickListeners
        AdapterView.OnItemClickListener itemClickListener = new  AdapterView.OnItemClickListener(){
            public void onItemClick (AdapterView<?> listView, View itemView, int position, long id){
             if (position == 0){
                 Intent intent = new Intent(TopLevelActivity.this, DrinkcategoryActivity.class);
                 startActivity(intent);
             }

            }


        };

        //add Listeners to view list
        ListView listView = (ListView) findViewById(R.id.List_Options);
        listView.setOnItemClickListener(itemClickListener);





    }


}
