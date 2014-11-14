package project.android.csci4661.com.wallet;


import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.app.ListActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;


public class homeScreen extends ListActivity {

    private static final String ITEMS = "items";
    private SharedPreferences savedItems;
    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        savedItems = getSharedPreferences(ITEMS, MODE_PRIVATE);

        items = new ArrayList<String>(savedItems.getAll().keySet());
        Collections.sort(items, String.CASE_INSENSITIVE_ORDER);

        adapter = new ArrayAdapter<String>(this, R.layout.list_item, items);
        setListAdapter(adapter);

        getListView().setOnItemClickListener(itemClickListener);

        SharedPreferences.Editor preferencesEditor = savedItems.edit();
        preferencesEditor.putString("1","1");
        preferencesEditor.putString("2","2");
        preferencesEditor.putString("3","3");
        preferencesEditor.putString("4","4");
        preferencesEditor.apply();

    }

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view,
                                int position, long id)
        {
            Intent myIntent = new Intent(homeScreen.this, walletItem.class);
            homeScreen.this.startActivity(myIntent);
        }
    };




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
