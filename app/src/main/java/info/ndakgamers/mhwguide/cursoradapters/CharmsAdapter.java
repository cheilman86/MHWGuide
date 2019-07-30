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

public class CharmsAdapter extends CursorAdapter {
    public CharmsAdapter(Context context, Cursor cursor){
        super(context,cursor,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.charms_view_adapter, parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Find fields to populate in inflated template
        TextView tvName = (TextView) view.findViewById(R.id.tv_charmName);
        TextView tvEffect = (TextView) view.findViewById(R.id.tv_charmEffect);
        TextView tvrarityValue = (TextView) view.findViewById(R.id.tv_charmRarity);


        // Extract properties from cursor
        String setName = cursor.getString(2);
        String effect = cursor.getString(3);
        int rarity = cursor.getInt(1);


        // Populate fields with extracted properties
        tvName.setText(String.valueOf(setName));
        tvEffect.setText(String.valueOf(effect));
        tvrarityValue.setText(String.valueOf(rarity));
    }
}
