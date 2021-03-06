package com.example.thymen.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());

        EntryAdapter adapter = new EntryAdapter(getApplicationContext(), );
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }

    public void onButtonClicked(View v) {
        Intent myIntent = new Intent(MainActivity.this,
                InputActivity.class);
        startActivity(myIntent);
    }


    private class OnItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    }

    private class OnItemLongClickListener implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            EntryDatabase.delete();
            return false;
        }
    }
}

