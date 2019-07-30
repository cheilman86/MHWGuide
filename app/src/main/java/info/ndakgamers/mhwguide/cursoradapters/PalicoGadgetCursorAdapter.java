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

public class PalicoGadgetCursorAdapter extends CursorAdapter {
    public PalicoGadgetCursorAdapter(Context context, Cursor cursor){
        super(context,cursor,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.palico_gadget_view, parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Find fields to populate in inflated template
        TextView tvName = (TextView) view.findViewById(R.id.tvpalico1);
        TextView tvEffects = (TextView) view.findViewById(R.id.tvpalico3);
        TextView tvGet = (TextView) view.findViewById(R.id.tvpalico4);


        // Extract properties from cursor
        String setName = cursor.getString(1);
        String effects = cursor.getString(3);
        String howtoget = cursor.getString(4);

        // Populate fields with extracted properties
        tvName.setText(setName);
        tvEffects.setText(String.valueOf(effects));
        tvGet.setText(String.valueOf(howtoget));
    }
}
