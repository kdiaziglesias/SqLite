package com.example.kdiaziglesias.sqlite;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
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

        Log.d("Total", Integer.toString(MDB.recuperarCONTACTOS().size()));
        int[] ids = new int[MDB.recuperarCONTACTOS().size()];
        String[] noms = new String[MDB.recuperarCONTACTOS().size()];
        int [] tlfs = new int[MDB.recuperarCONTACTOS().size()];
        String [] emls = new String[MDB.recuperarCONTACTOS().size()];
        for (int i = 0; i < MDB.recuperarCONTACTOS().size(); i++) {
            ids[i] = MDB.recuperarCONTACTOS().get(i).getID();
            noms[i] = MDB.recuperarCONTACTOS().get(i).getNOMBRE();
            tlfs[i] = MDB.recuperarCONTACTOS().get(i).getTELEFONO();
            emls[i] = MDB.recuperarCONTACTOS().get(i).getEMAIL();
            Log.d(""+ids[i], noms[i] + ", " + tlfs[i] + ", " + emls[i]);
        }

        // Modificamos el registro 3
        MDB.modificarCONTACTO(3, "PPPPP", 121212121, "xxxx@xxxx.es");

        // Recuperamos el 3 registro y lo mostramos en el log
        int id = MDB.recuperarCONTACTO(3).getID();
        String nombre = MDB.recuperarCONTACTO(3).getNOMBRE();
        int telefono = MDB.recuperarCONTACTO(3).getTELEFONO();
        String email = MDB.recuperarCONTACTO(3).getEMAIL();
        Log.d(""+id, nombre + ", " + telefono + ", " + email);

        // Borramos el registro 3
        MDB.borrarCONTACTO(3);
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
