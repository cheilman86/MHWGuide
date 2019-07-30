package info.ndakgamers.mhwguide.cursoradapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import info.ndakgamers.mhwguide.R;

/**
 * Created on 3/26/2018.
 */

public class MaterialSearchAdapter extends CursorAdapter {
    public MaterialSearchAdapter(Context context, Cursor cursor){
        super(context,cursor,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.search_item, parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Find fields to populate in inflated template
        TextView tvName = (TextView) view.findViewById(R.id.search_name);
        TextView tvitemLocation = (TextView) view.findViewById(R.id.search_summary);



        // Extract properties from cursor
        String setName = cursor.getString(1);
        String location = cursor.getString(2);



        // Populate fields with extracted properties
        tvName.setText(String.valueOf(setName));
        tvitemLocation.setText(String.valueOf(location));

    }
}
