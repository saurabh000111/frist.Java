package com.hfad.starbuzzz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkcategoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinkcategory);
        ArrayAdapter<Drink>  listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Drink.drinks);
        ListView drinkList = (ListView) findViewById(R.id.List_Options);
        drinkList.setAdapter(listAdapter);
    }
}
