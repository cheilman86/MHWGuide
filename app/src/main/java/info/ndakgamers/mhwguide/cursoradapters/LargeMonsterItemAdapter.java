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

public class LargeMonsterItemAdapter extends CursorAdapter {
    public LargeMonsterItemAdapter(Context context, Cursor cursor){
        super(context,cursor,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.monster_item_view, parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Find fields to populate in inflated template
        TextView tvName = (TextView) view.findViewById(R.id.tv_itemName);
        TextView tvitemLocation = (TextView) view.findViewById(R.id.tv_itemLocation);
        TextView tvrarityValue = (TextView) view.findViewById(R.id.tv_rarityValue);


        // Extract properties from cursor
        String setName = cursor.getString(1);
        String location = cursor.getString(2);
        int rarity = cursor.getInt(3);


        // Populate fields with extracted properties
        tvName.setText(String.valueOf(setName));
        tvitemLocation.setText(String.valueOf(location));
        tvrarityValue.setText(String.valueOf(rarity));
    }
}
