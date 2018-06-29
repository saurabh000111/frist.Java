package com.hfad.beeradvisor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Spinner;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindBeer(View view){
        // get reference to text view
        TextView brands  = (TextView) findViewById(R.id.Brands);
        // get reference of spinner
        Spinner color = (Spinner) findViewById(R.id.color);
        // get selected items in string
        String beerType = String.valueOf(color.getSelectedItem());
        // display the selected items
        brands.setText(beerType);
    }
}
