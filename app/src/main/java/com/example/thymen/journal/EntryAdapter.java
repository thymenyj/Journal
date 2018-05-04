package com.example.thymen.journal;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;

public class EntryAdapter extends ResourceCursorAdapter {

    public EntryAdapter(Context context, Cursor cursor) {
        super(context, cursor, R.layout.entry_row);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }
}


