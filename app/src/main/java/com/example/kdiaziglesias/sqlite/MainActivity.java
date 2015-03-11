package com.example.kdiaziglesias.sqlite;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());

        MDB.insertarCONTACTO(1,"Pedro",1111111,"pedro@DB.es");
        MDB.insertarCONTACTO(2,"Sandra",2222222,"sandra@DB.es");
        MDB.insertarCONTACTO(3,"Maria",1111111,"Maria@DB.es");
        MDB.insertarCONTACTO(4,"Daniel",1111111,"daniel@DB.es");

        //Log.d("Total",Integer.toString(MDB.));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
