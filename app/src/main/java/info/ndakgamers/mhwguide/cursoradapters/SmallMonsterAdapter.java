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

public class SmallMonsterAdapter extends CursorAdapter {

    public SmallMonsterAdapter(Context context, Cursor cursor){
        super(context,cursor,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.small_monster_layout, parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Find fields to populate in inflated template
        TextView tvName = (TextView) view.findViewById(R.id.monsterName1);
        TextView tvElement = (TextView) view.findViewById(R.id.monEle2);
        TextView tvAilments = (TextView) view.findViewById(R.id.monAil3);
        TextView tvWeakness = (TextView) view.findViewById(R.id.monWeak4);
        TextView tvResist = (TextView) view.findViewById(R.id.monResist5);
        TextView tvLocation = (TextView) view.findViewById(R.id.monLoc6);


        // Extract properties from cursor
        String name = cursor.getString(1);
        String element = cursor.getString(2);
        String ailments = cursor.getString(3);
        String weakness = cursor.getString(4);
        String resistance = cursor.getString(5);
        String location = cursor.getString(6);


        // Creating new lines for separate values in the string
        element = element.replace(",","\n");
        ailments = ailments.replace(",","\n");
        weakness = weakness.replace(",","\n");
        weakness = weakness.replace("*","⭐");
        resistance = resistance.replace(",","\n");
        location = location.replace(",","\n");


        // Populate fields with extracted properties
        tvName.setText(name);
        tvElement.setText(String.valueOf(element));
        tvAilments.setText(String.valueOf(ailments));
        tvWeakness.setText(String.valueOf(weakness));
        tvResist.setText(String.valueOf(resistance));
        tvLocation.setText(String.valueOf(location));






    }
}
